package com.api.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.api.constants.ApplicationVariables;
import com.api.manager.FileReaderManager;
import com.api.testDataType.NaceTestData;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Purpose: This class is used to retrive all the JSON file content and stored
 * in POJO object
 * 
 * @author prash
 *
 */
public class JsonDataReader {

	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()
			+ ApplicationVariables.NACE_TEST_DATA_JSON_NAME;
	private List<NaceTestData> naceTestDataList;

	/**
	 * Constructor to assign all the content to naceTestDataList instance variable
	 */
	public JsonDataReader() {
		naceTestDataList = getNaceTestData();
	}

	/**
	 * Purpose: Read the data from JSON file and return in POJO object
	 * 
	 * @return
	 */
	private List<NaceTestData> getNaceTestData() {
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));

			ObjectMapper om = new ObjectMapper();
			try {
				NaceTestData[] naceTestData = om.readValue(bufferReader, NaceTestData[].class);
				naceTestDataList = Arrays.asList(naceTestData);
				return naceTestDataList;

			} catch (StreamReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
		return naceTestDataList;
	}

	/**
	 * Purpose: Return NACE record based on order filter
	 * 
	 * @param order
	 * @return
	 */
	public final NaceTestData getNaceByOrder(Integer order) {
		return naceTestDataList.stream().filter(x -> x.order == order).findAny().get();
	}
}
