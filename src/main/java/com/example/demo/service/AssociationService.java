package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AssociationRepo;
import com.example.demo.Repository.CategoryRepo;
import com.example.demo.model.Association;
import com.example.demo.model.Category;

@Service
public class AssociationService {
	@Autowired
	private AssociationRepo associationRepo;
	//CRUD :save:Create , find/findAll :read , Update:update , delete : delete 
	public Association save(Association p)
	{
		return associationRepo.save(p);
	}
	public Optional<Association> find(Association p)
	{
		return associationRepo.findById(p.getId());
	}
	public Optional<Association> findByName(String name)
	{
		return associationRepo.findByAssociation(name);
	}
	public List<Association> findAll()
	{
		return associationRepo.findAll();
	}
	public Association Update(Association p)
	{
		if(p.getId()==find(p).get().getId())
		{
			associationRepo.delete(p);
			return associationRepo.save(p);
		}
		else {
			return associationRepo.save(p);
		}
	}
	public Association delete(Association p)
	{
		associationRepo.delete(p);
		 return p;
	}
}
