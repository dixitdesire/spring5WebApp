package com.springframework.spring5WebApp.repositories;

import com.springframework.spring5WebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
