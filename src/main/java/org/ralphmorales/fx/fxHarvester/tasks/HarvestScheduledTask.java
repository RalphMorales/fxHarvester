package org.ralphmorales.fx.fxHarvester.tasks;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.ralphmorales.fx.fxHarvester.service.HarvestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;


@Component
public class HarvestScheduledTask {
	
	@Value("${csv.filepath}")
	private String filePath;

	@Value("${csv.fileSeparator}")
	private String fileSeparator;
	
	@Autowired
	private HarvestService harvestService;

	private static final Logger log = LoggerFactory.getLogger(HarvestScheduledTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() throws ParseException {
		log.info("Importing {}", dateFormat.format(new Date()));
		harvestService.harvestCSVtoFxrecord(filePath, fileSeparator);
		log.info("Done {}", dateFormat.format(new Date()));
	}

}
