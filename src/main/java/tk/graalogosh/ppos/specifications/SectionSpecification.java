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

        if (example.getSectionID()!=null){
            predicates.add(cb.equal(root.get(Section_.sectionID),example.getSectionID()));
        }

        if (example.getTitle()!=null){
            predicates.add(cb.equal(root.get(Section_.title),example.getTitle()));
        }

        if (example.getSocialGrant()!=null){
            predicates.add(cb.equal(root.get(Section_.socialGrant),example.getSocialGrant()));
        }

        if (example.getSocialCategory()!=null){
            predicates.add(cb.equal(root.get(Section_.socialCategory),example.getSocialCategory()));
        }

        if (example.getSocialWork()!=null){
            predicates.add(cb.equal(root.get(Section_.socialWork),example.getSocialWork()));
        }

        if (example.getAverageScore()!=null){
            predicates.add(cb.equal(root.get(Section_.averageScore),example.getAverageScore()));
        }

        if (example.getTripCount()!=null){
            predicates.add(cb.equal(root.get(Section_.tripCount),example.getTripCount()));
        }

        if (example.getRefusualCount()!=null){
            predicates.add(cb.equal(root.get(Section_.refusualCount),example.getRefusualCount()));
        }

        if (example.getCourse()!=null){
            predicates.add(cb.equal(root.get(Section_.course),example.getCourse()));
        }

        if (example.getPointSum()!=null){
            predicates.add(cb.equal(root.get(Section_.pointSum),example.getPointSum()));
        }

        if (example.getBankAccountNumber()!=null){
            predicates.add(cb.equal(root.get(Section_.bankAccountNumber),example.getBankAccountNumber()));
        }

        if (example.getList()!=null){
            predicates.add(cb.equal(root.get(Section_.list),example.getList()));
        }

        if (example.getRetrip()!=null){
            predicates.add(cb.equal(root.get(Section_.retrip),example.getRetrip()));
        }

        if (example.getMoneyCategory()!=null){
            predicates.add(cb.equal(root.get(Section_.moneyCategory),example.getMoneyCategory()));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }


}

