package tk.graalogosh.ppos.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.StatementList;

import javax.persistence.Table;

/**
 * Created by graal on 21.09.2015.
 */
@Repository
@Table(name="list")
public interface StatementListRepository extends JpaRepository<StatementList, Integer> {
}
