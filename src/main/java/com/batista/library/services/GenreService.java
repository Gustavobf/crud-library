package com.batista.library.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batista.library.domain.Book;
import com.batista.library.domain.Genre;
import com.batista.library.repositories.GenreRepository;
import com.batista.library.services.exceptions.ObjectNotFoundException;

@Service
public class GenreService {

	@Autowired
	GenreRepository repo;

	public Genre find(Integer id) {
		Optional<Genre> genre = repo.findById(id);
		return genre.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Book.class.getName()));
	}

}
