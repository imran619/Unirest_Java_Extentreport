package tests;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import kong.unirest.Headers;
import requests.PostRequest;
import utilities.JsonReader;

public class TestPostRequest {
	
	JsonReader _jsonReader = new JsonReader();
	PostRequest _postRequest = new PostRequest();
	
	@SuppressWarnings("static-access")
	@Test
	public void testPostRequestDetails() throws IOException, ParseException {

		System.out.println("Response body is => " + _postRequest.postRequestDetails().getBody().toString());

		String statusCode = Integer.toString(_postRequest.postRequestDetails().getStatus());
		String statusLine = _postRequest.postRequestDetails().getStatusText();

		Headers allHeaders = _postRequest.postRequestDetails().getHeaders();

		System.out.println(statusLine);
		System.out.println("The status code is: " + statusCode);
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObjectResult = (JSONObject) parser.parse(_postRequest.postRequestDetails().getBody().toString());
		
		// Iterate over all the Headers
		/*for (Headers header : allHeaders) {
			System.out.println("Key: " + header.getName() + "   Value: " + header.getValue());
		}*/
		System.out.println(allHeaders);

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode /* actual value */,
				_jsonReader.readJsonFile(".\\Data\\WSData.json", "POST_STATUS_CODE") /* expected value */,
				"Status code does not match");
		// Assert that correct Name is returned.
		Assert.assertEquals(jsonObjectResult.get("name") /* actual value */,
				_jsonReader.readJsonFile(".\\Data\\PostData.json", "name") /* expected value */,
				"Name does not match");
	}

}
