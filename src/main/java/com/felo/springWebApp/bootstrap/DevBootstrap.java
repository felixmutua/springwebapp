package com.felo.springWebApp.bootstrap;

import com.felo.springWebApp.model.Author;
import com.felo.springWebApp.model.Book;
import com.felo.springWebApp.model.Publisher;
import com.felo.springWebApp.repository.AuthorRepository;
import com.felo.springWebApp.repository.BookRepository;
import com.felo.springWebApp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

        private AuthorRepository authorRepository;
        private BookRepository bookRepository;
        private PublisherRepository publisherRepository;

        public DevBootstrap (AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
            this.authorRepository=authorRepository;
            this.bookRepository=bookRepository;
            this.publisherRepository=publisherRepository;

        }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();

    }

    private void initData(){
        //Add Author Felix
        Author author =new Author("Felix","Evans");
        Publisher publisher= new Publisher();
        publisher.setName("Oxford");
        publisher.setAddress("Nairobi");
        publisherRepository.save(publisher);

        Book book = new Book("Python Programming", "1234",publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);
        authorRepository.save(author);
        bookRepository.save(book);

        //Add Author Felix
        Author author1 =new Author("Faith","Nzula");
         Book book1 = new Book("Python Programming 2", "222",publisher);
        author.getBooks().add(book1);
        book1.getAuthors().add(author1);
        authorRepository.save(author1);
        bookRepository.save(book1);




    }
}
