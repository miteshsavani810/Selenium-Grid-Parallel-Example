package Main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readJsonFile {
	
	
	public static void main(String[] args) {
		ArrayList<testsType> o = null;
		
		o = getTests();
		System.out.println(o.size());
	}

	public static ArrayList<testsType> getTests() {
		JSONParser jsonParser = new JSONParser();
		
		ArrayList<testsType> tests= new ArrayList<testsType>(); 
        
        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\Main\\configParallel.json"))
        {
            //Read JSON file
        	JSONObject obj = (JSONObject) jsonParser.parse(reader);
            
            JSONArray configs = (JSONArray) obj.get("config");
            
            Iterator<String> iterator = configs.iterator();
            for(int i=0; i< configs.size(); i++) {
            	JSONObject conf = (JSONObject) configs.get(i);
            	System.out.println(conf.get("instance") + "------" + conf.get("browserName").toString());
            	conf.keySet().forEach(key -> {
            		System.out.println(key);
            	});
            	tests.add(new testsType(conf.get(0).toString(), conf.get(1).toString()));
            }
           
            
            //Iterate over employee array
            //employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return tests;
	}

	/*
	 * private static ArrayList<testsType> parseConfig(JSONArray obj) {
	 * 
	 * ArrayList<testsType> tests = new ArrayList<testsType>();
	 * 
	 * }
	 */

}


class testsType {
	public String instance;
	public String browser;
	
	public testsType(String instance, String browser) {
		this.instance = instance;
		this.browser = browser;
		
	}
}
