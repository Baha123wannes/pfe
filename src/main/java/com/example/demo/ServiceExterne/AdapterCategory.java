package com.example.demo.ServiceExterne;

import java.lang.reflect.Type;

import com.example.demo.model.Category;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class AdapterCategory implements JsonDeserializer<Category>{

	@Override
	public Category deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		Category rslt = new Category() ;
		if(json.isJsonPrimitive())
		{
			rslt.setName(context.deserialize(json,typeOfT));
		}
		else
		{
			rslt=new Category();
			rslt.setName(((Category)context.deserialize(json, Category.class)).getName());
		}
		return rslt;
	}

}
