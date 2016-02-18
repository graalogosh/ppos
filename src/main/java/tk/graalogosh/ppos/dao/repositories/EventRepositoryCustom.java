package tk.graalogosh.ppos.dao.repositories;

import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 15.10.2015.
 */
public interface EventRepositoryCustom {
    Boolean haveStudentBeenOnAncestorEvent(Student student, Event event);

    Boolean haveStudentBeenOnEvent(Student student, Event event);
    //List<Event> findByEventOrAncestor (Event event);

    Boolean studentMadeStatementOnEvent(Student student, Event event);

    Boolean haveStudentBeenOnAncestorEventWithoutStatement(Student student, Event event, Statement statement);

    Boolean haveStudentBeenOnEventWithoutStatement(Student student, Event event, Statement statement);
}
