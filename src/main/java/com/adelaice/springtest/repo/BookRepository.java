package com.adelaice.springtest.repo;

import com.adelaice.springtest.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adelaice on 15/04/21
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
