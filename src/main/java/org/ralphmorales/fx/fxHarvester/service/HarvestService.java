package org.ralphmorales.fx.fxHarvester.service;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.ralphmorales.fx.fxHarvester.utils.RecordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HarvestService {
	
	@Autowired
	private FxrecordService fxrecordService;
	
	private static final Logger log = LoggerFactory.getLogger(HarvestService.class);
	
	@Transactional
	public void harvestCSVtoFxrecord(String filePath, String fileSeparator) throws ParseException{
		List<String[]> records = RecordUtils.parseRecord(filePath, fileSeparator);
		
		fxrecordService.addFxrecords(records);
	}
	
}
