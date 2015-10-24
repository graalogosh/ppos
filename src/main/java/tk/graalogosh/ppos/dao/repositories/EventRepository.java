package tk.graalogosh.ppos.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Event;

import javax.persistence.Table;

/**
 * Created by graal on 22.09.2015.
 */
@Repository
@Table(name = "event")
public interface EventRepository extends JpaRepository<Event, Integer>, JpaSpecificationExecutor, EventRepositoryCustom {

}
