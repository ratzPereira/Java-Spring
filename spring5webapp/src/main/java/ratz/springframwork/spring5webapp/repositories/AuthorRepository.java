package ratz.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ratz.springframwork.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {


}
