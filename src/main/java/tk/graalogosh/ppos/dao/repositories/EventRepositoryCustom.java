package tk.graalogosh.ppos.dao.repositories;

import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.models.Student;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 15.10.2015.
 */
public interface EventRepositoryCustom {
    Boolean haveStudentBeenOnEventOrAncestorEvent(Student student, Event event);

    //List<Event> findByEventOrAncestor (Event event);
}
