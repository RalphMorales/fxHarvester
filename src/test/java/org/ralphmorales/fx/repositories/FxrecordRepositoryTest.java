package org.ralphmorales.fx.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ralphmorales.fx.fxHarvester.FxHarvesterApplication;
import org.ralphmorales.fx.fxHarvester.entities.Fxrecord;
import org.ralphmorales.fx.fxHarvester.repositories.FxrecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes=FxHarvesterApplication.class)
public class FxrecordRepositoryTest {

    @Autowired
    private FxrecordRepository repository;

    @Test
    public void save_01() throws Exception {
    	repository.save(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(8000)));
        assertEquals(1, repository.count());
    }
    
    @Test
    public void save_02() throws Exception {
    	repository.save(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(8000)));
    	repository.save(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(8000)));
        assertEquals(2, repository.count());
    }
    
    @Test
    public void save_03() throws Exception {
    	
    	List<Fxrecord> fxRecords = new ArrayList<Fxrecord>();
    	fxRecords.add(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(8000)));
    	fxRecords.add(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(8000)));
    	fxRecords.add(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(8000)));
    
    	repository.save(fxRecords);
        assertEquals(3, repository.count());
    }
    
    @Test
    public void delete_01() throws Exception {
    	repository.save(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(8000)));
    	
    	for(Fxrecord fxRecord : repository.findAll()){
    		repository.delete(repository.findOne(fxRecord.getId()));
    	}
    	 	
        assertEquals(0, repository.count());
    }
    
    @Test(expected=EmptyResultDataAccessException.class)
    public void delete_02() throws Exception {
    	repository.delete(new Long(1));
    	
    }
    
    @Test
    public void find_01() throws Exception {
    	List<Fxrecord> fxRecords = new ArrayList<Fxrecord>();
    	fxRecords.add(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(8000)));
    	fxRecords.add(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(7000)));
    	fxRecords.add(new Fxrecord(new Date(), "AED", "USD", new BigDecimal(8000)));
    
    	repository.save(fxRecords);
    	int count = 0;
    	for(Fxrecord fxRecord : repository.findAll()){
    		if(fxRecord.getAmount().equals(new BigDecimal(8000))){
    		count++;
    		}
    	}
    	
    	assertEquals(2, count);
    }
    
    @Test()
    public void find_02() throws Exception {
    	assertNull(repository.findOne(new Long(1)));
    	
    }

}