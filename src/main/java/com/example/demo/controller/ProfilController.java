package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;
import com.example.demo.ServiceInter.DataModelService;
import com.example.demo.model.Association;
import com.example.demo.model.Category;
import com.example.demo.model.DlmsTransaction;
import com.example.demo.model.OperationType;
import com.example.demo.model.OperationTypes;
import com.example.demo.model.Profil;
import com.example.demo.service.AssociationService;
import com.example.demo.service.CosemAssocier;
import com.example.demo.service.OperationService;
import com.example.demo.service.ProfilService;
import com.example.demo.service.TransactionService;

@RestController
public class ProfilController {
	@Autowired
	private ProfilService profilService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private OperationService operationService;
	@Autowired 
	private DataModelService dataService;
	@Autowired 
	private AssociationService associationService;
	public ProfilController(ProfilService profilService) {
		super();
		this.profilService = profilService;
	}
	@PostMapping("/importerZip")
	public Object Import(@RequestParam("file") MultipartFile file) throws IOException
	{
		return profilService.Inserer(file);
	}
	@GetMapping("/profils")
	public Object GetAllProfils()
	{
		return profilService.findAll();
	}
	@GetMapping("Profil_description/{name}/{dataModel}/{category}")
	public Object ProfilDescription(@PathVariable String name,@PathVariable String dataModel,@PathVariable String category)
	{
		return profilService.CreerProfil(name, dataModel,category);
	}
	@GetMapping("Transaction_Creation/{operationType}/{stop}/{ordre}/{nameProfil}/{nameData}/{category}")
	public Object TransactionCreation(@PathVariable OperationTypes operationType,@PathVariable Association association,@PathVariable int ordre,@PathVariable String nameProfil, @PathVariable String nameData,@PathVariable String category)
	{
		return transactionService.CreationDlmsTransaction(operationType,association,ordre,nameProfil,nameData,category);
	}
	@GetMapping("CosemImport/{category}/{cosem}/{nameCos}/{name}/{PayLoad}/{relDate}/{operationType}/{associationName}/{stop}/{ordre}/{nameProfil}")
	public Object CosemImport(@PathVariable String category,@PathVariable String cosem,@PathVariable String nameCos,@PathVariable String name,@PathVariable String PayLoad,@PathVariable String relDate ,@PathVariable OperationTypes operationType,@PathVariable String associationName,@PathVariable int ordre,@PathVariable String nameProfil) 
	{
		
		Association association = associationService.findByName(associationName).get();
	
		return operationService.creerOperation(cosem,nameCos,relDate,PayLoad,operationType,association,ordre,nameProfil,name,category);
	}
	@DeleteMapping("/DeleteProfil")
	public void Supprimer()
	{
		 profilService.deleteALL();
	}
	@GetMapping("/FindByData/{data}")
	public Object ProfilByDataModel(@PathVariable String data)
	{
		return profilService.findByDataModel(dataService.findByName(data)).get();
	}
	@GetMapping("/FindByDescription/{description}")
	public Object ProfilByDescription(@PathVariable String description)
	{
		return profilService.findByDescription(description).get();
	}
	@GetMapping("/CopieProfil/{profil}/{name}")
	public Object ProfilCopie(@PathVariable String  profil,@PathVariable String name)
	{
		return profilService.save(profilService.CopyProfil(profilService.findByName(profil).get(), name));
	}
	@GetMapping("/cosemByCate/{data}")
	public Object CosemByCate(@PathVariable String data)
	{	
		return operationService.cosemByCategory(dataService.findByName(data).getCosemObject());
	}
	@GetMapping("/export/{name}")
	public Boolean ExportProfil(@PathVariable String name) throws IOException
	{
		Profil p = profilService.findByName(name).get();
		profilService.ExportProfil(p);
		return true;
	}
	@GetMapping("/Upgrade/{profil}/{data}")
	public Profil UpgradeProfil(@PathVariable String profil,@PathVariable String data)
	{
		return profilService.UpgradeProfil(profilService.findByName(profil).get(),dataService.findByName(data));
	}
}
