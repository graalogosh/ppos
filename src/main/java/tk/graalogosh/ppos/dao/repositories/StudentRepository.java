package tk.graalogosh.ppos.dao.repositories;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tk.graalogosh.ppos.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * Created by graal on 05.08.2015.
 */
@Repository
@Table(name = "student")
public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student>{
}
