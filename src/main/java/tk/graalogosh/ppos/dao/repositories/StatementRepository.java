package tk.graalogosh.ppos.dao.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;

import javax.persistence.Table;
import java.util.List;

/**
 * Created by graal on 05.08.2015.
 */
@Repository
@Table(name = "statement")
public interface StatementRepository extends JpaRepository<Statement, Integer>, JpaSpecificationExecutor<Statement>, StatementRepositoryCustom {

}
