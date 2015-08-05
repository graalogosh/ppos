package tk.graalogosh.ppos.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    @Column(name = "eventID")
    private Integer eventID;
    @Column(name = "title")
    private String title;
    @Column(name = "event_date")
    private Date eventDate;
    @Column(name = "duration")
    private int duration;
    @Column(name = "reseption_begin")
    private Date reseptionBegin;
    @Column(name = "reseption_finish")
    private Date reseptionFinish;
    @Column(name = "employee_id")
    private int employeeID;
    @Column(name = "section_id")
    private int sectionID;
    @Column(name = "number_of_places")
    private int numberOfPlaces;
    @Column(name = "quotas_percantage")
    private int quotasPercantage;
    @Column(name = "suitable_category")
    private String suitableCategory;

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getReseptionBegin() {
        return reseptionBegin;
    }

    public void setReseptionBegin(Date reseptionBegin) {
        this.reseptionBegin = reseptionBegin;
    }

    public Date getReseptionFinish() {
        return reseptionFinish;
    }

    public void setReseptionFinish(Date reseptionFinish) {
        this.reseptionFinish = reseptionFinish;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public int getQuotasPercantage() {
        return quotasPercantage;
    }

    public void setQuotasPercantage(int quotasPercantage) {
        this.quotasPercantage = quotasPercantage;
    }

    public String getSuitableCategory() {
        return suitableCategory;
    }

    public void setSuitableCategory(String suitableCategory) {
        this.suitableCategory = suitableCategory;
    }

    public Event(String title, Date eventDate, int duration, Date reseptionBegin, Date reseptionFinish, int employeeID, int sectionID, int numberOfPlaces, int quotasPercantage, String suitableCategory) {
        this.title = title;
        this.eventDate = eventDate;
        this.duration = duration;
        this.reseptionBegin = reseptionBegin;
        this.reseptionFinish = reseptionFinish;
        this.employeeID = employeeID;
        this.sectionID = sectionID;
        this.numberOfPlaces = numberOfPlaces;
        this.quotasPercantage = quotasPercantage;
        this.suitableCategory = suitableCategory;
    }
}
