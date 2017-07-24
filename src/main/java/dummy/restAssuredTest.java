package dummy;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

public class restAssuredTest {

	/*
	 * Make sure application is running
	 * perform get request based on url provided
	 * Assert for the status code
	 * Assert for the response body
	 */
	
	@Test
	public void testCode() throws Throwable{
		URI uri=new URI("http://localhost:8080/laptop-bag/webapi/api/ping/Hello");
		String str=uri.getHost();
		System.err.println(str);
		System.out.println(str.length());
	}
	

}
