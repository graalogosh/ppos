package tk.graalogosh.ppos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.dao.repositories.*;
import tk.graalogosh.ppos.dao.specifications.StatementSpecifications;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;
import tk.graalogosh.ppos.models.constuctors.StatementConstructor;
import tk.graalogosh.ppos.utils.JsonBoolean;

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
    private SectionRepository sectionRepository;

    private static final Logger LOG = LoggerFactory.getLogger(StatementController.class);

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
                               StatementListRepository statementListRepository,
                               SectionRepository sectionRepository) {
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
        this.sectionRepository = sectionRepository;
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
            //@RequestParam(value = "showSuccesses", required = false) Boolean showSuccesses,
            @RequestParam(value = "curTerm", required = false) Boolean curTerm,
            @RequestParam(value = "activeStatements", required = false) Boolean activeStatements) {

        //showSuccesses = showSuccesses != null ? showSuccesses : false;
        curTerm = curTerm != null ? curTerm : true;
        activeStatements = activeStatements != null ? activeStatements : true;


        List<Specification<Statement>> specifications = new ArrayList<>();
        if (statementID != null) {
            specifications.add(StatementSpecifications.IDIs(statementID));
        }

        if (fillingDate != null) {
            specifications.add(StatementSpecifications.fillingDateIs(fillingDate));
        }

        if (studentID != null) {
            specifications.add(StatementSpecifications.studentIs(studentRepository.findOne(studentID)));
        }

        if (eventID != null) {
            specifications.add(StatementSpecifications.eventIs(eventRepository.findOne(eventID)));
        }

        if (employeeID != null) {
            specifications.add(StatementSpecifications.employeeIs(employeeRepository.findOne(employeeID)));
        }

        //TODO socialGrant fix
        if (socialCategoryID != null) {
            specifications.add(StatementSpecifications.socialCategoryIs(socialCategoryRepository.findOne(socialCategoryID)));
        }

        if (socialWorkID != null) {
            specifications.add(StatementSpecifications.socialWorkIs(socialWorkRepository.findOne(socialWorkID)));
        }

        if (moneyCategory != null) {
            specifications.add(StatementSpecifications.moneyCategoryIs(moneyCategory));
        }

        if (course != null) {
            specifications.add(StatementSpecifications.courseIs(courseRepository.findOne(course)));
        }

        if (tripCount != null) {
            specifications.add(StatementSpecifications.tripCountIs(tripCountRepository.findOne(tripCount)));
        }

        if (averageScore != null) {
            //TODO averageScore
        }

        if (refusalCount != null) {
            specifications.add(StatementSpecifications.refusalCountIs(refusalRepository.findOne(refusalCount)));
        }

        if (permitNumber != null) {
            specifications.add(StatementSpecifications.permitNumberIs(permitNumber));
        }

        if (refusalDate != null) {
            specifications.add(StatementSpecifications.refusalDateIs(refusalDate));
        }

        if (cancellationDate != null) {
            specifications.add(StatementSpecifications.cancellationDateIs(cancellationDate));
        }

        if (listID != null) {
            specifications.add(StatementSpecifications.statementListIs(statementListRepository.findOne(listID)));
        }

        if (comment != null) {
            specifications.add(StatementSpecifications.commentIs(comment));
        }

        if (completeDocs != null) {
            specifications.add(StatementSpecifications.completeDocsIs(completeDocs));
        }

        if (reserve != null) {
            specifications.add(StatementSpecifications.reserveIs(reserve));
        }

        if (curTerm) {
            specifications.add(StatementSpecifications.inCurrentTerm());
        }

        if (activeStatements) {
            specifications.add(StatementSpecifications.isActive());
        }

        Specification<Statement> finalSpecification = null;
        for (Specification<Statement> spec : specifications) {
            finalSpecification = Specifications.where(finalSpecification).and(spec);
        }
        return statementRepository.findAll(finalSpecification);
    }

    @RequestMapping(method = RequestMethod.POST)
    public JsonBoolean postStatement(
            @RequestBody StatementConstructor statementConstructor) {

        //todo create - update methods and logic

        Statement statement = new Statement();
        statement.setStudent(statementConstructor.getStudentID() != null ? studentRepository.findOne(statementConstructor.getStudentID()) : null);
        statement.setEvent(statementConstructor.getEventID() != null ? eventRepository.findOne(statementConstructor.getEventID()) : null);
        statement.setSocialCategory(statementConstructor.getSocialCategoryID() != null ? socialCategoryRepository.findOne(statementConstructor.getSocialCategoryID()) : null);
        statement.setSocialWork(statementConstructor.getSocialWorkID() != null ? socialWorkRepository.findOne(statementConstructor.getSocialWorkID()) : null);
        statement.setAverage_score(statementConstructor.getAverageScore());
        statement.setComment(statementConstructor.getComment());
        statement.setCompleteDocs(statementConstructor.getCompleteDocs());
        //todo не получаю с фронта
//        statement.setReserve(statementConstructor.getReserve());
        statement.setReserve(false);


        //todo fix
        if (statement.getEvent().getSection().getMoneyCategory()) {
            statement.setMoneyCategory(statement.getSocialCategory().getMoney());
        }

        //todo откуда получить? видимо с фронта
        statement.setSocialGrant(false);

        statement.setFillingDate(LocalDate.now());
        statement.setEmployee(employeeRepository.findOne(1));//TODO fix to real employeeID from session
        statement.setCourse(courseRepository.findOne(statement.getStudent().getCourse()));
        //todo а что если поездок больше, чем есть в таблице?
//        Integer tripCount = statementRepository.getStudentTripCount(statement.getStudent(), statement.getEvent().getSection());
        statement.setTripCount(tripCountRepository.findOne(
                statementRepository.getStudentTripCount(
                        statement.getStudent(), statement.getEvent().getSection())));
        //todo а что если отказов больше, чем есть в таблице?
//        Integer refusalCount = statementRepository.getStudentRefusalCount(statement.getStudent(), statement.getEvent().getSection());
        statement.setRefusalCount(refusalRepository.findOne(
                statementRepository.getStudentRefusalCount(
                        statement.getStudent(), statement.getEvent().getSection())));


        if (statementRepository.statementIsValid(statement)) {
            statementRepository.save(statement);
            return new JsonBoolean(true);
        } else {
            return new JsonBoolean(false);
        }
    }

    @RequestMapping(value = "/check/beenOnEvent", method = RequestMethod.GET, produces="application/json")
    public JsonBoolean haveBeenOnEvent(
            @RequestParam(value = "eventID", required = true) Event event,
            @RequestParam(value = "studentID", required = true) Student student) {
        return new JsonBoolean(eventRepository.studentHaveBeenOnEvent(student, event));
    }

    @RequestMapping(value = "/check/beenOnAncestors", method = RequestMethod.GET)
    public JsonBoolean haveBeenOnAncestors(
            @RequestParam(value = "eventID", required = true) Event event,
            @RequestParam(value = "studentID", required = true) Student student) {
        return new JsonBoolean(eventRepository.haveStudentBeenOnAncestorEvent(student, event));
    }

    @RequestMapping(value = "/check/beenOnSectionInCurTerm", method = RequestMethod.GET)
    public JsonBoolean haveBeenOnSectionInCurrentTerm(
            @RequestParam(value = "studentID", required = true) Student student,
            @RequestParam(value = "sectionID", required = true) Section section) {
        return new JsonBoolean(sectionRepository.studentBeenOnSectionOfCurrentTerm(student, section));
    }

    @RequestMapping(value = "/check/madeStatementOnEvent", method = RequestMethod.GET)
    public JsonBoolean studentMadeStatementOnEvent(
            @RequestParam(value = "studentID", required = true) Student student,
            @RequestParam(value = "eventID", required = true) Event event) {
        return new JsonBoolean(eventRepository.studentMadeStatementOnEvent(student, event));
    }
}
