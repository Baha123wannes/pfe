package com.example.demo.ServiceExterne;

import java.lang.reflect.Type;

import com.example.demo.model.Association;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class AdapterAssociation implements JsonDeserializer<String>{

	@Override
	public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		String association;
		if(json.isJsonPrimitive())
		{
			 	association=context.deserialize(json, typeOfT);
		}
		else
		{
			association=new String();
			association= context.deserialize(json, Association.class);
		}
		return association;
	}
	
	

}
