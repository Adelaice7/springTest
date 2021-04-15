package com.adelaice.springtest.repo;

import com.adelaice.springtest.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adelaice on 15/04/21
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
