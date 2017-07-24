package com.api.rest.api.testcases;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.junit.Assert;
import org.junit.Test;

import com.api.rest.api.helper.RestApiHelper;
import com.api.rest.api.model.ResponseBody;
import com.api.rest.api.model.RestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class testPostRequest {
	
	
	@Test
	public void testaddByID(){
		String url="http://localhost:8080/laptop-bag/webapi/api/add";
		String FilePath=System.getProperty("user.dir")+"//data.txt";
		Map<String, String> postheaders=new HashMap<String, String>();
		postheaders.put("Accept","application/json");
		postheaders.put("Content-Type","application/json");
		File file=new File(FilePath);
		RestResponse restResponse=RestApiHelper.performPostRequest(url, postheaders, file,ContentType.APPLICATION_JSON);
		if(restResponse.getStatusCode()!=HttpStatus.SC_OK){
			System.out.println("ERROR");
		}
		
		String findurl="http://localhost:8080/laptop-bag/webapi/api/find/101";
		restResponse = RestApiHelper.performGetRequest(findurl, postheaders);
		GsonBuilder builder=new GsonBuilder();
		Gson gson=builder.serializeNulls().setPrettyPrinting().create();
		ResponseBody body=gson.fromJson(restResponse.getResponseBody(),ResponseBody.class);
		if(body.Id!="100"){
			System.out.println("In Error loop");
		}
		Assert.assertTrue(restResponse.getStatusCode()==HttpStatus.SC_OK);
		System.out.println(restResponse.getStatusCode());
	}
	
}
