package tk.graalogosh.ppos.specifications;

import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Statement_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 11.09.2015.
 */
public class StatementSpecification implements Specification<Statement> {
    private Statement example;

    public StatementSpecification(Statement example) {
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (example.getStatementID() != null) {
            predicates.add(cb.equal(root.get(Statement_.statementID), example.getStatementID()));
        }

        if (example.getFillingDate() != null) {
            predicates.add(cb.equal(root.get(Statement_.fillingDate), example.getFillingDate()));
        }

        if (example.getStudent() != null) {
            predicates.add(cb.equal(root.get(Statement_.student), example.getStudent()));
        }

        if (example.getEvent() != null) {
            predicates.add(cb.equal(root.get(Statement_.event), example.getEvent()));
        }

        if (example.getEmployee() != null) {
            predicates.add(cb.equal(root.get(Statement_.employee), example.getEmployee()));
        }

        if (example.getSocialGrant() != null) {
            predicates.add(cb.equal(root.get(Statement_.socialGrant), example.getSocialCategory()));
        }

        if (example.getSocialCategory() != null) {
            predicates.add(cb.equal(root.get(Statement_.socialCategory), example.getSocialCategory()));
        }

        if (example.getSocialWork() != null) {
            predicates.add(cb.equal(root.get(Statement_.socialWork), example.getSocialWork()));
        }

        if (example.getMoneyCategory() != null) {
            predicates.add(cb.equal(root.get(Statement_.moneyCategory), example.getMoneyCategory()));
        }

        if (example.getCourse() != null) {
            predicates.add(cb.equal(root.get(Statement_.course), example.getCourse()));
        }

        if (example.getTripCount() != null) {
            predicates.add(cb.equal(root.get(Statement_.tripCount), example.getTripCount()));
        }
        //TODO fix score
        //if (example.getAverage_score()){}

        if (example.getRefusalCount() != null) {
            predicates.add(cb.equal(root.get(Statement_.refusalCount), example.getRefusalCount()));
        }

        if (example.getPermitNumber() != null) {
            predicates.add(cb.equal(root.get(Statement_.permitNumber), example.getPermitNumber()));
        }

        if (example.getRefusalDate() != null) {
            predicates.add(cb.equal(root.get(Statement_.refusalDate), example.getRefusalDate()));
        }

        if (example.getCancellationDate() != null) {
            predicates.add(cb.equal(root.get(Statement_.cancellationDate), example.getCancellationDate()));
        }

        if (example.getList() != null) {
            predicates.add(cb.equal(root.get(Statement_.list), example.getList()));
        }

        //TODO fix comment search
        if (example.getComment() != null) {
            predicates.add(cb.equal(root.get(Statement_.comment), example.getComment()));
        }

        if (example.getCompleteDocs() != null) {
            predicates.add(cb.equal(root.get(Statement_.completeDocs), example.getCompleteDocs()));
        }

        if (example.getReserve() != null) {
            predicates.add(cb.equal(root.get(Statement_.reserve), example.getReserve()));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
