package com.batista.library;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.batista.library.domain.Author;
import com.batista.library.domain.Book;
import com.batista.library.domain.Genre;
import com.batista.library.repositories.AuthorRepository;
import com.batista.library.repositories.BookRepository;
import com.batista.library.repositories.GenreRepository;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Author a1 = new Author(null, "John", 37);
		Author a2 = new Author(null, "Lara", 25);
		
		Genre g1 = new Genre(null, "Action");
		Genre g2 = new Genre(null, "Drama");
		
		Book b1 = new Book(null, "Roses", 2010, 20.5, a1, g1);
		Book b2 = new Book(null, "Red", 2020, 15.6, a2, g2);
		
		
		authorRepository.saveAll(Arrays.asList(a1, a2));
		genreRepository.saveAll(Arrays.asList(g1, g2));
		bookRepository.saveAll(Arrays.asList(b1, b2));
		
	}

}
