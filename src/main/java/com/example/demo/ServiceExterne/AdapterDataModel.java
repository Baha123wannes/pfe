package com.example.demo.ServiceExterne;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.DataModel;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class AdapterDataModel  implements  JsonDeserializer<List<DataModel>> {
			public List<DataModel> deserialize(JsonElement json, Type typeOfT,
		            JsonDeserializationContext jsc) {
		List<DataModel> result;
		
		if (json.isJsonArray()) {
		result = jsc.deserialize(json, typeOfT);
		}else {
		result  =  new ArrayList<>();
		result.add((DataModel) jsc.deserialize(json, DataModel.class));
		}
		return result;
		}

}
