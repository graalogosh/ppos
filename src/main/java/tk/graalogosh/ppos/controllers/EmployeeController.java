package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.Employee;
import tk.graalogosh.ppos.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by graal on 05.08.2015.
 */
@RestController
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("employee")
    public Employee getEmployees(
            @RequestParam(value = "employeeID", defaultValue = "0") Integer employeeID,
            @RequestParam(value = "name", required = false)String name,
            @RequestParam(value = "accessLevel", required = false)int accessLevel,
            @RequestParam(value = "registrationDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate registrationDate,
            @RequestParam(value = "lastTimeLoginDate", required = false)@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastTimeLoginDate,
            @RequestParam(value = "dismissed", required = false) boolean dismissed,
            @RequestParam(value = "faculty", required = false) String faculty) {

        Employee example = new Employee();
    }
}
