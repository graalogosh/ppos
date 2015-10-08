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
@RequestMapping(value = "statement")
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
                               StatementListRepository statementListRepository) {
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

    @RequestMapping(method = RequestMethod.GET)
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
            @RequestParam(value = "reserve", required = false) Boolean reserve) {
        Statement example = new Statement();
        example.setStatementID(statementID);
        example.setFillingDate(fillingDate);
        example.setStudent(studentID != null ? studentRepository.findOne(studentID) : null);
        example.setEvent(eventID != null ? eventRepository.findOne(eventID) : null);
        example.setEmployee(employeeID != null ? employeeRepository.findOne(employeeID) : null);
        example.setSocialGrant(socialGrant);
        example.setSocialCategory(socialCategoryID != null ? socialCategoryRepository.findOne(socialCategoryID) : null);
        example.setSocialWork(socialWorkID != null ? socialWorkRepository.findOne(socialWorkID) : null);
        example.setMoneyCategory(moneyCategory);
        example.setCourse(cource != null ? courseRepository.findOne(cource) : null);
        example.setTripCount(tripCount != null ? tripCountRepository.findOne(tripCount) : null);
        example.setAverage_score(averageScore);
        example.setRefusalCount(refusalCount != null ? refusalRepository.findOne(refusalCount) : null);
        example.setPermitNumber(permitNumber);
        example.setRefusalDate(refusalDate);
        example.setCancellationDate(cancellationDate);
        example.setList(listID != null ? statementListRepository.findOne(listID) : null);
        example.setComment(comment);
        example.setCompleteDocs(completeDocs);
        example.setReserve(reserve);

        StatementSpecification specification = new StatementSpecification(example);
        List<Statement> statements = statementRepository.findAll(specification);
        return statements;
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean postStatement(
            @RequestBody Statement payload) {
        //TODO get course from student.group
        //TODO get fillingdate from system date


        System.out.println(payload.getStatementID());
        System.out.println(payload.getFillingDate());
        System.out.println(payload.getAverage_score());//TODO change name
        return true;
    }
}
