package com.example.demo.ServiceExterne;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.DlmsTransaction;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class AdpaterDlmsTransaction  implements  JsonDeserializer<List<DlmsTransaction>> {
			public List<DlmsTransaction> deserialize(JsonElement json, Type typeOfT,
		            JsonDeserializationContext jsc) {
		List<DlmsTransaction> result;
		
		if (json.isJsonArray()) {
		result = jsc.deserialize(json, typeOfT);
		}else {
		result  =  new ArrayList<>();
		result.add((DlmsTransaction) jsc.deserialize(json, DlmsTransaction.class));
		}
		return result;
		}

}
