package library.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import library.spring.entity.Book;
import library.spring.service.BookService;

@Controller
@RequestMapping("/book")
public class LibraryController {

	final static Logger logger = Logger.getLogger(LibraryController.class);
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/getAllBooks")
	public String getAllBooks(Model model) {
		
		logger.info("Reading book collection");
		List<Book> books = bookService.getBooks();
		
		model.addAttribute("books", books);
		
		return "list-books";
	}
	
	@GetMapping("/showFormForAdd")
	public String ShowFormForAdd(Model model) {
		
		Book book = new Book();
		
		model.addAttribute("book", book);
		
		return "book-form";
	}
	
	@PostMapping("/addBook")
	public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
		
		logger.info("Validating provided data");
		if(bindingResult.hasErrors()) {
			logger.info("Book not added due to invalid user input");
			return "book-form";
		}
		bookService.saveBook(book);
		
		logger.info("Book added");
		
		return "redirect:/book/getAllBooks";
	}
	
}
