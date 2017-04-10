package org.ralphmorales.fx.fxHarvester.service;

import java.util.Date;

import org.ralphmorales.fx.fxHarvester.entities.FileLog;
import org.ralphmorales.fx.fxHarvester.repositories.FileLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileLogService {
	
	private static final Logger log = LoggerFactory.getLogger(FxrecordService.class);
	
	@Autowired
	private FileLogRepository fileLogRepository;
	
	public boolean addFileLog(String fileName, Date dateImported){
		if(fileLogRepository.findOne(fileName) == null) {
			fileLogRepository.save(new FileLog(fileName, dateImported));
			return true;
		}
		return false;
	}

}
