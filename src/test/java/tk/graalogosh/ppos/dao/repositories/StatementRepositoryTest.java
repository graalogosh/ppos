package tk.graalogosh.ppos.dao.repositories;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import tk.graalogosh.ppos.PposApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 20.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PposApplication.class)
public class StatementRepositoryTest extends TestCase {
    @Autowired
    private StatementRepository statementRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private SectionRepository sectionRepository;

    @Test
    public void testFindByStudentIDAndEventID() throws Exception {

//        List<Statement> statements = statementRepository.findByStudentAndEvent(studentRepository.findOne("120902"), eventRepository.findOne(24));
//
//        statements.forEach(s-> System.out.println(s.getStatementID()));
    }
    //    @Test
//    public void testStatementIsValid() throws Exception {
//
//    }

    @Test
    public void testGetStudentTripCount() throws Exception {
        assertEquals(new Integer(4), statementRepository.getStudentTripCount(studentRepository.findOne("120930"), sectionRepository.findOne(2)));
    }

    @Test
    public void testGetStudentRefusalCount_Have1Refusal() throws Exception {
        assertEquals(new Integer(1), statementRepository.getStudentRefusalCount(studentRepository.findOne("102124"), sectionRepository.findOne(2)));
    }

    @Test
    public void testGetStudentRefusalCount_Have0Refusal() throws Exception{
        assertEquals(new Integer(0), statementRepository.getStudentRefusalCount(studentRepository.findOne("120902"), sectionRepository.findOne(2)));
    }
}