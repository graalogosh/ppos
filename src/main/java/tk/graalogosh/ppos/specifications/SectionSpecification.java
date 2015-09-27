package tk.graalogosh.ppos.specifications;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.models.Section_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 09.08.2015.
 */
public class SectionSpecification implements Specification<Section>{
    private Section example;

    public SectionSpecification(Section example) {
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<Section> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        throw new NotImplementedException();

        //return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }


}

