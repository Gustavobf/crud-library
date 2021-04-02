package com.batista.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batista.library.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
