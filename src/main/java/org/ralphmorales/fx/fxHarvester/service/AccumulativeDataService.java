package org.ralphmorales.fx.fxHarvester.service;

import org.ralphmorales.fx.fxHarvester.entities.AccumulativeData;
import org.ralphmorales.fx.fxHarvester.repositories.AccumulativeDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccumulativeDataService {
	
	private static final Logger log = LoggerFactory.getLogger(AccumulativeDataService.class);
	
	@Autowired
	private AccumulativeDataRepository accumulativeDataRepository;
	
	public AccumulativeData getAccumulativeData(String currency){
		AccumulativeData data = accumulativeDataRepository.findOne(currency);
		
		if(data == null) {
			return new AccumulativeData(currency, 0);
		} else {
			data.incrementCountOfDeals();
			return data;
		}
	}

}
