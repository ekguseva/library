package national.library.controller;

import national.library.domain.Employee;
import national.library.domain.Role;
import national.library.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping
public class RegistrationController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Employee employee, Map<String,Object> model){
        Employee employeeFromDb = employeeRepo.findByUsername(employee.getUsername());

        if (employeeFromDb!=null){
            model.put("message","User Exist");
            return "registration";
        }

        employee.setActive(true);
        employee.setRoles(Collections.singleton(Role.USER));
        employeeRepo.save(employee);
        return "redirect:/login";
    }
}
