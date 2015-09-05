package tk.graalogosh.ppos.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;

import javax.persistence.Table;

/**
 * Created by graal on 05.08.2015.
 */
@Repository
@Table(name = "statement")
public interface StatementRepository extends JpaRepository<Statement, Integer>{
}