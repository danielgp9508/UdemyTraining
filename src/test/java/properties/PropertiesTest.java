package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertiesTest {
	
	String propertyPath = "src/test/resources/properties/prop.properties";

	@Test
	public void bringProperties() {
		Properties prop = new Properties();
		Properties systemProperties = System.getProperties();
		try {
			FileInputStream fis = new FileInputStream(propertyPath);
			prop.load(fis);
			//System.setProperties(prop);
			//System.setProperties(prop);
			//prop.putAll(systemProperties);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("p1"));
		prop.setProperty("p1", "a modified");
		try {
			prop.store(new FileOutputStream(propertyPath), "modification");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("p1"));
		System.out.println(System.getProperty("user.dir"));
	}
}
