package org.ralphmorales.fx.fxHarvester.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.ralphmorales.fx.fxHarvester.entities.Fxrecord;
import org.ralphmorales.fx.fxHarvester.repositories.FxrecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FxrecordService {

	@Autowired
	private EntityManager entityManager;
	
	@Value("${spring.jpa.hibernate.jdbc.batch_size}")
	private int batchSize;
	
	private static final Logger log = LoggerFactory.getLogger(FxrecordService.class);
	
	public void addFxrecords(List<String[]> records) throws ParseException{
		entityManager.flush();
		int i = 0;
		for(String[] record : records) {
			i++;
			SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy hh:mm");
			Date dealCreated = formatter.parse(record[0]);
			
			entityManager.persist(new Fxrecord(dealCreated, record[1], record[2], new BigDecimal(record[3])));
			
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
