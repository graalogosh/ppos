package tk.graalogosh.ppos.repositories;

import junit.framework.TestCase;
import org.apache.tomcat.jni.Local;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.graalogosh.ppos.PposApplication;

import java.time.LocalDate;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 21.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PposApplication.class)
public class EventRepositoryTest extends TestCase {
    @Autowired
    EventRepository eventRepository;

    @Test
    public void testFindByEventDateBetween() throws Exception {
        assertEquals(eventRepository.findByEventDateBetween(LocalDate.of(2014, 3, 15), LocalDate.of(2014, 3, 30)).size(), 4);
    }

    @Test
    public void testFindByReseptionBeginBeforeAndReseptionFinishAfter() throws Exception {
        assertEquals(eventRepository.findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate.now()).size(), 5);
    }
}