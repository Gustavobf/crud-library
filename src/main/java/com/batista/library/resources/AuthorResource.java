package com.batista.library.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batista.library.domain.Author;
import com.batista.library.services.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorResource {

	@Autowired
	AuthorService authorService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Author author = authorService.find(id);
		return ResponseEntity.ok().body(author);
	}

}
