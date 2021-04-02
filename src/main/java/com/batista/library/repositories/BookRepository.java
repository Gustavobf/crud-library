package com.batista.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batista.library.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
