package national.library.repository;

import national.library.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo  extends JpaRepository<Employee,Integer> {
    Employee findByUsername(String username);
    Employee findByEmployeeID(Integer employeeID);
}
