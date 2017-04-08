package org.ralphmorales.fx.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ralphmorales.fx.fxHarvester.FxHarvesterApplication;
import org.ralphmorales.fx.fxHarvester.entities.Fxinvalid;
import org.ralphmorales.fx.fxHarvester.repositories.FxinvalidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = FxHarvesterApplication.class)
public class FxinvalidRepositoryTest {

	@Autowired
	private FxinvalidRepository repository;

	@Test
	public void save_01() throws Exception {
		repository.save(new Fxinvalid(new Date(), "Invalid Record", "Invalid currency", "file path"));
		assertEquals(1, repository.count());
	}

	@Test
	public void save_02() throws Exception {
		repository.save(new Fxinvalid(new Date(), "Invalid Record", "Invalid currency", "file path"));
		repository.save(new Fxinvalid(new Date(), "Invalid Record", "Invalid currency", "file path"));
		assertEquals(2, repository.count());
	}

	@Test
	public void save_03() throws Exception {

		List<Fxinvalid> Fxinvalids = new ArrayList<Fxinvalid>();
		Fxinvalids.add(new Fxinvalid(new Date(), "Invalid Record", "Invalid currency", "file path"));
		Fxinvalids.add(new Fxinvalid(new Date(), "Invalid Record", "Invalid currency", "file path"));
		Fxinvalids.add(new Fxinvalid(new Date(), "Invalid Record", "Invalid currency", "file path"));

		repository.save(Fxinvalids);
		assertEquals(3, repository.count());
	}

	@Test
	public void delete_01() throws Exception {
		repository.save(new Fxinvalid(new Date(), "Invalid Record", "Invalid currency", "file path"));

		for (Fxinvalid Fxinvalid : repository.findAll()) {
			repository.delete(repository.findOne(Fxinvalid.getId()));
		}

		assertEquals(0, repository.count());
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void delete_02() throws Exception {
		repository.delete(new Long(1));

	}

	@Test
	public void find_01() throws Exception {
		List<Fxinvalid> Fxinvalids = new ArrayList<Fxinvalid>();
		Fxinvalids.add(new Fxinvalid(new Date(), "Invalid Record", "Invalid currency", "file path"));
		Fxinvalids.add(new Fxinvalid(new Date(), "Invalid Record", "Invalid amount format", "file path"));
		Fxinvalids.add(new Fxinvalid(new Date(), "Invalid Record", "Invalid currency", "file path"));

		repository.save(Fxinvalids);
		int count = 0;
		for (Fxinvalid Fxinvalid : repository.findAll()) {
			if (Fxinvalid.getCause().equals("Invalid currency")) {
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