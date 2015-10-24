package tk.graalogosh.ppos.dao.repositories;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.graalogosh.ppos.PposApplication;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 24.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PposApplication.class)
public class StatementRepositoryImplTest extends TestCase {

    @Autowired
    StatementRepository statementRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SectionRepository sectionRepository;

//    @Test
//    public void testStatementIsValid() throws Exception {
//
//    }

    @Test
    public void testGetStudentTripCount() throws Exception {
        assertEquals(new Integer(4), statementRepository.getStudentTripCount(studentRepository.findOne("120930"), sectionRepository.findOne(2)));
    }

//    @Test
//    public void testGetStudentRefusalCount() throws Exception {
//
//    }
}