package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.dao.repositories.FacultyRepository;
import tk.graalogosh.ppos.dao.repositories.StatusRepository;
import tk.graalogosh.ppos.dao.repositories.StudentRepository;
import tk.graalogosh.ppos.dao.specifications.StudentSpecifications;
import tk.graalogosh.ppos.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 05.08.2015.
 */
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private FacultyRepository facultyRepository;

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
     * @param studentID         идентификатор студента
     * @param name              ФИО студента
     * @param entryDate         дата зачисления
     * @param educationalGroup  учебная группа
     * @param academicStatusID  идентификатор академического статус
     * @param financialStatusID идентификатор финансового статуса
     * @param faculty           факультет
     * @param phone             телефон
     * @param bankAcountNumber  номер банковского счета
     * @param studentPaid       студент оплатил взносов
     * @param studentMustPay    студент должен оплатить взносов
     * @return List(Student) - список студентов, подходящих под описание
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents(
            @RequestParam(value = "studentID", required = false) String studentID,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "entryDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate entryDate,
            @RequestParam(value = "educationalGroup", required = false) String educationalGroup,
            @RequestParam(value = "academicStatusID", required = false) Integer academicStatusID,
            @RequestParam(value = "financialStatusID", required = false) Integer financialStatusID,
            @RequestParam(value = "faculty", required = false) String faculty,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "bankAccountNumber", required = false) String bankAcountNumber,
            @RequestParam(value = "studentPaid", required = false) Integer studentPaid,
            @RequestParam(value = "studentMustPay", required = false) Integer studentMustPay) {

        List<Specification<Student>> specifications = new ArrayList<>();
        if (studentID != null) {
            specifications.add(StudentSpecifications.IDIs(studentID));
        }

        if (name != null) {
            specifications.add(StudentSpecifications.nameIs(name));
        }

        if (entryDate != null) {
            specifications.add(StudentSpecifications.entryDateIs(entryDate));
        }

        if (educationalGroup != null) {
            specifications.add(StudentSpecifications.educationalGroupIs(educationalGroup));
        }

        if (academicStatusID != null) {
            specifications.add(StudentSpecifications.academicStatusIs(statusRepository.findOne(academicStatusID)));
        }

        if (financialStatusID != null) {
            specifications.add(StudentSpecifications.financialStatusIs(statusRepository.findOne(financialStatusID)));
        }

        if (faculty != null) {
            specifications.add(StudentSpecifications.facultyIs(facultyRepository.findOne(faculty)));
        }

        if (phone != null) {
            specifications.add(StudentSpecifications.phoneIs(phone));
        }

        if (bankAcountNumber != null) {
            specifications.add(StudentSpecifications.bankAccountNumberIs(bankAcountNumber));
        }

        if (studentPaid != null) {
            specifications.add(StudentSpecifications.studentPaidIs(studentPaid));
        }

        if (studentMustPay != null) {
            specifications.add(StudentSpecifications.studentMustPayIs(studentMustPay));
        }

        Specification<Student> finalSpecification = null;
        for (Specification<Student> spec : specifications) {
            finalSpecification = Specifications.where(finalSpecification).and(spec);
        }
        return studentRepository.findAll(finalSpecification);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Student postStudent(
            @RequestBody Student payload) {
        System.out.println(payload);
        studentRepository.saveAndFlush(payload);//try-catch
        return payload;
    }

    @RequestMapping(value = "/changeBankAccountNumber", method = RequestMethod.POST)
    public Boolean changeBankAccountNumber(
            @RequestParam(value = "studentID", required = true) Student student,
            @RequestParam(value = "bankAccountNumber", required = true) String bankAccountNumber) {
        student.setBankAccountNumber(bankAccountNumber);
        studentRepository.save(student);
        return true;
    }
}
