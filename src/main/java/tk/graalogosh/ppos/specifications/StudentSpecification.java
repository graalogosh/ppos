package tk.graalogosh.ppos.specifications;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.Student;
import tk.graalogosh.ppos.models.Student_; //generated by Hibernate Metamodel Generator

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 09.08.2015.
 */
public class StudentSpecification implements Specification<Student>{
    private Student example;

    public StudentSpecification(Student example) {
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotBlank(example.getStudentID())){
            predicates.add(cb.equal(root.get(Student_.studentID), example.getStudentID()));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }


}

