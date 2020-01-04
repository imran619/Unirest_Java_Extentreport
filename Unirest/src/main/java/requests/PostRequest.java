package requests;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import kong.unirest.*;
import utilities.JsonReader;

public class PostRequest {
	
	JsonReader __jsonReader = new JsonReader();
	
public HttpResponse<String> postRequestDetails() throws IOException, ParseException {
	
		return Unirest.post(__jsonReader.readJsonFile(".\\Data\\WSData.json", "POST"))
				  .header("Content-Type", "application/json")
				  .body(__jsonReader.readJsonFile(".\\Data\\PostData.json"))
				  .asString();
	}

}
