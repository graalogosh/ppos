package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.*;
import tk.graalogosh.ppos.repositories.*;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tk.graalogosh.ppos.specifications.StatementSpecification;

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
    private CourseRepository courseRepository;
    private EventRepository eventRepository;
    private EmployeeRepository employeeRepository;
    private SocialCategoryRepository socialCategoryRepository;
    private SocialWorkRepository socialWorkRepository;
    private TripCountRepository tripCountRepository;
    private RefusalRepository refusalRepository;
    private StatementListRepository statementListRepository;

    @Autowired
    public StatementController(StatementRepository statementRepository,
                               StudentRepository studentRepository,
                               CourseRepository courseRepository,
                               EventRepository eventRepository,
                               EmployeeRepository employeeRepository,
                               SocialCategoryRepository socialCategoryRepository,
                               SocialWorkRepository socialWorkRepository,
                               TripCountRepository tripCountRepository,
                               RefusalRepository refusalRepository,
                               StatementListRepository statementListRepository){
        this.statementRepository = statementRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.eventRepository = eventRepository;
        this.employeeRepository = employeeRepository;
        this.socialCategoryRepository = socialCategoryRepository;
        this.socialWorkRepository = socialWorkRepository;
        this.tripCountRepository = tripCountRepository;
        this.refusalRepository = refusalRepository;
        this.statementListRepository = statementListRepository;
    }

    @RequestMapping("statement")
    public List<Statement> getStatements(
            @RequestParam(value = "statementID", required = false) Integer statementID,
            @RequestParam(value = "fillingDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fillingDate,
            @RequestParam(value = "studentID", required = false) String studentID,
            @RequestParam(value = "eventID", required = false) Integer eventID,
            @RequestParam(value = "employeeID", required = false) Integer employeeID,
            @RequestParam(value = "socialGrant", required = false) Boolean socialGrant,
            @RequestParam(value = "socialCategoryID", required = false) Integer socialCategoryID,
            @RequestParam(value = "socialWorkID", required = false) Integer socialWorkID,
            @RequestParam(value = "moneyCategory", required = false) Double moneyCategory,
            @RequestParam(value = "cource", required = false) Integer cource,
            @RequestParam(value = "tripCount", required = false) Integer tripCount,
            @RequestParam(value = "averageScore", required = false) Double averageScore,
            @RequestParam(value = "refusalCount", required = false) Integer refusalCount,
            @RequestParam(value = "permitNumber", required = false) Integer permitNumber,
            @RequestParam(value = "refusalDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate refusalDate,
            @RequestParam(value = "cancellationDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate cancellationDate,
            @RequestParam(value = "listID", required = false) Integer listID,
            @RequestParam(value = "comment", required = false) String comment,
            @RequestParam(value = "completeDocs", required = false) Boolean completeDocs,
            @RequestParam(value = "reserve", required = false) Boolean reserve){
        Statement example = new Statement();
        example.setStatementID(statementID);
        example.setFillingDate(fillingDate);
        example.setStudent(studentRepository.findOne(studentID));
        example.setEvent(eventRepository.findOne(eventID));
        example.setEmployee(employeeRepository.findOne(employeeID));
        example.setSocialGrant(socialGrant);
        example.setSocialCategory(socialCategoryRepository.findOne(socialCategoryID));
        example.setSocialWork(socialWorkRepository.findOne(socialWorkID));
        example.setMoneyCategory(moneyCategory);
        example.setCourse(courseRepository.findOne(cource));
        example.setTripCount(tripCountRepository.findOne(tripCount));
        example.setAverage_score(averageScore);
        example.setRefusalCount(refusalRepository.findOne(refusalCount));
        example.setPermitNumber(permitNumber);
        example.setRefusalDate(refusalDate);
        example.setCancellationDate(cancellationDate);
        example.setList(statementListRepository.findOne(listID));
        example.setComment(comment);
        example.setCompleteDocs(completeDocs);
        example.setReserve(reserve);

        StatementSpecification specification = new StatementSpecification(example);
        List<Statement> statements = statementRepository.findAll(specification);
        return statements;
    }

    @RequestMapping(value = "statement", method = RequestMethod.POST)
    public boolean postStatement(
         @RequestBody Statement payload){
        //TODO get course from student.group
        //TODO get fillingdate from system date



        System.out.println(payload.getStatementID());
        System.out.println(payload.getFillingDate());
        System.out.println(payload.getAverage_score());//TODO change name
        return true;
    }
}
