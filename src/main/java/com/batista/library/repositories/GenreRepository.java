package com.batista.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batista.library.domain.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
