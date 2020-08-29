package ratz.springframwork.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ratz.springframwork.spring5webapp.model.Author;
import ratz.springframwork.spring5webapp.model.Book;
import ratz.springframwork.spring5webapp.repositories.AuthorRepository;
import ratz.springframwork.spring5webapp.repositories.BookRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){


        Author jonny = new Author("Jonny" , "Carol");
        Book azoresrox = new Book("AzoresRox", "1234", "Terceira Productions");
        jonny.getBooks().add(azoresrox);
        azoresrox.getAuthors().add(jonny);

        authorRepository.save(jonny);
        bookRepository.save(azoresrox);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2Ezz Dev", "23434", "workx");
        rod.getBooks().add(noEjb);

        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }

}
