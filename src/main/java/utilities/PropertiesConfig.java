package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig {
	Properties properties= new Properties();
	InputStream inputStream;
	
	
	public Properties loadPropertiesFile() throws IOException{
		inputStream=new FileInputStream("/Users/sanjaysai/Documents/workspace/OrangeHRM/src/test/resources/properties/login.properties");
		//inputStream=getClass().getResourceAsStream("/login.properties");
		properties.load(inputStream);
		return properties;
	}
	

}
