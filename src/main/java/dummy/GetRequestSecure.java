package dummy;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.omg.stub.java.rmi._Remote_Stub;

import com.api.rest.api.helper.RestApiHelper;
import com.api.rest.api.model.RestResponse;

public class GetRequestSecure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String getUrl="http://localhost:8080/laptop-bag/webapi/secure/all";
		Map<String,String> headers=new HashMap<String, String>();
		headers.put("Accept","application/json");
		//headers.put("Authorization","Basic YWRtaW46d2VsY29tZQ==");
		headers.put("Authorization", Base64.encodeBase64String("admin:welcome".getBytes()));
		RestResponse _RestResponse=RestApiHelper.performGetRequest(getUrl, headers);
		System.err.println(_RestResponse.toString());
	}

}
