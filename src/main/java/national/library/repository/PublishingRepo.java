package national.library.repository;

import national.library.domain.Publishing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishingRepo extends JpaRepository<Publishing,Integer> {
}
