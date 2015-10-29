package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "events")
public class Event {
    public Event() {
    }

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private Integer eventID;
    @Column(name = "title")
    private String title;
    @Column(name = "event_date")
    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    private LocalDate eventDate;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "reseption_begin")
    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    private LocalDate reseptionBegin;
    @Column(name = "reseption_finish")
    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    private LocalDate reseptionFinish;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @Column(name = "number_of_places")
    private Integer numberOfPlaces;
    @Column(name = "quotas_percantage")
    private Integer quotasPercantage;
    @Column(name = "suitable_category")
    private String suitableCategory;

    @OneToOne
    @JoinColumn(name = "ancestor_id")
    private Event ancestor;

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getReseptionBegin() {
        return reseptionBegin;
    }

    public void setReseptionBegin(LocalDate reseptionBegin) {
        this.reseptionBegin = reseptionBegin;
    }

    public LocalDate getReseptionFinish() {
        return reseptionFinish;
    }

    public void setReseptionFinish(LocalDate reseptionFinish) {
        this.reseptionFinish = reseptionFinish;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public Integer getQuotasPercantage() {
        return quotasPercantage;
    }

    public void setQuotasPercantage(Integer quotasPercantage) {
        this.quotasPercantage = quotasPercantage;
    }

    public String getSuitableCategory() {
        return suitableCategory;
    }

    public void setSuitableCategory(String suitableCategory) {
        this.suitableCategory = suitableCategory;
    }

    public Event getAncestor() {
        return ancestor;
    }

    public void setAncestor(Event ancestor) {
        this.ancestor = ancestor;
    }

    public Event(String title, LocalDate eventDate, Integer duration, LocalDate reseptionBegin, LocalDate reseptionFinish, Employee employee, Section section, Integer numberOfPlaces, Integer quotasPercantage, String suitableCategory) {
        this.title = title;
        this.eventDate = eventDate;
        this.duration = duration;
        this.reseptionBegin = reseptionBegin;
        this.reseptionFinish = reseptionFinish;
        this.employee = employee;
        this.section = section;
        this.numberOfPlaces = numberOfPlaces;
        this.quotasPercantage = quotasPercantage;
        this.suitableCategory = suitableCategory;
    }
}
