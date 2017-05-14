package main.java.sharon.movieuploader.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import main.java.sharon.movieuploader.model.Movie;

@Component
public class HibenateMovieDaoImp extends AbstractHibernateDao implements IMovieDao {

	@Override
	public Boolean saveMovie(Movie movie) {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactoryMovie.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			session.saveOrUpdate(movie);
			tx.commit();

		} catch (RuntimeException e) {
			try {
				tx.rollback();
				return false;
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction : " + rbe);
			}
		} finally {
			if (session != null) {
				session.close();

			}
		}
		return true;
	}

	@Override
	public Boolean deleteAllMovie() {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactoryMovie.openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			Query query = session.createQuery("from Movie");
			query.executeUpdate();
			tx.commit();

		} catch (RuntimeException e) {
			try {
				tx.rollback();
				return false;
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction : " + rbe);
			}
		} finally {
			if (session != null) {
				session.close();

			}
		}
		return true;
	}

}
