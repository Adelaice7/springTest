package com.adelaice.springtest.repo;

import com.adelaice.springtest.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adelaice on 15/04/21
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
