package com.example.demo.ServiceExterne;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.DlmsOperation;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class AdapterDlmsOperation  implements  JsonDeserializer<List<DlmsOperation>> {
			public List<DlmsOperation> deserialize(JsonElement json, Type typeOfT,
		            JsonDeserializationContext jsc) {
		List<DlmsOperation> result;
		
		if (json.isJsonArray()) {
		result = jsc.deserialize(json, typeOfT);
		}else {
		result  =  new ArrayList<>();
		result.add((DlmsOperation) jsc.deserialize(json, DlmsOperation.class));
		}
		return result;
		}

}
