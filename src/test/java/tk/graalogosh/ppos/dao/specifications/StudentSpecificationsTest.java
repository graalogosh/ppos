package tk.graalogosh.ppos.dao.specifications;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.graalogosh.ppos.PposApplication;
import tk.graalogosh.ppos.dao.repositories.StudentRepository;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 25.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PposApplication.class)
public class StudentSpecificationsTest extends TestCase {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testIDIs() throws Exception {

    }

    @Test
    public void testNameIs() throws Exception {

    }

    @Test
    public void testEntryDateIs() throws Exception {

    }

    @Test
    public void testEducationalGroupIs() throws Exception {

    }

    @Test
    public void testAcademicStatusIs() throws Exception {

    }

    @Test
    public void testFinancialStatusIs() throws Exception {

    }

    @Test
    public void testFacultyIs() throws Exception {

    }

    @Test
    public void testPhoneIs() throws Exception {

    }

    @Test
    public void testBankAccountNumberIs() throws Exception {

    }

    @Test
    public void testStudentPaidIs() throws Exception {

    }

    @Test
    public void testStudentMustPayIs() throws Exception {

    }

    @Test
    public void testStudentHaveDebt() throws Exception {

    }
}