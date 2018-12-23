package library.spring.dao;

import java.util.List;

import library.spring.entity.Book;

public interface BookDAO {

	public List<Book> getBooks();

	public void saveBook(Book book);
}
