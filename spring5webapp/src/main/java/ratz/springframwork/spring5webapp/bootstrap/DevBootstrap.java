package ratz.springframwork.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ratz.springframwork.spring5webapp.model.Author;
import ratz.springframwork.spring5webapp.model.Book;
import ratz.springframwork.spring5webapp.model.Publisher;
import ratz.springframwork.spring5webapp.repositories.AuthorRepository;
import ratz.springframwork.spring5webapp.repositories.BookRepository;
import ratz.springframwork.spring5webapp.repositories.PublisherRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        Author jonny = new Author("Jonny", "Carol");
        Book azoresrox = new Book("AzoresRox", "1234", publisher);
        jonny.getBooks().add(azoresrox);
        azoresrox.getAuthors().add(jonny);

        authorRepository.save(jonny);
        bookRepository.save(azoresrox);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2Ezz Dev", "23434", publisher);
        rod.getBooks().add(noEjb);

        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }

}
