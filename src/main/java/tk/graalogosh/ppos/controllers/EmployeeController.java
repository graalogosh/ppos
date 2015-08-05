package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.Employee;
import tk.graalogosh.ppos.repositories.EmployeeRepository;

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
    public Employee getEmployee(@RequestParam("employeeID") Integer employeeID) {
        Employee employee = employeeRepository.findOne(employeeID);
        System.out.println(employee);
        //employeeRepository.sa
        return employee;
    }
}
