package org.ralphmorales.fx.repositories;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ralphmorales.fx.fxHarvester.FxHarvesterApplication;
import org.ralphmorales.fx.fxHarvester.entities.AccumulativeData;
import org.ralphmorales.fx.fxHarvester.entities.Fxinvalid;
import org.ralphmorales.fx.fxHarvester.repositories.AccumulativeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = FxHarvesterApplication.class)
public class AccumulativeDataRepositoryTest {
	
	@Autowired
	private AccumulativeDataRepository repository;

	
	@Test
	public void save_01() throws Exception {
		repository.save(new AccumulativeData("AED", 100));
		assertEquals(1, repository.count());
	}

	@Test
	public void save_02() throws Exception {
		repository.save(new AccumulativeData("AED", 100));
		repository.save(new AccumulativeData("PHP", 300));
		assertEquals(2, repository.count());
	}

	@Test
	public void save_03() throws Exception {

		List<AccumulativeData> AccumulativeDatas = new ArrayList<AccumulativeData>();
		AccumulativeDatas.add(new AccumulativeData("AED", 100));
		AccumulativeDatas.add(new AccumulativeData("PHP", 200));
		AccumulativeDatas.add(new AccumulativeData("USD", 150));

		repository.save(AccumulativeDatas);
		assertEquals(3, repository.count());
	}
	
	@Test
	public void find_01() throws Exception {
		repository.save(new AccumulativeData("AED", 100));
	
		AccumulativeData data = repository.findOne("AED");
		assertNotNull(data);
		assertTrue( data.getCountOfDeals().equals(100));
	}
	
	@Test
	public void find_02() throws Exception {
		repository.save(new AccumulativeData("AED", 100));
	
		AccumulativeData data = repository.findOne("USD");
		assertNull(data);
		
	}
	

	@Test
	public void delete_01() throws Exception {
		repository.save(new AccumulativeData("AED", 100));

		repository.delete(repository.findOne("AED"));
		
		assertEquals(0, repository.count());
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void delete_02() throws Exception {
		repository.delete("Invalid");

	}

}
