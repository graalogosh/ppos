package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.dao.repositories.FacultyRepository;
import tk.graalogosh.ppos.models.Employee;
import tk.graalogosh.ppos.dao.repositories.EmployeeRepository;
import tk.graalogosh.ppos.dao.specifications.EmployeeSpecifications;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 05.08.2015.
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
   @Autowired
    private EmployeeRepository employeeRepository;
@Autowired
private FacultyRepository facultyRepository;

    /**
     * @param employeeID        идентификатор сотрудника
     * @param name              ФИО сотрудника
     * @param accessLevel       уровень доступа
     * @param registrationDate  дата регистрации
     * @param lastTimeLoginDate дата последнего использования программы
     * @param dismissed         уволен ли сотрудник
     * @param faculty           факультет сотрудника
     * @return List(Employee) список сотрудников, подходящих под описание
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees(
            @RequestParam(value = "employeeID", required = false) Integer employeeID,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "accessLevel", required = false) Integer accessLevel,
            @RequestParam(value = "registrationDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate registrationDate,
            @RequestParam(value = "lastTimeLoginDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastTimeLoginDate,
            @RequestParam(value = "dismissed", required = false) Boolean dismissed,
            @RequestParam(value = "faculty", required = false) String faculty) {

        List<Specification<Employee>> specifications = new ArrayList<>();
        if (employeeID != null) {
            specifications.add(EmployeeSpecifications.IDIs(employeeID));
        }

        if (name != null) {
            specifications.add(EmployeeSpecifications.nameIs(name));
        }

        if (accessLevel != null) {
            specifications.add(EmployeeSpecifications.accessLevelIs(accessLevel));
        }

        if (registrationDate != null) {
            specifications.add(EmployeeSpecifications.registrationDateIs(registrationDate));
        }

        if (lastTimeLoginDate != null) {
            specifications.add(EmployeeSpecifications.lastLoginDateIs(lastTimeLoginDate));

        }

        if (dismissed != null) {
            specifications.add(EmployeeSpecifications.isDismissed(dismissed));
        }

        if (faculty != null) {
            specifications.add(EmployeeSpecifications.facultyIs(facultyRepository.findOne(faculty)));
        }

        Specification<Employee> finalSpecification = null;
        for (Specification<Employee> spec : specifications) {
            finalSpecification = Specifications.where(finalSpecification).and(spec);
        }
        return employeeRepository.findAll(finalSpecification);
    }
}
