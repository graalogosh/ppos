package tk.graalogosh.ppos.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import tk.graalogosh.ppos.models.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 15.10.2015.
 */
public class EventRepositoryImpl implements EventRepositoryCustom {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate date) {
        LocalDate now = LocalDate.now();
        List<Event> list1 = eventRepository.findByReseptionBeginBefore(now);
        List<Event> list2 = eventRepository.findByReseptionFinishAfter(now);

        List<Event> resultList = new ArrayList<>();

        for (Event event : list1){
            if (list2.contains(event)){
                resultList.add(event);
            }
        }

        return resultList;
    }
}
