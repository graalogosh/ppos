package tk.graalogosh.ppos.dao.repositories;

import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 24.10.2015.
 */
public interface StatementRepositoryCustom {

    Boolean statementIsValid(Statement statement);

    Integer getStudentTripCount(Student student, Section section);

    Integer getStudentRefusalCount(Student student);
}
