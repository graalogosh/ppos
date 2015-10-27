package tk.graalogosh.ppos.dao.specifications;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.graalogosh.ppos.PposApplication;
import tk.graalogosh.ppos.dao.repositories.EmployeeRepository;
import tk.graalogosh.ppos.dao.repositories.FacultyRepository;
import tk.graalogosh.ppos.models.Faculty;

import java.time.LocalDate;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 27.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PposApplication.class)
public class EmployeeSpecificationsTest extends TestCase {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    FacultyRepository facultyRepository;

    @Test
    public void testIDIs() throws Exception {
        Integer id = 1;
        String name = "Администратор";
        assertEquals(name, employeeRepository.findOne(EmployeeSpecifications.IDIs(id)).getName());
    }

    @Test
    public void testNameIs() throws Exception {
        Integer id = 1;
        String name = "Администратор";
        assertEquals(id, employeeRepository.findOne(EmployeeSpecifications.nameIs(name)).getEmployeeID());
    }

    @Test
    public void testAccessLevelIs() throws Exception {
        Integer accessLevel = 1;
        int count = 6;
        assertEquals(count, employeeRepository.findAll(EmployeeSpecifications.accessLevelIs(accessLevel)).size());
    }

    @Test
    public void testRegistrationDateIs() throws Exception {
        LocalDate date = LocalDate.of(2014, 2, 20);
        Integer id = 24;
        assertEquals(id, employeeRepository.findOne(EmployeeSpecifications.registrationDateIs(date)).getEmployeeID());
    }

    @Test
    public void testLastLoginDateIs() throws Exception {
        LocalDate date = LocalDate.of(2014, 12, 15);
        Integer id = 17;
        assertEquals(id, employeeRepository.findOne(EmployeeSpecifications.lastLoginDateIs(date)).getEmployeeID());
    }

    @Test
    public void testIsDismissed() throws Exception {
        int count = 30;
        assertEquals(count, employeeRepository.findAll(EmployeeSpecifications.isDismissed(false)).size());
    }

    @Test
    public void testFacultyIs() throws Exception {
        Faculty faculty = facultyRepository.findOne("У");
        int count = 7;
        assertEquals(count, employeeRepository.findAll(EmployeeSpecifications.facultyIs(faculty)).size());
    }
}