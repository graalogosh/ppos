package tk.graalogosh.ppos.dao.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import tk.graalogosh.ppos.dao.specifications.StatementSpecification;
import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;

import java.util.List;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 24.10.2015.
 */
public class StatementRepositoryImpl implements StatementRepositoryCustom {
    @Autowired
    StatementRepository statementRepository;
    @Autowired
    EventRepository eventRepository;

    @Override
    public Boolean statementIsValid(Statement statement) {
        System.out.println("statementIsValid is ALWAYS TRUE!!! FIX");
        //TODO fix
        return true;
    }

    @Override
    public Integer getStudentTripCount(Student student, Section section) {
        List<Statement> statements = statementRepository.findAll(StatementSpecification.studentIs(student));
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
        List<Statement> statements = statementRepository.findAll(StatementSpecification.studentIs(student));
        int count = 0;
        for (Statement statement:statements){
            if(statement.getRefusalDate()!=null){
                count++;
            }
        }
        return count;
    }
}
