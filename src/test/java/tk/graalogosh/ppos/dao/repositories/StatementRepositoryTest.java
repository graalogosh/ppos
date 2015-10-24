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

    @Test
    public void testFindByStudentIDAndEventID() throws Exception {

//        List<Statement> statements = statementRepository.findByStudentAndEvent(studentRepository.findOne("120902"), eventRepository.findOne(24));
//
//        statements.forEach(s-> System.out.println(s.getStatementID()));
    }
}