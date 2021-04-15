package com.adelaice.springtest.bootstrap;

import com.adelaice.springtest.model.Author;
import com.adelaice.springtest.model.Book;
import com.adelaice.springtest.model.Publisher;
import com.adelaice.springtest.repo.AuthorRepository;
import com.adelaice.springtest.repo.BookRepository;
import com.adelaice.springtest.repo.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by adelaice on 15/04/21
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher booksWorld = new Publisher("Books World", "123 Main Street, London, UK");
        Author jk = new Author("J. K.", "Rowling");
        Book hp1 = new Book("Harry Potter and the Philosopher's Stone", "1234", booksWorld);
        jk.getBooks().add(hp1);
        hp1.getAuthors().add(jk);

        publisherRepository.save(booksWorld);
        authorRepository.save(jk);
        bookRepository.save(hp1);

        Author georgeRRMartin = new Author("George R. R.", "Martin");
        Publisher gotPub = new Publisher("Game of Thrones Pub.", "5346 Prescott St, SF, 29171");
        Book fireAndIce = new Book("Fire and Ice", "8456878", gotPub);
        georgeRRMartin.getBooks().add(fireAndIce);
        fireAndIce.getAuthors().add(georgeRRMartin);

        publisherRepository.save(gotPub);
        authorRepository.save(georgeRRMartin);
        bookRepository.save(fireAndIce);
    }
}
