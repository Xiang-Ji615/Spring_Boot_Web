package main.java.spring.boot.test.daos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import main.java.spring.boot.daos.IPersonDao;
import main.java.spring.boot.models.Person;

@Service("PersonDaoDEV")
public class TestPersonDaoImp implements IPersonDao {

	List<Person> TestPeople = new ArrayList<Person>();

	@PostConstruct
	public void initTestData() {
		TestPeople.add(new Person(1, "Jasper", 30, "Goerge St", Person.Male));
		TestPeople.add(new Person(2, "Sharon", 30, "Test St", Person.Female));
	}

	@Override
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		for (Person p : TestPeople) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

}
