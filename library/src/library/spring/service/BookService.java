package library.spring.service;

import java.util.List;

import library.spring.entity.Book;

public interface BookService {

	public List<Book> getBooks();

	public void saveBook(Book book);
	
}
