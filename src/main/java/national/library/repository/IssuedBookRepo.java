package national.library.repository;

import national.library.domain.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBookRepo  extends JpaRepository<IssuedBook,Integer> {
}
