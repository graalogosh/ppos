package tk.graalogosh.ppos.dao.repositories;

import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.models.Student;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 28.10.2015.
 */
public interface SectionRepositoryCustom {
    Boolean studentBeenOnSectionOfCurrentTerm(Student student, Section section);
}
