package tk.graalogosh.ppos.specifications;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.SocialCategory;
import tk.graalogosh.ppos.models.SocialCategory_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 09.10.2015.
 */
public class SocialCategorySpecification implements Specification<SocialCategory> {
    private SocialCategory example;

    public SocialCategorySpecification(SocialCategory example) {
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<SocialCategory> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (example.getSocialCategoryID() != null) {
            predicates.add(cb.equal(root.get(SocialCategory_.socialCategoryID), example.getSocialCategoryID()));
        }

        if (StringUtils.isNotEmpty(example.getTitle())) {
            predicates.add(cb.equal(root.get(SocialCategory_.title), example.getTitle()));
        }

        if (example.getPriority() != null) {
            predicates.add(cb.equal(root.get(SocialCategory_.priority), example.getPriority()));
        }

        if (example.getPoint() != null) {
            predicates.add(cb.equal(root.get(SocialCategory_.point), example.getPoint()));
        }

        if (StringUtils.isNotBlank(example.getTitle())) {
            predicates.add(cb.equal(root.get(SocialCategory_.title), example.getTitle()));
        }

        if (example.getMoney() != null) {
            predicates.add(cb.equal(root.get(SocialCategory_.money), example.getMoney()));
        }

        if (example.getVisible() != null) {
            predicates.add(cb.equal(root.get(SocialCategory_.visible), example.getVisible()));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
