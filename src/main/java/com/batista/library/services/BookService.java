package com.batista.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batista.library.domain.Book;
import com.batista.library.repositories.BookRepository;
import com.batista.library.services.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	BookRepository repo;

	public Book find(Integer id) {
		Optional<Book> book = repo.findById(id);
		return book.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Book.class.getName()));
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public void create(Book book) {
		repo.save(book);
	}
	
	public List<Book> findAll(){
		return repo.findAll();
	}
	
	public void update(Book book) {
		repo.save(book);
	}

}
