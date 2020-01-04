package steps;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import kong.unirest.*;

public class WebServiceRequestTest {
	
	/*@Test
	public void testGetUserDetails () throws UnirestException {
		
		HttpResponse<JsonNode> jsonResponse 
	      = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
	      .header("accept", "application/json").queryString("apiKey", "123")
	      .asJson();
		
		System.out.println(jsonResponse.getBody().toString());
		System.out.println(" ");
		System.out.println(jsonResponse.getStatus());
	 
	    //assertNotNull(jsonResponse.getBody());
	    //assertEquals(200, jsonResponse.getStatus());
	}*/
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFileUpload () {
		
		HttpResponse<JsonNode> response = Unirest.post("https://upload.uploadcare.com/base/")
				  .field("upload", new File("/C:/Users/Inzy/Pictures/Air-Pollution.jpg"))
				  .field("UPLOADCARE_PUB_KEY", "demopublickey")
				  .field("UPLOADCARE_STORE", "1")
				  .asJson();
		
		System.out.println(response.getBody().toString());
		System.out.println(response.getStatus());
		
		/*HttpResponse<JsonNode> response = Unirest.post("http://www.mocky.io/v2/5a9ce7663100006800ab515d")
		  .field("upload", new File("/C:/Users/Inzy/Pictures/Air-Pollution.jpg"))
		  .asJson();
		
		System.out.println(response.getStatus());*/
		
	}

}
