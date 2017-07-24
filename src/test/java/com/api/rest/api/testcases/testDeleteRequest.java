package com.api.rest.api.testcases;

import org.junit.Test;

import com.api.rest.api.helper.RestApiHelper;
import com.api.rest.api.model.RestResponse;

public class testDeleteRequest {

	@Test
	public void testDeleteById(){
		String url="http://localhost:8080/laptop-bag/webapi/api/delete/125";
		
		RestResponse _RestResponse=RestApiHelper.performDeleteRequest(url, null);
		System.err.println(_RestResponse.toString());
		
	}
}
