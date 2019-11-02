package orgn;

import java.util.ArrayList;
import java.util.List;
 
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class runNG {

	public void testNgXmlSuite() {
		 
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        List<XmlClass> classes = new ArrayList<XmlClass>();
        //List<Class> listenerClasses = new ArrayList<Class>();
 
        XmlSuite suite = new XmlSuite();
        suite.setName("ProgramSuite");
 
        XmlTest test = new XmlTest(suite);
        test.setName("ProgramTest");
 
        XmlClass clss1 = new XmlClass("orgn.ParallelMethodTest");
        classes.add(clss1);
 
//        XmlClass clss2 = new XmlClass(&amp;amp;amp;quot;SampleProgramTwo&amp;amp;amp;quot;);
//        classes.add(clss2);
 
        //listenerClasses.add(ListenerTest.class);
 
        test.setXmlClasses(classes);
        test.setParallel(ParallelMode.METHODS);
        test.setThreadCount(2);
        suites.add(suite);
        
 
        TestNG tng = new TestNG();
 
        tng.setXmlSuites(suites);
        //tng.setListenerClasses(listenerClasses);
        tng.run();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runNG tnxuc = new runNG();
        tnxuc.testNgXmlSuite();
	}

}
