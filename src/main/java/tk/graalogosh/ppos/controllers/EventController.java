package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.repositories.EventRepository;

import java.util.List;

/**
 * Created by graal on 27.09.2015.
 */
@RestController
public class EventController {
    private EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(value = "events", method = RequestMethod.GET)
    public List<Event> getEvents(){
        //TODO make search
        return eventRepository.findAll();
    }

    @RequestMapping(value = "events", method = RequestMethod.POST)
    public Boolean postEvent(
            @RequestBody Event payload){
        throw new NotImplementedException();
    }
}
