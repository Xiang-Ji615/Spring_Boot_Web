package main.java.spring.boot.daos;

import main.java.spring.boot.models.Person;

public interface IPersonDao {
	Person getPerson(int id);
}
