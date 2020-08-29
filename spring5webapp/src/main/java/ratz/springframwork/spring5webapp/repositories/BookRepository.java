package ratz.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ratz.springframwork.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {


}
