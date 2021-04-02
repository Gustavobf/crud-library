package com.batista.library.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batista.library.domain.Author;
import com.batista.library.domain.Book;
import com.batista.library.repositories.AuthorRepository;
import com.batista.library.services.exceptions.ObjectNotFoundException;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repo;

	public Author find(Integer id) {
		Optional<Author> author = repo.findById(id);
		return author.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Book.class.getName()));
	}

}
