package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.repositories.EmployeeRepository;
import tk.graalogosh.ppos.repositories.EventRepository;
import tk.graalogosh.ppos.repositories.SectionRepository;
import tk.graalogosh.ppos.specifications.EventSpecification;
import tk.graalogosh.ppos.utils.Dates;

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

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Event> getEvents(
//            @RequestParam(value = "eventID", required = false) Integer eventID,
//            @RequestParam(value = "title", required = false) String title,
//            @RequestParam(value = "eventDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate eventDate,
//            @RequestParam(value = "duration", required = false) Integer duration,
//            @RequestParam(value = "reseptionBegin", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate receptionBegin,
//            @RequestParam(value = "reseptionFinish", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate reseptionFinish,
//            @RequestParam(value = "employeeID", required = false) Integer employeeID,
//            @RequestParam(value = "sectionID", required = false) Integer sectionID,
//            @RequestParam(value = "numberOfPlaces", required = false) Integer numberOfPlaces,
//            @RequestParam(value = "quotasPercentage", required = false) Integer quotasPercentage,
//            //TODO suitableCategory
//            @RequestParam(value = "suitableCategory", required = false) String suitableCategory,
//            @RequestParam(value = "firstDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate firstDate,
//            @RequestParam(value = "lastDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastDate,
//            @RequestParam(value = "curTerm", required = false) Boolean curTerm) {
//
//        firstDate = firstDate != null ? firstDate : Dates.MINDATE;
//        lastDate = lastDate != null ? lastDate : Dates.MAXDATE;
//        curTerm = curTerm != null ? curTerm : true;
//
//        Event example = new Event();
//        example.setEventID(eventID);
//        example.setTitle(title);
//        example.setEventDate(eventDate);
//        example.setDuration(duration);
//        example.setReseptionBegin(receptionBegin);
//        example.setReseptionFinish(reseptionFinish);
//        example.setEmployee(employeeID != null ? employeeRepository.findOne(employeeID) : null);
//        example.setSection(sectionID != null ? sectionRepository.findOne(sectionID) : null);
//        example.setNumberOfPlaces(numberOfPlaces);
//        example.setQuotasPercantage(quotasPercentage);
//        example.setSuitableCategory(suitableCategory);
//
//        EventSpecification specification = new EventSpecification(example);
//        List<Event> events1 = eventRepository.findAll(specification);
//
//        List<Event> events2 = eventRepository.findByEventDateBetween(firstDate, lastDate);
//        List<Event> events3 = eventRepository.findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate.now());
//        List<Event> resultEvents = new ArrayList<>();
//        for (Event event : events1) {
//            //пересечение event, event2 и event3 (только если curTerm=true)
//            if (events2.contains(event) && (events3.contains(event) || !curTerm)) {
//                resultEvents.add(event);
//            }
//        }
//        return resultEvents;
//    }

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
            @RequestParam(value = "lastDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastDate,
            @RequestParam(value = "curTerm", required = false) Boolean curTerm) {

        curTerm = curTerm != null ? curTerm : true;

        List<Specification<Event>> specifications = new ArrayList<>();
        if (eventID != null){
            specifications.add(EventSpecification.IDIs(eventID));
        }

        if (title!=null){
            specifications.add(EventSpecification.titleIs(title));
        }

        if (eventDate!=null){
            specifications.add(EventSpecification.eventDateIs(eventDate));
        }

        if (duration!=null){
            specifications.add(EventSpecification.durationIs(duration));
        }

        if (receptionBegin!=null){
            specifications.add(EventSpecification.reseptionBeginIn(receptionBegin));
        }

        if (reseptionFinish!=null){
            specifications.add(EventSpecification.reseptionFinishIn(reseptionFinish));
        }

        if (employeeID!=null){
            specifications.add(EventSpecification.employeeIs(employeeRepository.findOne(employeeID)));
        }

        if (sectionID!=null){
            specifications.add(EventSpecification.sectionIs(sectionRepository.findOne(sectionID)));
        }

        if (numberOfPlaces!=null){
            specifications.add(EventSpecification.numberOfPlacesIs(numberOfPlaces));
        }

        if (quotasPercentage!=null){
            specifications.add(EventSpecification.quotasPercantageIs(quotasPercentage));
        }

        if (firstDate!=null){
            specifications.add(EventSpecification.eventIsAfter(firstDate));
        }

        if (lastDate!=null){
            specifications.add(EventSpecification.eventIsBefore(lastDate));
        }

        if (curTerm){
            specifications.add(EventSpecification.findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate.now()));
        }

        Specification<Event> finalSpecification=null;
        for (Specification<Event> spec : specifications){
            finalSpecification = Specifications.where(finalSpecification).and(spec);
        }
        return eventRepository.findAll(finalSpecification);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postEvent(
            @RequestBody Event payload) {
        throw new UnsupportedOperationException();
    }
}
