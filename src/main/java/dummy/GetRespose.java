package dummy;


import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import com.api.rest.api.helper.RestApiHelper;
import com.api.rest.api.model.ResponseBody;
import com.api.rest.api.model.RestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GetRespose {

	public static HttpGet get;
	public static CloseableHttpClient client;
	public static CloseableHttpResponse response;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*get =new HttpGet("http://localhost:8080/laptop-bag/webapi/api/ping/Hello");
		client=HttpClientBuilder.create().build();
		CloseableHttpResponse response=null;
		try {
			response=client.execute(get);
			ResponseHandler<String> body=new BasicResponseHandler();
			RestResponse restresponse=new RestResponse(response.getStatusLine().getStatusCode(),body.handleResponse(response));
			System.out.println(restresponse.toString());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String url="http://localhost:8080/laptop-bag/webapi/api/find/126";
		Map<String,String> headers=new HashMap<String, String>();
		//headers.put("Content-Type", "application/json");
		headers.put("Accept","application/json");
		RestResponse response=RestApiHelper.performGetRequest(url,headers);
		System.err.println(response.getResponseBody());
		
		
		GsonBuilder builder=new GsonBuilder();
		Gson gson=builder.serializeNulls().setPrettyPrinting().create();
		//ResponseBody body=gson.fromJson(response.getResponseBody(),ResponseBody.class);
		ResponseBody body=gson.fromJson(response.getResponseBody(),ResponseBody.class);
		System.out.println(body);
		System.out.println(body.BrandName);
		System.out.println(body.Id);
		System.out.println(body.LaptopName);
		//System.out.println(body.Features.Feature);
		
	}
	
	

}
