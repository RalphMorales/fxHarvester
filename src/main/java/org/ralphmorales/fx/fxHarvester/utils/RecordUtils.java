package org.ralphmorales.fx.fxHarvester.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ralphmorales.fx.fxHarvester.validator.IValidator;

public class RecordUtils {

	public static Map<List<String[]>,Map<String,List<String>>> parseCSVtoRecord(final File file, final String separator, final IValidator validator) {
		String line = "";
		
		List<String[]> records = new ArrayList<>();
		List<String> invalidRecords = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] data = line.split(separator);
				if(validator.validateRecord(data)) {
					records.add(data);
				} else {
					invalidRecords.add(line);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String,List<String>> invalidData = new HashMap<>();
		invalidData.put(file.getName(), invalidRecords);
		
		Map<List<String[]>,Map<String,List<String>>> result = new HashMap<>();
		result.put(records, invalidData);
		
		return result;
	}

}
