package com.api.rest.api.helper;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import com.api.rest.api.model.RestResponse;

public class RestApiHelper {

	public static HttpEntity getHttpEntity(Object content, ContentType type) {
		if (content instanceof String) {
			return new StringEntity((String) content, type);
		} else if (content instanceof File) {
			return new FileEntity((File) content, type);
		}
		throw new RuntimeException("Entity Type not Found");

	}

	public static Header[] getCustomHeaders(Map<String, String> headers) {
		Header[] customHeader = new Header[headers.size()];
		int i = 0;
		for (String key : headers.keySet()) {
			customHeader[i++] = new BasicHeader(key, headers.get(key));
		}
		return customHeader;
	}

	public static RestResponse performRequesst(HttpUriRequest request) {
		CloseableHttpClient client;
		CloseableHttpResponse response = null;
		ResponseHandler<String> body;
		client = HttpClientBuilder.create().build();
		try {
			response = client.execute(request);
			body = new BasicResponseHandler();
			return new RestResponse(response.getStatusLine().getStatusCode(), body.handleResponse(response));
		} catch (Exception e) {
			if (e instanceof HttpResponseException) {
				return new RestResponse(response.getStatusLine().getStatusCode(), e.getMessage());
			}

			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static RestResponse performGetRequest(String url, Map<String, String> headers) {
		/*
		 * HttpGet get=new HttpGet(url); CloseableHttpClient client;
		 * CloseableHttpResponse response=null;
		 * 
		 * client=HttpClientBuilder.create().build(); try {
		 * response=client.execute(get); ResponseHandler<String> body=new
		 * BasicResponseHandler(); return new
		 * RestResponse(response.getStatusLine().getStatusCode(),body.
		 * handleResponse(response)); } catch (Exception e) { throw new
		 * RuntimeException(e.getMessage(),e); }
		 */
		try {
			return performGetRequest(new URI(url), headers);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static RestResponse performGetRequest(URI url, Map<String, String> headers) {

		HttpGet get = new HttpGet(url);
		if (headers != null) {
			/*
			 * for (String key : headers.keySet()) { get.addHeader(key,
			 * headers.get(key)); }
			 */
			get.setHeaders(getCustomHeaders(headers));
		}
		return performRequesst(get);
	}

	public static RestResponse performPostRequest(URI url, Map<String, String> headers, Object content,
			ContentType type) {
		HttpPost post = new HttpPost(url);
		if (headers != null) {
			/*
			 * for (String key : headers.keySet()) { post.addHeader(key,
			 * headers.get(key)); }
			 */
			post.setHeaders(getCustomHeaders(headers));
		}
		post.setEntity(getHttpEntity(content, type));
		return performRequesst(post);
	}

	public static RestResponse performPostRequest(String url, Map<String, String> headers, Object content,
			ContentType type) {
		try {
			return performPostRequest(new URI(url), headers, content, type);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static RestResponse performDeleteRequest(URI url, Map<String, String> headers) {
		HttpDelete delete = new HttpDelete(url);
		if (headers != null) {
			delete.setHeaders(getCustomHeaders(headers));
		}
		return performRequesst(delete);
	}

	public static RestResponse performDeleteRequest(String url, Map<String, String> headers) {
		try {
			return performDeleteRequest(new URI(url), headers);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static RestResponse performPutRequest(URI url,Map<String,String> headers,Object content,ContentType type){
		HttpPut put=new HttpPut(url);
		if(headers!=null){
		put.setHeaders(getCustomHeaders(headers));
		}
		put.setEntity(getHttpEntity(content, type));
		return performRequesst(put);
	}

	
	public static RestResponse performPutRequest(String url,Map<String,String> headers,Object content,ContentType type){
		try {
			return performPutRequest(new URI(url), headers, content, type);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
