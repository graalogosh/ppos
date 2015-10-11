package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.Status;
import tk.graalogosh.ppos.models.Student;
import tk.graalogosh.ppos.repositories.StatusRepository;
import tk.graalogosh.ppos.repositories.StudentRepository;
import tk.graalogosh.ppos.specifications.StudentSpecification;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 05.08.2015.
 */
@RestController
@RequestMapping(value = "student")
public class StudentController {
    private StudentRepository studentRepository;
    private StatusRepository statusRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository,
                             StatusRepository statusRepository) {
        this.studentRepository = studentRepository;
        this.statusRepository = statusRepository;
    }

//    @RequestMapping("/student/{user}")
//    public Student getStudent(
//            @PathVariable(value = "user") String userID) {
//        Student example = new Student();
//        example.setStudentID(userID);
//        StudentSpecification specification = new StudentSpecification(example);
//        List<Student> students = studentRepository.findAll(specification);
//        return students.get(0);
//    }

    /**
     *
     * @param studentID идентификатор студента
     * @param name ФИО студента
     * @param entryDate дата зачисления
     * @param educationalGroup учебная группа
     * @param academicStatus академический статус
     * @param financialStatus финансовый статус
     * @param faculty факультет
     * @param phone телефон
     * @param bankAcountNumber номер банковского счета
     * @param studentPaid студент оплатил взносов
     * @param studentMustPay студент должен оплатить взносов
     * @return List(Student) - список студентов, подходящих под описание
     */

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents(
            @RequestParam(value = "studentID", required = false) String studentID,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "entryDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate entryDate,
            @RequestParam(value = "educationalGroup", required = false) String educationalGroup,
            //TODO change to *statusID
            @RequestParam(value = "academicStatus", required = false) Integer academicStatus,
            @RequestParam(value = "financialStatus", required = false) Integer financialStatus,
            @RequestParam(value = "faculty", required = false) String faculty,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "bankAccountNumber", required = false) String bankAcountNumber,
            @RequestParam(value = "studentPaid", required = false) Integer studentPaid,
            @RequestParam(value = "studentMustPay", required = false) Integer studentMustPay) {

        Student example = new Student();
        example.setStudentID(studentID);
        example.setName(name);
        example.setEntryDate(entryDate);
        example.setEducationalGroup(educationalGroup);
        example.setAcademicStatus(academicStatus != null ? statusRepository.findOne(academicStatus) : null);
        example.setFinancialStatus(financialStatus != null ? statusRepository.findOne(financialStatus) : null);
        example.setFaculty(faculty);
        example.setPhone(phone);
        example.setBankAccountNumber(bankAcountNumber);
        example.setStudentPaid(studentPaid);
        example.setStudentMustPay(studentMustPay);

        StudentSpecification specification = new StudentSpecification(example);
        List<Student> students = studentRepository.findAll(specification);
        return students;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student postStudent(
            @RequestBody Student payload) {
        System.out.println(payload);
        studentRepository.saveAndFlush(payload);//try-catch
        return payload;
    }
}
