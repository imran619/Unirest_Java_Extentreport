package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONString;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	
	JSONParser jsonParser = new JSONParser();
	JSONString dataList = null;
	JSONObject jsonObject = null;
		
public String readJsonFile(String fileName) throws IOException, ParseException {
		
		try (FileReader reader = new FileReader(fileName)){

		// Read JSON file
		final Object obj = jsonParser.parse(reader);

		dataList = new JSONString() {

			@Override
			public String toJSONString() {
				
				return obj.toString();
			}
		};
		
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		return dataList.toJSONString();
	}

public String readJsonFile(String fileName, String fieldName) throws IOException, ParseException {
	
	try (FileReader reader = new FileReader(fileName)){

	// Read JSON file
	final Object obj = jsonParser.parse(reader);
	jsonObject = (JSONObject) obj;	

	} catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
	
	return jsonObject.get(fieldName).toString();
}

}
