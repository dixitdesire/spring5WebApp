package com.springframework.spring5WebApp.bootstrap;

import com.springframework.spring5WebApp.model.Author;
import com.springframework.spring5WebApp.model.Book;
import com.springframework.spring5WebApp.model.Publisher;
import com.springframework.spring5WebApp.repositories.AuthorRepository;
import com.springframework.spring5WebApp.repositories.BookRepository;
import com.springframework.spring5WebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

    private void initData(){

        Publisher publisher = new Publisher("Harper Collins", "Draper");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");

        Book ddd = new Book("Domain Driven Design", "98898712", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


    }
}
