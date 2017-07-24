package com.api.rest.api.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import com.api.rest.api.helper.RestApiHelper;
import com.api.rest.api.model.RestResponse;

public class testGetRequests {
	
	@Test
	public void TestGetPingAlive(){
		String url="http://localhost:8080/laptop-bag/webapi/api/ping/Hello";
        RestResponse _RestResponse=RestApiHelper.performGetRequest(url,null);
        System.err.println(_RestResponse.toString());
        Assert.assertEquals(HttpStatus.SC_OK, _RestResponse.getStatusCode());
        Assert.assertEquals("Hi! Hello", _RestResponse.getResponseBody());
		
	}
	
	@Test
	public void TestGetAll(){
		String url="http://localhost:8080/laptop-bag/webapi/api/all";
		Map<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type","application/json");
		headers.put("Accept","application/json");
        RestResponse _RestResponse=RestApiHelper.performGetRequest(url,headers);
        //System.err.println(_RestResponse.toString());
        Assert.assertEquals(HttpStatus.SC_OK, _RestResponse.getStatusCode());
        Assert.assertTrue(HttpStatus.SC_OK==_RestResponse.getStatusCode() || HttpStatus.SC_NO_CONTENT==_RestResponse.getStatusCode());
        if(HttpStatus.SC_OK==_RestResponse.getStatusCode()){
        	System.err.println(HttpStatus.SC_OK);
        }
        if(HttpStatus.SC_NO_CONTENT==_RestResponse.getStatusCode()){
        	System.err.println(HttpStatus.SC_NO_CONTENT);
        }
        System.out.println(_RestResponse.getResponseBody());
        
	}

	
	@Test
	public void TestGetFindByID(){
		String url="http://localhost:8080/laptop-bag/webapi/api/find/127";
		Map<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type","application/json");
		headers.put("Accept","application/json");
       
		RestResponse _RestResponse=RestApiHelper.performGetRequest(url,headers);
        Assert.assertTrue(HttpStatus.SC_OK==_RestResponse.getStatusCode() || HttpStatus.SC_NOT_FOUND==_RestResponse.getStatusCode());
        if(HttpStatus.SC_OK==_RestResponse.getStatusCode()){
        	System.err.println(HttpStatus.SC_OK);
        }
        if(HttpStatus.SC_NOT_FOUND==_RestResponse.getStatusCode()){
        	System.err.println(HttpStatus.SC_NOT_FOUND);
        }
        System.out.println(_RestResponse.getResponseBody());
	}
	
	@Test
	public void testSecureGet(){}
	
}
