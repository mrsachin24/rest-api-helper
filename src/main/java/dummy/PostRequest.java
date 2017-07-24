package dummy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class PostRequest {
	public static void main(String[] args) {
		HttpPost post = new HttpPost("http://localhost:8080/laptop-bag/webapi/api/add");
		CloseableHttpClient client = HttpClientBuilder.create().build();
		/*
		 * Map<String,String> headers=new HashMap<String, String>();
		 * headers.put("Content-Type", "application/json");
		 * headers.put("Accept","application/json");
		 */
		post.addHeader("Content-Type", "application/json");
		post.addHeader("Accept","application/json");
		FileEntity data=new FileEntity(new File(System.getProperty("user.dir")+"//data.txt"), ContentType.APPLICATION_JSON);
		post.setEntity(data);
		
		
		try {
			CloseableHttpResponse response = client.execute(post);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
