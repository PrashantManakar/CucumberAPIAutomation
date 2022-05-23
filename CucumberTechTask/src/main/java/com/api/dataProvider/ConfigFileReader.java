package com.api.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.api.constants.ApplicationVariables;

/**
 * This class is created to fetch the configuration variable values.
 * 
 * @author prash
 *
 */
public class ConfigFileReader {

	private Properties properties;

	/**
	 * Purpose: Read the configaration values from external file.
	 */
	public ConfigFileReader() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(ApplicationVariables.PROPERTY_FILE_PATH));
			properties = new Properties();
			try {
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					"Properties file not found at path : " + ApplicationVariables.PROPERTY_FILE_PATH);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ignore) {
			}
		}
	}

	/**
	 * Purpose: Get the test data resource path
	 * 
	 * @return
	 */
	public String getTestDataResourcePath() {
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if (testDataResourcePath != null)
			return testDataResourcePath;
		else
			throw new RuntimeException(
					"Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
	}

	/**
	 * Purpose: Return the application URL
	 * 
	 * @return
	 */
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}

	/**
	 * Purpose: Return the Port variable value
	 * 
	 * @return
	 */
	public String getApplicationPort() {
		String port = properties.getProperty("port");
		if (port != null)
			return port;
		else
			throw new RuntimeException(
					"Application port not specified in the Configuration.properties file for the Key:port");
	}

	/**
	 * Purpose: Return the envirnment value
	 * 
	 * @return
	 */
	public String getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null)
			return environmentName;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

}
