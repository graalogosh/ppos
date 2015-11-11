package tk.graalogosh.ppos.dao.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import tk.graalogosh.ppos.dao.specifications.StatementSpecifications;
import tk.graalogosh.ppos.models.Course;
import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;
import tk.graalogosh.ppos.models.constuctors.StatementConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 24.10.2015.
 */
public class StatementRepositoryImpl implements StatementRepositoryCustom {
    @Autowired
    StatementRepository statementRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SocialCategoryRepository socialCategoryRepository;
    @Autowired
    SocialWorkRepository socialWorkRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    TripCountRepository tripCountRepository;
    @Autowired
    RefusalRepository refusalRepository;


    @Override
    public Boolean statementIsValid(Statement statement) {
        System.out.println("statementIsValid is ALWAYS TRUE!!! FIX");
        //TODO fix
        return true;
    }

    @Override
    public Integer getStudentTripCount(Student student, Section section) {
        List<Statement> statements = statementRepository.findAll(StatementSpecifications.studentIs(student));
        int count = 0;
        for (Statement statement:statements){
            if(statement.getEvent().getSection().equals(section) && statement.studentHaveBeenOnEvent()){
                count++;
            }
        }
        return count;
    }

    @Override
    public Integer getStudentRefusalCount(Student student, Section section) {
        List<Statement> statements = statementRepository.findAll(StatementSpecifications.studentIs(student));
        int count = 0;
        for (Statement statement:statements){
            if(statement.getRefusalDate()!=null){
                count++;
            }
        }
        return count;
    }

    @Override
    public Statement createStatement(StatementConstructor statementConstructor) {
        Statement statement = new Statement();
        statement.setStudent(statementConstructor.getStudentID() != null ? studentRepository.findOne(statementConstructor.getStudentID()) : null);
        statement.setEvent(statementConstructor.getEventID() != null ? eventRepository.findOne(statementConstructor.getEventID()) : null);
        statement.setSocialCategory(statementConstructor.getSocialCategoryID() != null ? socialCategoryRepository.findOne(statementConstructor.getSocialCategoryID()) : null);
        statement.setSocialWork(statementConstructor.getSocialWorkID() != null ? socialWorkRepository.findOne(statementConstructor.getSocialWorkID()) : null);
        statement.setAverageScore(statementConstructor.getAverageScore());
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
        statement.setTripCount(tripCountRepository.findOne(
                statementRepository.getStudentTripCount(
                        statement.getStudent(), statement.getEvent().getSection())));
        //todo а что если отказов больше, чем есть в таблице?
        statement.setRefusalCount(refusalRepository.findOne(
                statementRepository.getStudentRefusalCount(
                        statement.getStudent(), statement.getEvent().getSection())));


        if (statementRepository.statementIsValid(statement)) {
            statementRepository.save(statement);
            return statement;
        } else {
            throw new RuntimeException("statement is not valid");
        }
    }

    @Override
    public Statement updateStatement(StatementConstructor statementConstructor) throws Exception {
        if (statementConstructor.getStatementID()==null){
            throw new NullPointerException("statementID is null");
        }

        Statement statement = statementRepository.findOne(statementConstructor.getStatementID());

        if (statement==null){
            throw new Exception("statement not found");
        }

         if (statementConstructor.getStudentID()!=null){
             statement.setStudent(studentRepository.findOne(statementConstructor.getStudentID()));
         }

         if (statementConstructor.getEventID()!=null){
             statement.setEvent(eventRepository.findOne(statementConstructor.getEventID()));
         }

         if (statementConstructor.getSocialCategoryID()!=null){
             statement.setSocialCategory(socialCategoryRepository.findOne(statementConstructor.getSocialCategoryID()));
         }

         if (statementConstructor.getSocialWorkID()!=null){
             statement.setSocialWork(socialWorkRepository.findOne(statementConstructor.getSocialWorkID()));
         }

        if (statementConstructor.getAverageScore()!=null){
            statement.setAverageScore(statementConstructor.getAverageScore());
        }

        if (statementConstructor.getComment()!=null){
            statement.setComment(statementConstructor.getComment());
        }

         if (statementConstructor.getCompleteDocs()!=null){
             statement.setCompleteDocs(statementConstructor.getCompleteDocs());
         }

         if (statementConstructor.getReserve()!=null){
             statement.setReserve(statementConstructor.getReserve());
         }

        //todo valid checking?
        statementRepository.save(statement);
        return statement;
    }
}
