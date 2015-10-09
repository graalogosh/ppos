package tk.graalogosh.ppos.specifications;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.jpamodelgen.util.StringUtil;
import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.SocialWorkCategory;
import tk.graalogosh.ppos.models.SocialWorkCategory_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 09.10.2015.
 */
public class SocialWorkCategorySpecification implements Specification<SocialWorkCategory>{
    private SocialWorkCategory example;

    public SocialWorkCategorySpecification(SocialWorkCategory example) {
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<SocialWorkCategory> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (example.getSocialWorkCategoryID()!=null){
            predicates.add(cb.equal(root.get(SocialWorkCategory_.socialWorkCategoryID),example.getSocialWorkCategoryID()));
        }

        if(StringUtils.isNotBlank(example.getTitle())){
            predicates.add(cb.equal(root.get(SocialWorkCategory_.title),example.getTitle()));
        }

        if(example.getVisible()!=null){
           predicates.add(cb.equal(root.get(SocialWorkCategory_.visible),example.getVisible()));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
