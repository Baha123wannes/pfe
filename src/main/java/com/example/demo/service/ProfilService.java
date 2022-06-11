package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.DataModel;
import com.example.demo.Repository.ProfilRepo;
import com.example.demo.Service.XmlService;
import com.example.demo.ServiceInter.DataModelService;
import com.example.demo.model.Category;
import com.example.demo.model.Profil;
import com.example.demo.model.XMLModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.lingala.zip4j.ZipFile;

@Service
public class ProfilService {
	@Autowired
	private ProfilRepo profilRepo;
	@Autowired
	private DataModelService dataModelService;
	@Autowired 
	private CategoryService categoryService;
	//CRUD :save:Create , find/findAll :read , Update:update , delete : delete ,deletALL
	//-------------------------------------------------------------
	public Profil save(Profil p)
	{
		return profilRepo.save(p);
	}
	public Optional<Profil> find(Profil p)
	{
		return profilRepo.findById(p.getId());
	}
	public Optional<Profil> findById(int p)
	{
		return profilRepo.findById(p);
	}
	public List<Profil> findAll()
	{
		return profilRepo.findAll();
	}
	
	public Profil Update(Profil p)
	{
		if(p.getId()==find(p).get().getId())
		{
			profilRepo.delete(p);
			return profilRepo.save(p);
		}
		else {
			return profilRepo.save(p);
		}
	}
	public Profil delete(Profil p)
	{
		 profilRepo.delete(p);
		 return p;
	}
	public void deleteALL() {

		// TODO Auto-generated method stub
		 profilRepo.deleteAll();;
	}
	///----------------------------------------
	public boolean importer(MultipartFile file) throws IOException
	{
		 File zip = File.createTempFile(UUID.randomUUID().toString(), "temp");
	        FileOutputStream o = new FileOutputStream(zip);
	        IOUtils.copy(file.getInputStream(), o);
	        o.close();
	        File destination = new File("src/main/resources/Profils.xml");
			boolean renamed = zip.renameTo(destination);
			return renamed;
	}
	//Creer un profil 
	public Profil CreerProfil(String Name,String name,String cat)
	{
		Profil profil=new Profil();
		profil.setName(Name);
		profil.setDataModel(dataModelService.findByName(name));
		profil.setCategory(categoryService.findByName(cat).get().getName());
		return profil;
	}

	//Search Services 
	//---------------------
	public Optional<Profil> findByName(String name)
	{
		return profilRepo.findByName(name);

	}
	public Optional<Profil> findByDataModel(DataModel data)
	{
		return profilRepo.findByDataModel(data);
	}
	public Optional<Profil> findByDescription(String description)
	{
		return profilRepo.findByDescription(description);
	}
	//-----------------------------
	//Delete Mutiple 
	public List<Profil> deleteMutiple(List<Profil> p)
	{
		 profilRepo.deleteAll(p);
		 return p;
	} 
	//Copy Profil 
	public Profil CopyProfil(Profil profil,String newName)
	{
		Profil profilCopie =new Profil(profil);
		profilCopie.setName(newName);
		profilCopie.setId(profil.getId()+1);
		return profilCopie;
	}
	//Importer Profil 
	public Profil Inserer(MultipartFile file) throws IOException
	{
		importer(file);
		String xml = new String(Files.readAllBytes(Paths.get("src/main/resources/Profils.xml")));
		XmlMapper xmlMapper = new XmlMapper();
		ObjectMapper jsonMapper = new ObjectMapper();
		JsonNode node = xmlMapper.readTree(xml.getBytes());
		 String json = jsonMapper.writeValueAsString(node);
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 Profil profil= gson.fromJson(json, Profil.class);
		 System.out.println(profil.getName());
		 profilRepo.save(profil);
		 return   profil;   
		
	}
	//Export Profil 
	//-------------------------------------------
	public void parseObjectToXml(String filePath, XMLModel xmlModel) {
		try {
			JAXBContext contextObj = JAXBContext.newInstance(XMLModel.class);

			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshallerObj.marshal(xmlModel, new FileOutputStream(filePath));
		} catch (JAXBException je) {
			System.out.println("JAXBException");
		} catch (IOException ie) {
			System.out.println("IOException");
		}
	}
	public void ExportProfil(Profil profil)
	{
		XMLModel xmlModel =new XMLModel();
		xmlModel.setProfil(profil);
		this.parseObjectToXml("src/main/resources/xmlExported.xml", xmlModel);
	}
	//--------------------------------------------
	//Upgrade profil
	public Profil UpgradeProfil(Profil p,DataModel data)
	{
		if(p.getDataModel().getCosemObject()==data.getCosemObject())
		{
			p.setDataModel(data);
			return p;
		}
		else
		{
			System.out.println("Erreur de compatiblité");
			return null; 
		}
	}
}
