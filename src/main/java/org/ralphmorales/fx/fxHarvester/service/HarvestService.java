package org.ralphmorales.fx.fxHarvester.service;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.ralphmorales.fx.fxHarvester.utils.RecordUtils;
import org.ralphmorales.fx.fxHarvester.validator.FxrecordValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HarvestService {

	@Autowired
	private FxrecordService fxrecordService;

	@Autowired
	private FxinvalidService fxinvalidService;

	@Autowired
	private FileLogService fileLogService;
	
	private static final Logger log = LoggerFactory.getLogger(HarvestService.class);

	@Transactional
	public void harvestCSVtoFxrecord(String fileDirectory, String fileSeparator) throws ParseException {

		File[] files = getFileList(fileDirectory);

		for (File currentFile : files) {
			if (fileLogService.addFileLog(currentFile.getName(), new Date())) {
				Map<List<String[]>, Map<String, List<String>>> data = RecordUtils
						.parseCSVtoRecord(currentFile, fileSeparator, new FxrecordValidator());
				Map.Entry<List<String[]>, Map<String, List<String>>> entry = data.entrySet().iterator().next();
				List<String[]> validRecords = entry.getKey();
				Map<String, List<String>> value = entry.getValue();

				fxrecordService.addFxRecords(validRecords);
				fxinvalidService.addInvalidRecords(value);
			}

		}

	}

	private File[] getFileList(String fileDirectory) {
		File file = new File(fileDirectory);
		File[] files = file.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (name.toLowerCase().endsWith(".csv")) {
					return true;
				} else {
					return false;
				}
			}
		});
		return files;
	}

}
