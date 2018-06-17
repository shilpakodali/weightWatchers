package com.weightwatchers.web.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.weightwatchers.web.util.Helper;

/**
 * 
 * @author shilpakodali
 *
 */

public class printWordAndMeaning {

	public static final Logger LOGGER = Logger.getLogger(printWordAndMeaning.class.getName());
	private HashMap<String, List<String>> dataDictionary = new HashMap<String, List<String>>();
	String path = "src/test/java/resources/data-dictionary.txt";
	String currentLine;
	String[] data = null;

	@Test()
	public void printWordsAndTheirMeanings() throws IOException {

		LOGGER.info("Test: Contents of a file");
		try {
			if (doesFileExist(path)) {
				Helper.printBold(String.format("File exists at %s", path));
			}
			LOGGER.info("Read file data");
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
			while ((currentLine = reader.readLine()) != null) {
				data = currentLine.split("–");
				dataDictionary.put(data[0].trim(), Arrays.asList(data[1].split(",")));
			}
			reader.close();
		} catch (FileNotFoundException FNE) {
			FNE.printStackTrace();
		}
		LOGGER.info("Printing file data accordingly");
		for (Map.Entry<String, List<String>> pair : dataDictionary.entrySet()) {
			Helper.printBold(pair.getKey());
			for (String value : pair.getValue()) {
				Helper.printBold(value.trim());
			}
		}

	}

	public boolean doesFileExist(String filePath) {
		LOGGER.info("Verify file path");
		File file = new File(path);
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
}
