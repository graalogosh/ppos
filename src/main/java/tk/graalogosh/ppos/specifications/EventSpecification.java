package tk.graalogosh.ppos.specifications;

import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.models.Event_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 01.10.2015.
 */
public class EventSpecification implements Specification<Event> {
    private Event example;

    public EventSpecification(Event example) {
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (example.getEventID()!=null){
           predicates.add(cb.equal(root.get(Event_.eventID), example.getEventID()));
        }

        if  (example.getTitle()!=null){
            predicates.add(cb.equal(root.get(Event_.title), example.getTitle()));
        }

        if (example.getEventDate()!=null){
            predicates.add(cb.equal(root.get(Event_.eventDate),example.getEventID()));
        }

        if (example.getDuration()!=null){
            predicates.add(cb.equal(root.get(Event_.duration), example.getDuration()));
        }

        if (example.getReseptionBegin()!=null){
            predicates.add(cb.equal(root.get(Event_.reseptionBegin), example.getReseptionBegin()));
        }

        if (example.getReseptionFinish()!=null){
            predicates.add(cb.equal(root.get(Event_.reseptionFinish), example.getReseptionFinish()));
        }

        if (example.getEmployee()!=null){
            predicates.add(cb.equal(root.get(Event_.employee), example.getEmployee()));
        }

        if (example.getSection()!=null){
            predicates.add(cb.equal(root.get(Event_.section), example.getSection()));
        }

        if (example.getNumberOfPlaces()!=null){
            predicates.add(cb.equal(root.get(Event_.numberOfPlaces), example.getNumberOfPlaces()));
        }

        if (example.getQuotasPercantage()!=null){
            predicates.add(cb.equal(root.get(Event_.quotasPercantage), example.getQuotasPercantage()));
        }

        if (example.getSuitableCategory()!=null){
            predicates.add(cb.like(root.get(Event_.suitableCategory), example.getSuitableCategory()));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
