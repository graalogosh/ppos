package tk.graalogosh.ppos.dao;

import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tk.graalogosh.ppos.models.Status;
import tk.graalogosh.ppos.models.Student;
import tk.graalogosh.ppos.repositories.StudentRepository;
import tk.graalogosh.ppos.specifications.StudentSpecification;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by graal on 12.08.2015.
 */
public class StudentDAOImpl implements StudentDAO {
    private StudentRepository studentRepository;

    public StudentDAOImpl(){

    }

    @Autowired
    public StudentDAOImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents(String studentID, String name, LocalDate entryDate, String educationalGroup, String academicStatus, String financialStatus, String faculty, String phone, String bankAccountNumber, int studentPaid, int studentMustPay) {
        Student example = new Student();
        example.setStudentID(studentID);
        example.setName(name);
        example.setEntryDate(entryDate);//TODO parse entryDate to date
        example.setEducationalGroup(educationalGroup);
        example.setAcademicStatus(new Status());//TODO fix
        example.setFinancialStatus(new Status());//TODO fix
        example.setFaculty(faculty);
        example.setPhone(phone);
        example.setBankAccountNumber(bankAccountNumber);
        example.setStudentPaid(studentPaid);
        example.setStudentMustPay(studentMustPay);

        StudentSpecification specification = new StudentSpecification(example);
        List<Student> students = studentRepository.findAll(specification);
        return  students;
    }

    @Override
    public Student addStudent(String studentID, String name, LocalDate entryDate, String educationalGroup, String academicStatus, String financialStatus, String faculty, String phone, String bankAccountNumber, int studentPaid, int studentMustPay) {
        throw new NotImplementedException();
    }

    @Override
    public Student updateStudent(String studentID, String name, LocalDate entryDate, String educationalGroup, String academicStatus, String financialStatus, String faculty, String phone, String bankAccountNumber, int studentPaid, int studentMustPay) {
        throw new NotImplementedException();
    }

    @Override
    public boolean deleteStudent(String studentID) {
        throw new NotImplementedException();
    }
}
