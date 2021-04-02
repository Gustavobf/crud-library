package com.batista.library.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

}
