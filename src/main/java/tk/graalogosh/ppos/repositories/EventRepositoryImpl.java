package tk.graalogosh.ppos.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<Event> findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate date) {
        LocalDate now = LocalDate.now();
        List<Event> list1 = eventRepository.findByReseptionBeginBefore(now);
        List<Event> list2 = eventRepository.findByReseptionFinishAfter(now);

        List<Event> resultList = new ArrayList<>();

        for (Event event : list1) {
            if (list2.contains(event)) {
                resultList.add(event);
            }
        }

        return resultList;
    }

    @Override
    public Boolean haveStudentBeenOnEventOrAncestorEvent(Student student, Event event) {
        if (event.getAncestor() == null || studentHaveBeenOnEvent(student, event)) {
            return studentHaveBeenOnEvent(student, event);
        } else {
            return haveStudentBeenOnEventOrAncestorEvent(student, event.getAncestor());
        }
    }

    private Boolean studentHaveBeenOnEvent(Student student, Event event) {
        Statement statement = statementRepository.findByStudentAndEvent(student, event);
        return statement != null && //человек подавал заявку
                statement.getPermitNumber() != null && //человек прошел по конкурсу
                statement.getCancellationDate() == null && //не отменил
                statement.getRefusalDate() == null; //не отказался
    }

}
