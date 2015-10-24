package tk.graalogosh.ppos.dao.repositories;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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

    @Test
    public void testFindByEventDateBetween_Specification() throws Exception {
        System.out.println("*************************");
        for(Event event : (List<Event>)eventRepository.findAll(EventSpecifications.findBetweenDates(LocalDate.of(2014, 3, 15), LocalDate.of(2014, 3, 30)))){
            System.out.println(event.getEventID());
        }
        System.out.println("*************************");
        assertEquals(4,eventRepository.findAll(EventSpecifications.findBetweenDates(LocalDate.of(2014, 3, 15), LocalDate.of(2014, 3, 30))).size());
    }

    @Test
    public void testFindByReseptionBeginBeforeAndReseptionFinishAfter_specification(){
        System.out.println("*************************");
        for(Event event : (List<Event>)eventRepository.findAll(EventSpecifications.findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate.now()))){
            System.out.println(event.getEventID());
        }
        System.out.println("*************************");
        assertEquals(5, eventRepository.findAll(EventSpecifications.findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate.now())).size());
    }
}