package com.batista.library.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batista.library.domain.Genre;
import com.batista.library.services.GenreService;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {

	@Autowired
	GenreService genreService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Genre genre = genreService.find(id);
		return ResponseEntity.ok().body(genre);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		genreService.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void create(@RequestBody Genre genre) {
		genreService.create(genre);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Genre> findAll(){
		return genreService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Genre genre){
		genreService.update(genre);
	}

}
