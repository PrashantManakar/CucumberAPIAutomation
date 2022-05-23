package com.api.manager;

import com.api.dataProvider.ConfigFileReader;
import com.api.dataProvider.JsonDataReader;

/**
 * This is single class to create and manage objects of JSON and Config files
 * 
 * @author prash
 *
 */
public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;

	private FileReaderManager() {
	}

	/**
	 * @return
	 */
	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	/**
	 * Purpose: If Config oject is NULL then create and return it. otherwise return
	 * it.
	 * 
	 * @return
	 */
	public ConfigFileReader getConfigReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}

	/**
	 * Purpose: If JSON object is already created then return else create JSON
	 * object and return it.
	 * 
	 * @return
	 */
	public JsonDataReader getJsonReader() {
		return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
	}
}
