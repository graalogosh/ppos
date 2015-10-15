package tk.graalogosh.ppos.repositories;

import tk.graalogosh.ppos.models.Event;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 15.10.2015.
 */
public interface EventRepositoryCustom {
    List<Event> findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate date);
}
