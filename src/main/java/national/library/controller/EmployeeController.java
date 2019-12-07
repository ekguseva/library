package national.library.controller;

import national.library.domain.Employee;
import national.library.repository.EmployeeRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class EmployeeController {
    private static EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public static Employee getCurrentEmployee() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Object obj = auth.getPrincipal();
        String employeeName = "";

        if (obj instanceof UserDetails) {
            employeeName = ((UserDetails) obj).getUsername();
        } else {
            employeeName = obj.toString();
        }

        Employee e = employeeRepo.findByUsername(employeeName);
        return e;
    }
}
