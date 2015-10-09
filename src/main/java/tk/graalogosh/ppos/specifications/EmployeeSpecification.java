package tk.graalogosh.ppos.specifications;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.Employee;
import tk.graalogosh.ppos.models.Employee_; //generated by Hibernate Metamodel Generator

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 17.09.2015.
 */
public class EmployeeSpecification implements Specification<Employee> {
    private Employee example;

    public EmployeeSpecification(Employee example){
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb){
        List<Predicate> predicates = new ArrayList<>();

        if (example.getEmployeeID()!=null){
            predicates.add(cb.equal(root.get(Employee_.employeeID), example.getEmployeeID()));
        }

        if (StringUtils.isNotBlank(example.getName())) {
            predicates.add(cb.like(root.get(Employee_.name), "%" + example.getName() + "%"));
        }

        if (example.getAccessLevel()!=null){
            predicates.add(cb.equal(root.get(Employee_.accessLevel), example.getAccessLevel()));
        }

        if (example.getRegistrationDate()!=null){
            predicates.add(cb.equal(root.get(Employee_.registrationDate), example.getRegistrationDate()));
        }

        if (example.getLastLoginDate()!=null){
            predicates.add(cb.equal(root.get(Employee_.lastLoginDate), example.getLastLoginDate()));
        }

        if (example.getDismissed()!=null){
            predicates.add(cb.equal(root.get(Employee_.dismissed), example.getDismissed()));
        }

        if (StringUtils.isNotBlank(example.getFaculty())){
            predicates.add(cb.like(root.get(Employee_.faculty), example.getFaculty()));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
