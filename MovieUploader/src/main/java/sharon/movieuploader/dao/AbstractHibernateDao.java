package main.java.sharon.movieuploader.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractHibernateDao {

	@Autowired
	protected SessionFactory sessionFactoryMovie;
}
