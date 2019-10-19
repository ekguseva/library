package national.library.repository;

import national.library.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepo extends JpaRepository<Reader,Integer> {
}
