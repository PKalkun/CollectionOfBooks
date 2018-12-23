package library.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import library.spring.controller.LibraryController;
import library.spring.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	
	final static Logger logger = Logger.getLogger(BookDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> getBooks() {
		
		List<Book> books = null;
		
		try {
		Session session = sessionFactory.getCurrentSession();
		
		books = session.createSQLQuery("SELECT * FROM book").addEntity(Book.class).list();
		}catch(Exception e) {
			logger.error("Error while reading book collection from DB \n" + e.getMessage());
		}
		return books;
	}

	@Override
	public void saveBook(Book book) {
		try {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(book);
		}catch(Exception e) {
			logger.error("Could not save book to DB\n" + e.getMessage());
		}
		
	}

}
