package Main;

import java.util.ArrayList;
import java.util.List;
 
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;
import testCases.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class runNG {

	public void testNgXmlSuite() {
		 
		//JSONArray testsList = readJson();
		
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        List<XmlClass> classes = new ArrayList<XmlClass>();
        List<XmlPackage> packages = new ArrayList<XmlPackage>();
        //List<Class> listenerClasses = new ArrayList<Class>();
 
        XmlSuite suite = new XmlSuite();
        suite.setName("ProgramSuite");
 
        XmlTest test = new XmlTest(suite);
        test.setName("ProgramTest");
 
    
        packages.add(new XmlPackage("testCases.*"));
 
//        XmlClass clss2 = new XmlClass(&amp;amp;amp;quot;SampleProgramTwo&amp;amp;amp;quot;);
//        classes.add(clss2);
 
        //listenerClasses.add(ListenerTest.class);
 
        test.setXmlPackages(packages);
        test.setParallel(ParallelMode.METHODS);
        test.setThreadCount(2);
        suites.add(suite);
        
 
        TestNG tng = new TestNG();
 
        tng.setXmlSuites(suites);
        //tng.setListenerClasses(listenerClasses);
        tng.run();
    }
	
	public static void main(String[] args) {
		
		readJsonFile rjf = new readJsonFile();
		//runNG tnxuc = new runNG();
        //tnxuc.testNgXmlSuite();
	}
	
	
	private JSONArray readJson() {
		 //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\Main\\configParallel.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
           return (JSONArray) obj;
             
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return null;
	}

}
