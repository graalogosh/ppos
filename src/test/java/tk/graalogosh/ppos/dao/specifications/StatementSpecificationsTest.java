package tk.graalogosh.ppos.dao.specifications;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.graalogosh.ppos.PposApplication;
import tk.graalogosh.ppos.dao.repositories.*;
import tk.graalogosh.ppos.models.*;

import java.time.LocalDate;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 24.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PposApplication.class)
public class StatementSpecificationsTest extends TestCase {
    @Autowired
    private StatementRepository statementRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SocialCategoryRepository socialCategoryRepository;
    @Autowired
    private SocialWorkRepository socialWorkRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private RefusalRepository refusalRepository;
    @Autowired
    private TripCountRepository tripCountRepository;
    @Autowired
    private StatementListRepository statementListRepository;

    @Test
    public void testIDIs() throws Exception {
        Integer ID = 1;
        Statement statement = statementRepository.findOne(StatementSpecifications.IDIs(ID));
        assertEquals(ID, statement.getStatementID());
    }

    @Test
    public void testFillingDateIs() throws Exception {
        LocalDate date = LocalDate.of(2013, 11, 25);
        int count = 6;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.fillingDateIs(date)).size());
    }

    @Test
    public void testStudentIs() throws Exception {
        Student student = studentRepository.findOne("120902");
        //TODO check why int, not Integer
        int count = 2;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.studentIs(student)).size());
    }

    @Test
    public void testEventIs() throws Exception {
        Event event = eventRepository.findOne(42);
        int count = 36;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.eventIs(event)).size());
    }

    @Test
    public void testEmployeeIs() throws Exception {
        Employee employee = employeeRepository.findOne(11);
        int count = 891;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.employeeIs(employee)).size());
    }

    @Test
    public void testSocialCategoryIs() throws Exception {
        SocialCategory socialCategory = socialCategoryRepository.findOne(10);
        int count = 1224;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.socialCategoryIs(socialCategory)).size());
    }

    @Test
    public void testSocialWorkIs() throws Exception {
        SocialWork socialWork = socialWorkRepository.findOne(5);
        int count = 336;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.socialWorkIs(socialWork)).size());
    }

    @Test
    public void testMoneyCategoryIs() throws Exception {
        Double money = 10000.0;
        int count = 812;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.moneyCategoryIs(money)).size());
    }

    @Test
    public void testCourseIs() throws Exception {
        Course course = courseRepository.findOne(5);
        int count = 229;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.courseIs(course)).size());
    }

    @Test
    public void testTripCountIs() throws Exception {
        TripCount tripCount = tripCountRepository.findOne(7);
        int count = 13;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.tripCountIs(tripCount)).size());
    }

    @Test
    public void testRefusalCountIs() throws Exception {
        Refusal refusal = refusalRepository.findOne(2);
        int count = 10;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.refusalCountIs(refusal)).size());
    }

    @Test
    public void testPermitNumberIs() throws Exception {
        Integer permitNumber = 1;
        int count = 1006;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.permitNumberIs(permitNumber)).size());
    }

    @Test
    public void testRefusalDateIs() throws Exception {
        LocalDate date = LocalDate.of(2014, 1, 28);
        int count = 8;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.refusalDateIs(date)).size());
    }

    @Test
    public void testCancellationDateIs() throws Exception {
        LocalDate date = LocalDate.of(2014, 1, 28);
        int count = 3;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.cancellationDateIs(date)).size());
    }

    @Test
    public void testStatementListIs() throws Exception {
        StatementList statementList = statementListRepository.findOne(257);
        int count = 15;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.statementListIs(statementList)).size());
    }

    @Test
    public void testCommentIs() throws Exception {
        String comment = "во время первого обзвона";
        int count = 49;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.commentIs(comment)).size());
    }

    @Test
    public void testCompleteDocsIs() throws Exception {
        Boolean completeDocs = true;
        int count = 7549;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.completeDocsIs(completeDocs)).size());
    }

    @Test
    public void testReserveIs() throws Exception {
        Boolean reserve = true;
        int count = 11;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.reserveIs(reserve)).size());
    }

    @Test
    public void testPermitNumberIsNotNull() throws Exception {
        int count = 7759;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.permitNumberIsNotNull()).size());
    }

    @Test
    public void testFindByStudentAndEvent() throws Exception {
        Student student = studentRepository.findOne("120902");
        Event event = eventRepository.findOne(24);
        assertNotNull(statementRepository.findOne(StatementSpecifications.findByStudentAndEvent(student, event)));
    }

    @Test
    @Ignore("check when winter will come")
    //Oo
    public void testInTermOfDate() throws Exception {

    }

    @Test
    @Ignore("check when new DB will arrive")
    public void testInCurrentTerm() throws Exception {

    }

    @Test
    public void testIsActive() throws Exception {
        int count = 7335;
        assertEquals(count, statementRepository.findAll(StatementSpecifications.isActive()).size());
    }
}