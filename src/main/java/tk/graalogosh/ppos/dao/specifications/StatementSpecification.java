package tk.graalogosh.ppos.dao.specifications;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 11.09.2015.
 */
//public class StatementSpecification implements Specification<Statement> {
//    private Statement example;
//
//    public StatementSpecification(Statement example) {
//        this.example = example;
//    }
//
//    @Override
//    public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
//        List<Predicate> predicates = new ArrayList<>();
//
//        if (example.getStatementID() != null) {
//            predicates.add(cb.equal(root.get(Statement_.statementID), example.getStatementID()));
//        }
//
//        if (example.getFillingDate() != null) {
//            predicates.add(cb.equal(root.get(Statement_.fillingDate), example.getFillingDate()));
//        }
//
//        if (example.getStudent() != null) {
//            predicates.add(cb.equal(root.get(Statement_.student), example.getStudent()));
//        }
//
//        if (example.getEvent() != null) {
//            predicates.add(cb.equal(root.get(Statement_.event), example.getEvent()));
//        }
//
//        if (example.getEmployee() != null) {
//            predicates.add(cb.equal(root.get(Statement_.employee), example.getEmployee()));
//        }
//
//        if (example.getSocialGrant() != null) {
//            predicates.add(cb.equal(root.get(Statement_.socialGrant), example.getSocialCategory()));
//        }
//
//        if (example.getSocialCategory() != null) {
//            predicates.add(cb.equal(root.get(Statement_.socialCategory), example.getSocialCategory()));
//        }
//
//        if (example.getSocialWork() != null) {
//            predicates.add(cb.equal(root.get(Statement_.socialWork), example.getSocialWork()));
//        }
//
//        if (example.getMoneyCategory() != null) {
//            predicates.add(cb.equal(root.get(Statement_.moneyCategory), example.getMoneyCategory()));
//        }
//
//        if (example.getCourse() != null) {
//            predicates.add(cb.equal(root.get(Statement_.course), example.getCourse()));
//        }
//
//        if (example.getTripCount() != null) {
//            predicates.add(cb.equal(root.get(Statement_.tripCount), example.getTripCount()));
//        }
//        //TODO fix score
//        //if (example.getAverage_score()){}
//
//        if (example.getRefusalCount() != null) {
//            predicates.add(cb.equal(root.get(Statement_.refusalCount), example.getRefusalCount()));
//        }
//
//        if (example.getPermitNumber() != null) {
//            predicates.add(cb.equal(root.get(Statement_.permitNumber), example.getPermitNumber()));
//        }
//
//        if (example.getRefusalDate() != null) {
//            predicates.add(cb.equal(root.get(Statement_.refusalDate), example.getRefusalDate()));
//        }
//
//        if (example.getCancellationDate() != null) {
//            predicates.add(cb.equal(root.get(Statement_.cancellationDate), example.getCancellationDate()));
//        }
//
//        if (example.getList() != null) {
//            predicates.add(cb.equal(root.get(Statement_.list), example.getList()));
//        }
//
//        //TODO fix comment search
//        if (example.getComment() != null) {
//            predicates.add(cb.equal(root.get(Statement_.comment), example.getComment()));
//        }
//
//        if (example.getCompleteDocs() != null) {
//            predicates.add(cb.equal(root.get(Statement_.completeDocs), example.getCompleteDocs()));
//        }
//
//        if (example.getReserve() != null) {
//            predicates.add(cb.equal(root.get(Statement_.reserve), example.getReserve()));
//        }
//
//        return andTogether(predicates, cb);
//    }
//
//    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
//        return cb.and(predicates.toArray(new Predicate[0]));
//    }
//}

public class StatementSpecification{
    public static Specification<Statement> IDIs(Integer statementID){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.statementID), statementID);
            }
        };
    }

    public static Specification<Statement> fillingDateIs(LocalDate date){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.fillingDate), date);
            }
        };
    }

    public static Specification<Statement> studentIs(Student student){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.student), student);
            }
        };
    }

    public static Specification<Statement> eventIs (Event event){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.event), event);
            }
        };
    }

    public static Specification<Statement> employeeIs(Employee employee){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.employee), employee);
            }
        };
    }

    public static Specification<Statement> socialCategoryIs (SocialCategory socialCategory){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.socialCategory), socialCategory);
            }
        };
    }

    public static Specification<Statement> socialWorkIs (SocialWork socialWork){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.socialWork), socialWork);
            }
        };
    }

    public static Specification<Statement> moneyCategoryIs(Double money){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.moneyCategory), money);
            }
        };
    }

    public static Specification<Statement> courseIs (Course course){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.course), course);
            }
        };
    }

    public static Specification<Statement> tripCountIs (TripCount tripCount){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.tripCount), tripCount);
            }
        };
    }

    //TODO averageScore

    public static Specification<Statement> refusalCountIs (Refusal refusal){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.refusalCount), refusal);
            }
        };
    }

    public static Specification<Statement> permitNumberIs (Integer permitNumber){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.permitNumber), permitNumber);
            }
        };
    }

    public static Specification<Statement> refusalDateIs (LocalDate refusalDate){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.refusalDate), refusalDate);
            }
        };
    }

    public static Specification<Statement> cancellationDateIs (LocalDate cancellationDate){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.cancellationDate), cancellationDate);
            }
        };
    }

    public static Specification<Statement> statementListIs (StatementList statementList){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.list), statementList);
            }
        };
    }

    public static Specification<Statement> commentIs (String comment){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.comment), comment);
            }
        };
    }

    public static Specification<Statement> completeDoscIs (Boolean completeDocs){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.completeDocs), completeDocs);
            }
        };
    }

    public static Specification<Statement> reserveIs (Boolean reserve){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(Statement_.reserve), reserve);
            }
        };
    }

//    List<Statement> findByPermitNumberIsNotNull();
    public static Specification<Statement> permitNumberIsNotNull(){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.isNotNull(root.get(Statement_.permitNumber));
            }
        };
    }

//    Statement findByStudentAndEvent(Student student, Event event);
    public static Specification<Statement> findByStudentAndEvent(Student student, Event event){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate studentIs = cb.equal(root.get(Statement_.student),student);
                Predicate eventIs = cb.equal(root.get(Statement_.event), event);
                return cb.and(studentIs,eventIs);
            }
        };
    }
}
