package national.library.repository;

import national.library.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepo extends JpaRepository <Author,Integer> {
    Author findByName(String name);
}
