package tk.graalogosh.ppos.dao.repositories;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.graalogosh.ppos.PposApplication;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.dao.specifications.EventSpecifications;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 21.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PposApplication.class)
public class EventRepositoryTest extends TestCase {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testFindByEventDateBetween_Specification() throws Exception {
        LocalDate start = LocalDate.of(2014, 3, 15);
        LocalDate finish = LocalDate.of(2014, 3, 30);
//        assertEquals(4, eventRepository.findAll(EventSpecifications.findBetweenDates(start, finish)).size());
        for (Event event : eventRepository.findAll(EventSpecifications.findBetweenDates(start, finish))){
            LocalDate curDate = event.getEventDate();
            assertTrue((curDate.isAfter(start)||curDate.isEqual(start)) &&
                       (curDate.isBefore(finish)||curDate.isEqual(finish)));
        }
    }

    @Test
    @Ignore
    public void testFindByReseptionBeginBeforeAndReseptionFinishAfter_specification() {
//        System.out.println("*************************");
//        for (Event event : (List<Event>) eventRepository.findAll(EventSpecifications.findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate.now()))) {
//            System.out.println(event.getEventID());
//        }
//        System.out.println("*************************");
        assertEquals(6, eventRepository.findAll(EventSpecifications.findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate.now())).size());
    }

    @Test
    public void testHaveStudentBeenOnAncestorEvent_False_DidntGaveDocs() throws Exception {
        assertFalse(eventRepository.haveStudentBeenOnAncestorEvent(
                        studentRepository.findOne("120902"),
                        eventRepository.findOne(28))
        );
    }

    @Test
    public void testHaveStudentBeenOnAncestorEvent_True() throws Exception {
        assertTrue(eventRepository.haveStudentBeenOnAncestorEvent(
                        studentRepository.findOne("120930"),
                        eventRepository.findOne(28))
        );
    }

    @Test
    public void testHaveStudentBeenOnAncestorEvent_False_DidntGaveDocsOnAncestor() throws Exception{
        assertFalse(eventRepository.haveStudentBeenOnAncestorEvent(
                        studentRepository.findOne("120930"),
                        eventRepository.findOne(7))
        );
    }

    @Test
    public void testStudentMadeStatementOnEvent() throws Exception{
        assertTrue(eventRepository.studentMadeStatementOnEvent(
                studentRepository.findOne("120930"),
                eventRepository.findOne(29)));
    }
}