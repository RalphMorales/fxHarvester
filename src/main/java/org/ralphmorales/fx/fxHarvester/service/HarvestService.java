package org.ralphmorales.fx.fxHarvester.service;

import java.text.ParseException;
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
	
	private static final Logger log = LoggerFactory.getLogger(HarvestService.class);
	
	@Transactional
	public void harvestCSVtoFxrecord(String filePath, String fileSeparator) throws ParseException{
		Map<List<String[]>,Map<String,List<String>>> data = RecordUtils.parseCSVtoRecord(filePath, fileSeparator, new FxrecordValidator());
		Map.Entry<List<String[]>,Map<String,List<String>>> entry=data.entrySet().iterator().next();
		List<String[]> validRecords= entry.getKey();
		Map<String, List<String>> value=entry.getValue();
		
		fxrecordService.addFxRecords(validRecords);
		fxinvalidService.addInvalidRecords(value);
		
	}
	
}
