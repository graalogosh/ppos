package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.Event;
import tk.graalogosh.ppos.dao.repositories.EmployeeRepository;
import tk.graalogosh.ppos.dao.repositories.EventRepository;
import tk.graalogosh.ppos.dao.repositories.SectionRepository;
import tk.graalogosh.ppos.dao.specifications.EventSpecifications;

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
            @RequestParam(value = "lastDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastDate,
            @RequestParam(value = "curTerm", required = false, defaultValue = "true") Boolean curTerm) {

//        curTerm = curTerm != null ? curTerm : true;

        List<Specification<Event>> specifications = new ArrayList<>();
        if (eventID != null){
            specifications.add(EventSpecifications.IDIs(eventID));
        }

        if (title!=null){
            specifications.add(EventSpecifications.titleIs(title));
        }

        if (eventDate!=null){
            specifications.add(EventSpecifications.eventDateIs(eventDate));
        }

        if (duration!=null){
            specifications.add(EventSpecifications.durationIs(duration));
        }

        if (receptionBegin!=null){
            specifications.add(EventSpecifications.reseptionBeginIn(receptionBegin));
        }

        if (reseptionFinish!=null){
            specifications.add(EventSpecifications.reseptionFinishIn(reseptionFinish));
        }

        if (employeeID!=null){
            specifications.add(EventSpecifications.employeeIs(employeeRepository.findOne(employeeID)));
        }

        if (sectionID!=null){
            specifications.add(EventSpecifications.sectionIs(sectionRepository.findOne(sectionID)));
        }

        if (numberOfPlaces!=null){
            specifications.add(EventSpecifications.numberOfPlacesIs(numberOfPlaces));
        }

        if (quotasPercentage!=null){
            specifications.add(EventSpecifications.quotasPercantageIs(quotasPercentage));
        }

        if (firstDate!=null){
            specifications.add(EventSpecifications.eventIsAfter(firstDate));
        }

        if (lastDate!=null){
            specifications.add(EventSpecifications.eventIsBefore(lastDate));
        }

        if (curTerm){
            specifications.add(EventSpecifications.findByReseptionBeginBeforeAndReseptionFinishAfter(LocalDate.now()));
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
