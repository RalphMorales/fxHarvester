package org.ralphmorales.fx.fxHarvester.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordUtils {

	public static Map<List<String[]>,Map<String,String>> parseCSVtoRecord(final String filepath, final String separator) {
		String line = "";
		
		List<String[]> records = new ArrayList<>();
		Map<String,String> invalidRecords = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			while ((line = br.readLine()) != null) {
				String[] data = line.split(separator);
				// validation
				records.add(data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}

}
