package tk.graalogosh.ppos.dao.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import tk.graalogosh.ppos.dao.specifications.StatementSpecification;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;

import java.util.List;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 15.10.2015.
 */
public class EventRepositoryImpl implements EventRepositoryCustom {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private StatementRepository statementRepository;

    @Override
    public Boolean haveStudentBeenOnEventOrAncestorEvent(Student student, Event event) {
        if (event.getAncestor() == null || studentHaveBeenOnEvent(student, event)) {
            return studentHaveBeenOnEvent(student, event);
        } else {
            return haveStudentBeenOnEventOrAncestorEvent(student, event.getAncestor());
        }
    }

    private Boolean studentHaveBeenOnEvent(Student student, Event event) {
        List<Statement> statements = statementRepository.findAll(StatementSpecification.findByStudentAndEvent(student, event));
        if (statements.size() == 0) {
            return false;
        } else {
            Statement statement = statements.get(0);
            return statement != null && //человек подавал заявку
                    statement.getPermitNumber() != null && //человек прошел по конкурсу
                    statement.getCancellationDate() == null && //не отменил
                    statement.getRefusalDate() == null; //не отказался
        }
    }

}
