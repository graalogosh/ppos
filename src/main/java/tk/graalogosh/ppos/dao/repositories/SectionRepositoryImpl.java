package tk.graalogosh.ppos.dao.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import tk.graalogosh.ppos.dao.specifications.StatementSpecifications;
import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 28.10.2015.
 */
public class SectionRepositoryImpl implements SectionRepositoryCustom {
    @Autowired
    StatementRepository statementRepository;


    @Override
    public Boolean studentBeenOnSectionOfCurrentTerm(Student student, Section section) {
        List<Statement> statements =statementRepository.findAll(Specifications.where(StatementSpecifications.studentIs(student)).and(StatementSpecifications.inCurrentTerm()));
        for (Statement statement:statements){
            if(statement.getEvent().getSection().equals(section)){
                return true;
            }
        }
        return false;
    }
}
