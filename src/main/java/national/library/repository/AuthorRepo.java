package national.library.repository;

import national.library.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository <Author,Integer> {
}
