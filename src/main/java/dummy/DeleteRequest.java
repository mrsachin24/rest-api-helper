package dummy;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.api.rest.api.model.RestResponse;

public class DeleteRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpUriRequest req=RequestBuilder.delete("http://localhost:8080/laptop-bag/webapi/api/delete/126").build();
		CloseableHttpResponse response = null;
		try{
			CloseableHttpClient client=HttpClientBuilder.create().build();
			response=client.execute(req);
			ResponseHandler<String> body=new BasicResponseHandler();
			RestResponse restResponse=new RestResponse(response.getStatusLine().getStatusCode(),body.handleResponse(response));
			System.out.println("Checking response");
			if(restResponse.getStatusCode()==HttpStatus.SC_OK){
				System.out.println("Deleted Successfully");
			}else if (restResponse.getStatusCode()==HttpStatus.SC_NO_CONTENT) {
				System.out.println("Data not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			if (e instanceof HttpResponseException) {
				System.err.println(response.getStatusLine().getStatusCode()); 
			}else {
				System.err.println("In Error");
			}
			
		}
		
	}

}
