package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.dao.repositories.*;
import tk.graalogosh.ppos.dao.specifications.StatementSpecification;
import tk.graalogosh.ppos.models.Statement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер для обработки заявлений
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 05.08.2015.
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

    /**
     * @param statementID      идентификатор заявления
     * @param fillingDate      дата заполнения заявления
     * @param studentID        идентификатор студента
     * @param eventID          идентификатор события
     * @param employeeID       идентификатор сотрудника
     * @param socialGrant      наличие социальной стипендии
     * @param socialCategoryID идентификатор социальной категории
     * @param socialWorkID     идентификатор социальной работы
     * @param moneyCategory    выплата денег
     * @param course           курс
     * @param tripCount        количество поездок
     * @param averageScore     средний балл
     * @param refusalCount     число отказов
     * @param permitNumber     номер направления
     * @param refusalDate      дата отказа
     * @param cancellationDate дата отмены
     * @param listID           номер ведомости, в которой участвует заявление
     * @param comment          комментарий
     * @param completeDocs     все ли документы поданы
     * @param reserve          находится ли заявление в резерве
     * @return List(Statement) - список заявлений, подходящий под описание
     */
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
            @RequestParam(value = "course", required = false) Integer course,
            @RequestParam(value = "tripCount", required = false) Integer tripCount,
            @RequestParam(value = "averageScore", required = false) Double averageScore,
            @RequestParam(value = "refusalCount", required = false) Integer refusalCount,
            @RequestParam(value = "permitNumber", required = false) Integer permitNumber,
            @RequestParam(value = "refusalDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate refusalDate,
            @RequestParam(value = "cancellationDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate cancellationDate,
            @RequestParam(value = "listID", required = false) Integer listID,
            @RequestParam(value = "comment", required = false) String comment,
            @RequestParam(value = "completeDocs", required = false) Boolean completeDocs,
            @RequestParam(value = "reserve", required = false) Boolean reserve,
            @RequestParam(value = "showSuccesses", required = false) Boolean showSuccesses) {

        showSuccesses = showSuccesses != null ? showSuccesses : false;

        List<Specification<Statement>> specifications = new ArrayList<>();
        if (statementID != null) {
            specifications.add(StatementSpecification.IDIs(statementID));
        }

        if (fillingDate != null) {
            specifications.add(StatementSpecification.fillingDateIs(fillingDate));
        }

        if (studentID != null) {
            specifications.add(StatementSpecification.studentIs(studentRepository.findOne(studentID)));
        }

        if (eventID != null) {
            specifications.add(StatementSpecification.eventIs(eventRepository.findOne(eventID)));
        }

        if (employeeID != null) {
            specifications.add(StatementSpecification.employeeIs(employeeRepository.findOne(employeeID)));
        }

        //TODO socialGrant fix
        if (socialCategoryID != null) {
            specifications.add(StatementSpecification.socialCategoryIs(socialCategoryRepository.findOne(socialCategoryID)));
        }

        if (socialWorkID != null) {
            specifications.add(StatementSpecification.socialWorkIs(socialWorkRepository.findOne(socialWorkID)));
        }

        if (moneyCategory != null) {
            specifications.add(StatementSpecification.moneyCategoryIs(moneyCategory));
        }

        if (course != null) {
            specifications.add(StatementSpecification.courseIs(courseRepository.findOne(course)));
        }

        if (tripCount != null) {
            specifications.add(StatementSpecification.tripCountIs(tripCountRepository.findOne(tripCount)));
        }

        if (averageScore != null) {
            //TODO averageScore
        }

        if (refusalCount != null) {
            specifications.add(StatementSpecification.refusalCountIs(refusalRepository.findOne(refusalCount)));
        }

        if (permitNumber != null) {
            specifications.add(StatementSpecification.permitNumberIs(permitNumber));
        }

        if (refusalDate != null) {
            specifications.add(StatementSpecification.refusalDateIs(refusalDate));
        }

        if (cancellationDate != null) {
            specifications.add(StatementSpecification.cancellationDateIs(cancellationDate));
        }

        if (listID != null) {
            specifications.add(StatementSpecification.statementListIs(statementListRepository.findOne(listID)));
        }

        if (comment != null) {
            specifications.add(StatementSpecification.commentIs(comment));
        }

        if (completeDocs != null) {
            specifications.add(StatementSpecification.completeDoscIs(completeDocs));
        }

        if (reserve != null) {
            specifications.add(StatementSpecification.reserveIs(reserve));
        }

        Specification<Statement> finalSpecification = null;
        for (Specification<Statement> spec : specifications) {
            finalSpecification = Specifications.where(finalSpecification).and(spec);
        }
        return statementRepository.findAll(finalSpecification);
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
