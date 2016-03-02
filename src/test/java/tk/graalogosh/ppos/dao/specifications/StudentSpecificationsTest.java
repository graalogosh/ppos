package tk.graalogosh.ppos.dao.specifications;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.graalogosh.ppos.PposApplication;
import tk.graalogosh.ppos.dao.repositories.FacultyRepository;
import tk.graalogosh.ppos.dao.repositories.StatusRepository;
import tk.graalogosh.ppos.dao.repositories.StudentRepository;
import tk.graalogosh.ppos.models.Faculty;
import tk.graalogosh.ppos.models.Status;
import tk.graalogosh.ppos.models.Student;

import java.time.LocalDate;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 25.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PposApplication.class)
public class StudentSpecificationsTest extends TestCase {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    FacultyRepository facultyRepository;

    @Test
    public void testIDIs_digits() throws Exception {
        String ID = "120902";
        String name = "Муковозов Антон Михайлович";
        assertEquals(name, studentRepository.findOne(StudentSpecifications.IDIs(ID)).getName());
    }

    @Test
    public void testIDIs_alphabet() throws Exception {
        String ID = "и-128114";
        String name = "Ху Фэйэр";
        assertEquals(name, studentRepository.findOne(StudentSpecifications.IDIs(ID)).getName());
    }

    @Test
    public void testNameIs() throws Exception {
        String ID = "120902";
        String name = "Муковозов Антон Михайлович";
        assertEquals(ID, studentRepository.findOne(StudentSpecifications.nameIs(name)).getStudentID());
    }

    @Test
    public void testEntryDateIs() throws Exception {
        LocalDate date = LocalDate.of(2012, 9, 1);
        for (Student student : studentRepository.findAll(StudentSpecifications.entryDateIs(date))) {
            assertNotSame(date, student.getEntryDate());
        }
    }

    @Test
    public void testEducationalGroupIs() throws Exception {
        String educationalGroup = "3бАСУ2";
        for (Student student : studentRepository.findAll(StudentSpecifications.educationalGroupIs(educationalGroup))) {
            assertNotSame(educationalGroup, student.getEducationalGroup());
        }
    }

    @Test
    public void testAcademicStatusIs() throws Exception {
        Status academicStatus = statusRepository.findOne(2);
        for (Student student : studentRepository.findAll(StudentSpecifications.academicStatusIs(academicStatus))) {
            assertNotSame(academicStatus, student.getAcademicStatus());
        }
    }

    @Test
    public void testFinancialStatusIs() throws Exception {
        Status financialStatus = statusRepository.findOne(8);
        for (Student student : studentRepository.findAll(StudentSpecifications.financialStatusIs(financialStatus))) {
            assertNotSame(financialStatus, student.getFinancialStatus());
        }
    }

    @Test
    public void testFacultyIs() throws Exception {
        Faculty faculty = facultyRepository.findOne("У");
        for (Student student : studentRepository.findAll(StudentSpecifications.facultyIs(faculty))){
            assertNotSame(faculty,student.getFaculty());
        }
    }

    @Test
    public void testPhoneIs() throws Exception {
        String phone = "8(903) 770-6292";
        String ID = "120902";
        assertEquals(ID, studentRepository.findOne(StudentSpecifications.phoneIs(phone)).getStudentID());
    }

    @Test
    public void testBankAccountNumberIs() throws Exception {
        String bankAccountNumber = "40817810400040015501";
        String ID = "120930";
        assertEquals(ID, studentRepository.findOne(StudentSpecifications.bankAccountNumberIs(bankAccountNumber)).getStudentID());
    }

    @Test
    @Ignore
    public void testStudentPaidIs() throws Exception {

    }

    @Test
    @Ignore
    public void testStudentMustPayIs() throws Exception {

    }

    @Test
    @Ignore
    public void testStudentHaveDebt() throws Exception {

    }
}