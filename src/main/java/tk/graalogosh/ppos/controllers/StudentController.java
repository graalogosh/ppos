package tk.graalogosh.ppos.controllers;

import tk.graalogosh.ppos.models.Student;
import tk.graalogosh.ppos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("student")
    public Student getStudent(@RequestParam("studentID") String studentID){
        Student student = studentRepository.findOne(studentID);
        System.out.println(student);
        return student;
    }
}
