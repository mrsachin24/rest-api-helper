package com.api.rest.api.testcases;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.ContentType;
import org.junit.Test;

import com.api.rest.api.helper.RestApiHelper;
import com.api.rest.api.model.RestResponse;

public class testPutRequest {
	
	@Test
	public void testPutByID(){
		String url="http://localhost:8080/laptop-bag/webapi/api/update";
		File datafile=new File("data.txt");
		Map<String,String> headers=new HashMap<String, String>();
		headers.put("Content-Type","application/json");
		headers.put("Accept", "application/json");
		RestResponse _RestResponse=RestApiHelper.performPutRequest(url, headers,datafile,ContentType.APPLICATION_JSON);
		System.err.println(_RestResponse.getStatusCode());
	}
	

}
