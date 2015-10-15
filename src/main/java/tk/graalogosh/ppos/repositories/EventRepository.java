package tk.graalogosh.ppos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.repositories.custom.EventRepositoryCustom;

import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by graal on 22.09.2015.
 */
@Repository
@Table(name="event")
public interface EventRepository extends JpaRepository<Event, Integer>, JpaSpecificationExecutor, EventRepositoryCustom {

    List<Event> findByEventDateBetween(LocalDate startDate, LocalDate finishDate);

    List<Event> findByReseptionBeginBefore(LocalDate date);

    List<Event> findByReseptionFinishAfter(LocalDate date);
}
