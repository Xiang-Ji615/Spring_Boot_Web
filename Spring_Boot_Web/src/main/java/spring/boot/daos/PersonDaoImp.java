package main.java.spring.boot.daos;

import org.springframework.stereotype.Service;

import main.java.spring.boot.models.Person;

@Service("PersonDaoPRD")
public class PersonDaoImp implements IPersonDao {

	@Override
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
