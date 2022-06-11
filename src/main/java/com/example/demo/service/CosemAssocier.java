package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;
import com.example.demo.ServiceInter.CosemService;
import com.example.demo.ServiceInter.DataModelService;
import com.example.demo.model.Category;

@Service
public class CosemAssocier {

	@Autowired 
	CosemService cosemService;
	@Autowired 
	CategoryService categoryService;
	public List<Cosem> GetCosem(String category)
	{
		return cosemService.findBycategory(category);
	}
	public Cosem GetCoseme(String category)
	{
		return cosemService.findByCategory(category);
	}
}
