package com.batista.library.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		authorService.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void create(@RequestBody Author author) {
		authorService.create(author);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Author> findAll() {
		return authorService.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Author author) {
		authorService.update(author);
	}

}
