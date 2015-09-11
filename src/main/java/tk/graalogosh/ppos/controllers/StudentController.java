package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.Status;
import tk.graalogosh.ppos.models.Student;
import tk.graalogosh.ppos.repositories.StudentRepository;
import tk.graalogosh.ppos.specifications.StudentSpecification;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by graal on 05.08.2015.
 */
@RestController
public class StudentController {
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/student/{user}")
    public Student getStudent(
            @PathVariable(value = "user") String userID)
    {
        Student example = new Student();
        example.setStudentID(userID);
        StudentSpecification specification = new StudentSpecification(example);
        List<Student> students = studentRepository.findAll(specification);
        return  students.get(0);
    }

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public List<Student> getStudents(
            @RequestParam(value = "studentID", required = false)String studentID,
            @RequestParam(value = "name", required = false)String name,
            @RequestParam(value = "entryDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate entryDate,
            @RequestParam(value = "educationalGroup", required = false)String educationalGroup,
            @RequestParam(value = "academicStatus", required = false)String academicStatus,
            @RequestParam(value = "financialStatus", required = false)String financialStatus,
            @RequestParam(value = "faculty", required = false)String faculty,
            @RequestParam(value = "phone", required = false)String phone,
            @RequestParam(value = "bankAccountNumber", required = false)String bankAcountNumber,
            @RequestParam(value = "studentPaid", defaultValue = "0") String studentPaid,
            @RequestParam(value = "studentMustPay", defaultValue = "0") String studentMustPay){//TODO fix

        Student example = new Student();
        example.setStudentID(studentID);
        example.setName(name);
        example.setEntryDate(entryDate);//TODO parse entryDate to date
        example.setEducationalGroup(educationalGroup);
        example.setAcademicStatus(new Status());//TODO fix
        example.setFinancialStatus(new Status());//TODO fix
        example.setFaculty(faculty);
        example.setPhone(phone);
        example.setBankAccountNumber(bankAcountNumber);
        example.setStudentPaid(Integer.parseInt(studentPaid));
        example.setStudentMustPay(Integer.parseInt(studentMustPay));

        StudentSpecification specification = new StudentSpecification(example);
        List<Student> students = studentRepository.findAll(specification);
        return  students;
    }

    @RequestMapping(value = "students", method = RequestMethod.POST)
    public Student postStudent(
            @RequestBody Student payload){
        System.out.println(payload);
        studentRepository.saveAndFlush(payload);//try-catch
        return payload;
    }
}
