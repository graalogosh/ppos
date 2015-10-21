package tk.graalogosh.ppos.repositories;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import tk.graalogosh.ppos.PposApplication;
import tk.graalogosh.ppos.models.Statement;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

    @Test
    public void testFindByStudentIDAndEventID() throws Exception {

//        List<Statement> statements = statementRepository.findByStudentAndEvent(studentRepository.findOne("120902"), eventRepository.findOne(24));
//
//        statements.forEach(s-> System.out.println(s.getStatementID()));
    }
}