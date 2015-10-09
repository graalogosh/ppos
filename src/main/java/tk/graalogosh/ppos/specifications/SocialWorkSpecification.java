package tk.graalogosh.ppos.specifications;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.SocialWork;
import tk.graalogosh.ppos.models.SocialWork_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 09.10.2015.
 */
public class SocialWorkSpecification implements Specification<SocialWork> {
    private SocialWork example;

    public SocialWorkSpecification(SocialWork example) {
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<SocialWork> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (example.getSocialWorkID()!=null){
            predicates.add(cb.equal(root.get(SocialWork_.socialWorkID),example.getSocialWorkID()));
        }

        if (StringUtils.isNotBlank(example.getTitle())){
            predicates.add(cb.equal(root.get(SocialWork_.title),example.getTitle()));
        }

        if (example.getPoint()!=null){
            predicates.add(cb.equal(root.get(SocialWork_.point),example.getPoint()));
        }

        if (example.getSocialWorkCategory()!=null){
            predicates.add(cb.equal(root.get(SocialWork_.socialWorkCategory),example.getSocialWorkCategory()));
        }

        if (example.getVisible()!=null){
            predicates.add(cb.equal(root.get(SocialWork_.visible),example.getVisible()));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
