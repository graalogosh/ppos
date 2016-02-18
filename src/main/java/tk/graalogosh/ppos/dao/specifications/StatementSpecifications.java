package tk.graalogosh.ppos.dao.specifications;

import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.*;
import tk.graalogosh.ppos.utils.Dates;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

/**
 * Created by graal on 11.09.2015.
 */
public class StatementSpecifications {
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

    public static Specification<Statement> completeDocsIs(Boolean completeDocs){
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

    public static Specification<Statement> permitNumberIsNotNull(){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.isNotNull(root.get(Statement_.permitNumber));
            }
        };
    }

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

//    public static Specification<Statement> findByEventSection (Section section){
//        return new Specification<Statement>() {
//            @Override
//            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                return cb.equal(root.get(Statement_.event))
//            }
//        }
//    }

    public static Specification<Statement> inTermOfDate(LocalDate date){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate isAfterTermStart = cb.greaterThanOrEqualTo(root.get(Statement_.fillingDate), Dates.getTermStartDate(date));
                Predicate isBeforeTermFinish = cb.lessThanOrEqualTo(root.get(Statement_.fillingDate), Dates.getTermFinishDate(date));
                return cb.and(isAfterTermStart, isBeforeTermFinish);
            }
        };
    }

    public static Specification<Statement> inCurrentTerm(){
        return inTermOfDate(LocalDate.now());
    }

    public static Specification<Statement> isActive(){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate isNotCancelled = cb.isNull(root.get(Statement_.cancellationDate));
                Predicate isNotRefused = cb.isNull(root.get(Statement_.refusalDate));
                return cb.and(isNotCancelled, isNotRefused);
            }
        };
    }

    public static Specification<Statement> IDIsNot (Integer statementID){
        return new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.notEqual(root.get(Statement_.statementID), statementID);
            }
        };
    }
}
