package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Cosem;
import com.example.demo.Repository.CategoryRepo;
import com.example.demo.ServiceInter.CosemService;
import com.example.demo.model.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private CosemService cosemService;
	//CRUD :save:Create , find/findAll :read , Update:update , delete : delete 
	public Category save(Category p)
	{
		return categoryRepo.save(p);
	}
	public Optional<Category> findByName(String p)
	{
		return categoryRepo.findByName(p);

	}
 
	public Optional<Category> find(Category p)
	{
		return categoryRepo.findById(p.getId());
	}
	public List<Category> findAll()
	{
		return categoryRepo.findAll();
	}
	public Category Update(Category p)
	{
		if(p.getId()==find(p).get().getId())
		{
			categoryRepo.delete(p);
			return categoryRepo.save(p);
		}
		else {
			return categoryRepo.save(p);
		}
	}
	public Category delete(Category p)
	{
		categoryRepo.delete(p);
		 return p;
	}
	/*public List<Category> inserer()
	{
		List<Category> category;
		Iterable<Cosem> cos=cosemService.list();
		for(Cosem cosem:cos)
		{
			cosem.getCategory();
		}
	}*/
}
