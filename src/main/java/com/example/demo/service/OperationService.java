package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;
import com.example.demo.Repository.OperationRepo;
import com.example.demo.ServiceInter.AttributService;
import com.example.demo.ServiceInter.CosemService;
import com.example.demo.ServiceInter.MethodeService;
import com.example.demo.model.Association;
import com.example.demo.model.Category;
import com.example.demo.model.DlmsOperation;
import com.example.demo.model.DlmsTransaction;
import com.example.demo.model.OperationType;
import com.example.demo.model.OperationTypes;
import com.example.demo.model.Profil;



@Service
public class OperationService {
	@Autowired
	private OperationRepo operationRepo;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private AttributService attributService;
	@Autowired
	private MethodeService methodeService;
	@Autowired
	private CosemService cosemService;
	//CRUD :save:Create , find/findAll :read , Update:update , delete : delete 
	//-------------------------------------------
	public DlmsOperation save(DlmsOperation p)
	{
		return operationRepo.save(p);
	}
	public Optional<DlmsOperation> find(DlmsOperation p)
	{
		return operationRepo.findById(p.getId());
	}
	public List<DlmsOperation> findAll()
	{
		return operationRepo.findAll();
	}
	public DlmsOperation Update(DlmsOperation p)
	{
		if(p.getId()==find(p).get().getId())
		{
			operationRepo.delete(p);
			return operationRepo.save(p);
		}
		else {
			return operationRepo.save(p);
		}
	}
	public DlmsOperation delete(DlmsOperation p)
	{
		operationRepo.delete(p);
		 return p;
	}
	//-------------------------------------------------------------------
	//Afficher les cosems regrouper par category
	public HashMap<String, List<Cosem>> cosemByCategory(List<Cosem> cosem)
	{
		HashMap<String, List<Cosem>> CosemMap =new HashMap<String,List<Cosem>>();
		for (Cosem cos : cosem) {
		    String key  = cos.getCategory();
		    if(CosemMap.containsKey(key)){
		        List<Cosem> list = CosemMap.get(key);
		        list.add(cos);

		    }else{
		        List<Cosem> list = new ArrayList<Cosem>();
		        list.add(cos);
		        CosemMap.put(key, list);
		    }
		   
	}
		return CosemMap;
	}
	//Creer une Operation tout on sauvgardant les données 
	public DlmsOperation creerOperation(String cosem,String name,String relDate,String PayLoad,OperationTypes operationType,Association association,int ordre,String nameProfil,String nameData,String category)
	{
		DlmsOperation opt=new DlmsOperation();
		
		opt.setTranscation(transactionService.CreationDlmsTransaction(operationType,association,ordre,nameProfil,nameData,category));
		
		opt.setAssociation(opt.getTranscation().getAssociation().getAssociation());
		
		if(opt.getTranscation().getOperation()==OperationTypes.ACTION)
		{
			opt.setDlmsMethod(methodeService.SearchByName(name));
			opt.setRel_date(relDate);
			opt.setOperation(OperationTypes.ACTION.name());
			 }
		else
		{
			opt.setDlmsAttribut(attributService.SearchByName(name));
			opt.setOperation(opt.getTranscation().getOperation().name());
		}
		opt.setPay_load(PayLoad);
		opt.setCosem(cosemService.findByName(cosem));
		
		
		return operationRepo.save(opt);
		}
	
	}
