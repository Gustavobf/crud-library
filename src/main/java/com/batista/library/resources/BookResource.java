package com.batista.library.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batista.library.domain.Book;
import com.batista.library.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Book book = bookService.find(id);
		return ResponseEntity.ok().body(book);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		bookService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void create(@RequestBody Book book) {
		bookService.create(book);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Book> findAll(){
		return bookService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Book book) {
		bookService.update(book);
	}

}
