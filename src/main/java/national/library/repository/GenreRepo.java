package national.library.repository;

import national.library.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre,Integer> {
    Genre findByName (String name);
}
