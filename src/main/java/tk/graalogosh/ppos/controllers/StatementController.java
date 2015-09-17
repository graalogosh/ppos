package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;
import tk.graalogosh.ppos.repositories.StatementRepository;
import tk.graalogosh.ppos.repositories.StudentRepository;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.plaf.nimbus.State;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by graal on 05.08.2015.
 */
@RestController
public class StatementController {
    private StatementRepository statementRepository;
    private StudentRepository studentRepository;

    @Autowired
    public StatementController(StatementRepository statementRepository, StudentRepository studentRepository){
        this.statementRepository = statementRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping("statement")
    public List<Statement> getStatements(
            @RequestParam(value = "statementID", required = false) Integer statementID,
            @RequestParam(value = "fillingDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fillingDate,
            @RequestParam(value = "studentID", required = false) String studentID,
            @RequestParam(value = "eventID", required = false) int eventID,
            @RequestParam(value = "employeeID", required = false) int employeeID,
            @RequestParam(value = "socialGrant", required = false) boolean socialGrant,
            @RequestParam(value = "socialCategoryID", required = false) int socialCategoryID,
            @RequestParam(value = "socialWorkID", required = false) int socialWorkID,
            @RequestParam(value = "moneyCategory", required = false) double moneyCategory,
            @RequestParam(value = "cource", required = false) int cource,
            @RequestParam(value = "tripCount", required = false) int tripCount,
            @RequestParam(value = "averageScore", required = false) double averageScore,
            @RequestParam(value = "refusalCount", required = false) int refusalCount,
            @RequestParam(value = "permitNumber", required = false) int permitNumber,
            @RequestParam(value = "refusalDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate refusalDate,
            @RequestParam(value = "cancellationDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate cancellationDate,
            @RequestParam(value = "listID", required = false) int listID,
            @RequestParam(value = "comment", required = false) String comment,
            @RequestParam(value = "completeDocs", required = false) boolean completeDocs,
            @RequestParam(value = "reserve", required = false) boolean reserve){
        Statement example = new Statement();
        example.setStatementID(statementID);
        example.setFillingDate(fillingDate);
        Student student=studentRepository.findOne(studentID);
        if (student!=null) {
            example.setStudent(student);
        }
        else{
            example.setStudent(new Student());//null
        }
//        Event event =
//        example.setEvent();
        throw new NotImplementedException();
    }
}
