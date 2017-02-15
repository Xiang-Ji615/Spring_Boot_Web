package main.test.spring.boot.daos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import main.java.spring.boot.daos.IPersonDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Spring.xml")
public class PersonDaoTest {

	@Autowired
	@Qualifier("PersonDaoDEV")
	private IPersonDao personDao;

	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}

	@Test
	public void getPersonTestWithResult() {
		Assert.notNull(personDao.getPerson(1));
	}
	
	@Test
	public void getPersonTestWithNoResult() {
		Assert.isNull(personDao.getPerson(0));
	}
}
