package org.ralphmorales.fx.fxHarvester.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.ralphmorales.fx.fxHarvester.entities.Fxinvalid;
import org.ralphmorales.fx.fxHarvester.entities.Fxrecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FxinvalidService {

	@Autowired
	private EntityManager entityManager;
	
	@Value("${spring.jpa.hibernate.jdbc.batch_size}")
	private int batchSize;
	
	private static final Logger log = LoggerFactory.getLogger(FxrecordService.class);
	
	public void addInvalidRecords(Map<String,List<String>> invalidData) throws ParseException{
		entityManager.flush();
		int i = 0;
		
		Map.Entry<String,List<String>> entry=invalidData.entrySet().iterator().next();
		String filePath= entry.getKey();
		List<String> invalidRecords=entry.getValue();
		
		for(String record : invalidRecords) {
			i++;
			
			entityManager.persist(new Fxinvalid(record, filePath));
			
			if (i % batchSize == 0) {
		        entityManager.flush();
		        entityManager.clear();
		        i = 0;
		    }
		}
		
		entityManager.flush();
		entityManager.clear();
	}
	
}
