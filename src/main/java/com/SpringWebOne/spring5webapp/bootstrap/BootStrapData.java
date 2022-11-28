package com.SpringWebOne.spring5webapp.bootstrap;

import com.SpringWebOne.spring5webapp.domain.Author;
import com.SpringWebOne.spring5webapp.domain.Book;
import com.SpringWebOne.spring5webapp.domain.Publisher;
import com.SpringWebOne.spring5webapp.repositories.AuthorRepository;
import com.SpringWebOne.spring5webapp.repositories.BookRepository;
import com.SpringWebOne.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
        this.publisherRepository=publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Author shubhang=new Author("Shubhang","Vanjani");
        Book ddd= new Book("Domain Driven Design","123123");
        Publisher ramji=new Publisher("RamjiProds","Gujarat");
        shubhang.getBooks().add(ddd);
        ddd.getAuthors().add(shubhang);
        ramji.getPublisherName().add(ddd);


        authorRepository.save(shubhang);
        bookRepository.save(ddd);
        publisherRepository.save(ramji);

        Author karan=new Author("Karan","Mishra");
        Book fff= new Book("React Design Patterns","220499");
        Publisher samji=new Publisher("SamjiProds","UP");
        karan.getBooks().add(ddd);
        fff.getAuthors().add(karan);
        samji.getPublisherName().add(fff);


        authorRepository.save(karan);
        bookRepository.save(fff);
        publisherRepository.save(samji);

        System.out.println("Started Bootstrap");
        System.out.println("Number of books" + bookRepository.count());
        System.out.println("Publishers"+ publisherRepository.count());
    }
}
