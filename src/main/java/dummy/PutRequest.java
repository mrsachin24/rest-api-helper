package dummy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.api.rest.api.helper.RestApiHelper;
import com.api.rest.api.model.RestResponse;

public class PutRequest {

	public static void main(String[] args) {/*
		String data="<Laptop>"
				+"<BrandName>Samsung</BrandName>"
			    +"<Features>"
			        +"<Feature>8GB RAM</Feature>"
			        +"<Feature>1TB Hard Drive</Feature>"
			    +"</Features>"
			    +"<Id>126</Id>"
			    +"<LaptopName>Latitude</LaptopName>"
			+"</Laptop>";
		String url="http://localhost:8080/laptop-bag/webapi/api/update";
		HttpUriRequest request=RequestBuilder.put(url)
		.addHeader("Content-Type","application/xml")
		.addHeader("Accept","application/xml")
		.setEntity(new StringEntity(data, ContentType.APPLICATION_XML)).build();
		
		RestResponse _RestResponse = null;
		try {
			CloseableHttpClient client=HttpClientBuilder.create().build();
			CloseableHttpResponse response=client.execute(request);
			ResponseHandler<String> body=new BasicResponseHandler();
			_RestResponse=new RestResponse(response.getStatusLine().getStatusCode(),body.handleResponse(response));
			System.err.println(_RestResponse.toString());
			
		} catch (Exception e) {
			if (e instanceof HttpResponseException) {
				System.out.println("___________________"+_RestResponse.getStatusCode()+"___________________");
			}
			// TODO: handle exception
		}

	*/
	String puturl="http://localhost:8080/laptop-bag/webapi/api/update";	
	File data=new File("data.txt");
	Map<String,String> headers=new HashMap<String, String>();
	headers.put("Content-Type","application/json");
	headers.put("Accept","application/json");
	RestResponse _RestResponse=RestApiHelper.performPutRequest(puturl, headers, data, ContentType.APPLICATION_JSON);
	System.err.println(_RestResponse.getStatusCode());
	}

}
