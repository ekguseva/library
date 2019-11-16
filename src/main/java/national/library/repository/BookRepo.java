package national.library.repository;

import national.library.domain.Author;
import national.library.domain.Book;
import national.library.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {
   List<Book> findByNameAndAuthorAndGenre(String name, Author author, Genre genre);
}
