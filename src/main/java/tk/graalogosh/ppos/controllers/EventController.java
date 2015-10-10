package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.repositories.EmployeeRepository;
import tk.graalogosh.ppos.repositories.EventRepository;
import tk.graalogosh.ppos.repositories.SectionRepository;
import tk.graalogosh.ppos.specifications.EventSpecification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graal on 27.09.2015.
 */
@RestController
@RequestMapping(value = "event")
public class EventController {
    private EventRepository eventRepository;
    private EmployeeRepository employeeRepository;
    private SectionRepository sectionRepository;

    @Autowired
    public EventController(EventRepository eventRepository,
                           EmployeeRepository employeeRepository,
                           SectionRepository sectionRepository) {
        this.eventRepository = eventRepository;
        this.employeeRepository = employeeRepository;
        this.sectionRepository = sectionRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEvents(
            @RequestParam(value = "eventID", required = false) Integer eventID,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "eventDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate eventDate,
            @RequestParam(value = "duration", required = false) Integer duration,
            @RequestParam(value = "reseptionBegin", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate receptionBegin,
            @RequestParam(value = "reseptionFinish", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate reseptionFinish,
            @RequestParam(value = "employeeID", required = false) Integer employeeID,
            @RequestParam(value = "sectionID", required = false) Integer sectionID,
            @RequestParam(value = "numberOfPlaces", required = false) Integer numberOfPlaces,
            @RequestParam(value = "quotasPercentage", required = false) Integer quotasPercentage,
            //TODO suitableCategory
            @RequestParam(value = "suitableCategory", required = false) String suitableCategory,
            @RequestParam(value = "firstDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate firstDate,
            @RequestParam(value = "lastDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastDate) {


        Event example = new Event();
        example.setEventID(eventID);
        example.setTitle(title);
        example.setEventDate(eventDate);
        example.setDuration(duration);
        example.setReseptionBegin(receptionBegin);
        example.setReseptionFinish(reseptionFinish);
        example.setEmployee(employeeID != null ? employeeRepository.findOne(employeeID) : null);
        example.setSection(sectionID != null ? sectionRepository.findOne(sectionID) : null);
        example.setNumberOfPlaces(numberOfPlaces);
        example.setQuotasPercantage(quotasPercentage);
        example.setSuitableCategory(suitableCategory);

        EventSpecification specification = new EventSpecification(example);
        List<Event> events = eventRepository.findAll(specification);

        if (firstDate != null && lastDate != null) {
            List<Event> events2 = eventRepository.findByEventDateBetween(firstDate, lastDate);
            List<Event> resultEvents = new ArrayList<>();
            for (Event event:events){
                if (events2.contains(event)){
                    resultEvents.add(event);
                }
            }
            return resultEvents;
        }

        return events;

    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postEvent(
            @RequestBody Event payload) {
        throw new UnsupportedOperationException();
    }
}
