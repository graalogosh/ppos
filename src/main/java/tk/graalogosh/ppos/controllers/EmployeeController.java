package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.Employee;
import tk.graalogosh.ppos.dao.repositories.EmployeeRepository;
import tk.graalogosh.ppos.dao.specifications.EmployeeSpecification;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by graal on 05.08.2015.
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     *
     * @param employeeID идентификатор сотрудника
     * @param name ФИО сотрудника
     * @param accessLevel уровень доступа
     * @param registrationDate дата регистрации
     * @param lastTimeLoginDate дата последнего использования программы
     * @param dismissed уволен ли сотрудник
     * @param faculty факультет сотрудника
     * @return List(Employee) список сотрудников, подходящих под описание
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees(
            @RequestParam(value = "employeeID", required = false) Integer employeeID,
            @RequestParam(value = "name", required = false)String name,
            @RequestParam(value = "accessLevel", required = false)Integer accessLevel,
            @RequestParam(value = "registrationDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate registrationDate,
            @RequestParam(value = "lastTimeLoginDate", required = false)@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastTimeLoginDate,
            @RequestParam(value = "dismissed", required = false) Boolean dismissed,
            @RequestParam(value = "faculty", required = false) String faculty) {

        Employee example = new Employee();
        example.setEmployeeID(employeeID);
        example.setName(name);
        example.setAccessLevel(accessLevel);
        example.setRegistrationDate(registrationDate);
        example.setLastLoginDate(lastTimeLoginDate);
        example.setDismissed(dismissed);
        example.setFaculty(faculty);

        EmployeeSpecification specification = new EmployeeSpecification(example);
        List<Employee> employees = employeeRepository.findAll(specification);
        return  employees;
    }
}
