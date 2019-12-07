package national.library.repository;

import national.library.domain.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssuedBookRepo  extends JpaRepository<IssuedBook,Integer> {
    IssuedBook findByIssueID(Integer issuedID);
    List<IssuedBook> findByIsReturnedFalse();
}

