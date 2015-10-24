package tk.graalogosh.ppos.dao.repositories;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.graalogosh.ppos.PposApplication;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 21.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PposApplication.class)
public class EventRepositoryImplTest extends TestCase {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testHaveStudentBeenOnAncestorEvent_False() throws Exception {
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
}