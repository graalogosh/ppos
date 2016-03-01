package tk.graalogosh.ppos.dao.specifications;

import org.springframework.data.jpa.domain.Specification;
import tk.graalogosh.ppos.models.Employee;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.models.Event_;
import tk.graalogosh.ppos.models.Section;

import javax.naming.OperationNotSupportedException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

/**
 * Created by graal on 01.10.2015.
 */
public class EventSpecifications {
    public static Specification<Event> IDIs(Integer eventID){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.eventID),eventID);
            }
        };
    }

    public static Specification<Event> titleIs(String title){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.title), title);
            }
        };
    }

    public static Specification<Event> eventDateIs(LocalDate date){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.eventDate),date);
            }
        };
    }

    public static Specification<Event> durationIs(Integer duration){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.duration), duration);
            }
        };
    }

    public static Specification<Event> reseptionBeginIn(LocalDate date){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.reseptionBegin), date);
            }
        };
    }

    public static Specification<Event> reseptionFinishIn(LocalDate date){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.reseptionFinish), date);
            }
        };
    }

    public static Specification<Event> employeeIs (Employee employee){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.employee), employee);
            }
        };
    }

    public static Specification<Event> sectionIs (Section section){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.section), section);
            }
        };
    }

    public static Specification<Event> numberOfPlacesIs (Integer number){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.numberOfPlaces), number);
            }
        };
    }

    public static Specification<Event> quotasPercantageIs (Integer quotas){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Event_.quotasPercantage),quotas);
            }
        };
    }

    public static Specification<Event> findBetweenDates (LocalDate date1, LocalDate date2){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate eventIsAfterDate1 = cb.greaterThanOrEqualTo(root.get(Event_.eventDate), date1);
                Predicate eventIsBeforeDate2 = cb.lessThanOrEqualTo(root.get(Event_.eventDate), date2);
                return cb.and(eventIsAfterDate1,eventIsBeforeDate2);
            }
        };
    }

    public static Specification<Event> eventIsBefore (LocalDate date){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.lessThanOrEqualTo(root.get(Event_.eventDate), date);
            }
        };
    }

    public static Specification<Event> eventIsAfter (LocalDate date){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.greaterThanOrEqualTo(root.get(Event_.eventDate), date);
            }
        };
    }

    public static Specification<Event> findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate date){
        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //e.reseptionBegin<=?1 and e.reseptionFinish>=?1
                Predicate reseptionStartIsBeforeDate = cb.lessThanOrEqualTo(root.get(Event_.reseptionBegin),date);
                Predicate reseptionFinishIsAfterDate = cb.greaterThanOrEqualTo(root.get(Event_.reseptionFinish), date);
                return cb.and(reseptionStartIsBeforeDate, reseptionFinishIsAfterDate);
            }
        };
    }

    //TODO fix category
    public static Specification<Event> suitableCategoryIs (String category) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
