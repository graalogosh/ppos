package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import tk.graalogosh.ppos.utils.LocalDateDeserializer;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "statement")
public class Statement {
    public Statement(){}

    @Id
    @GeneratedValue
    @Column(name = "statement_id")
    private Integer statementID;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate fillingDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private boolean socialGrant;

    @ManyToOne
    @JoinColumn(name = "social_category_id")
    private SocialCategory socialCategory;

    @ManyToOne
    @JoinColumn(name = "social_work_id")
    private SocialWork socialWork;

    private double moneyCategory;

    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "trip_count")
    private TripCount tripCount;

    //TODO averageScore
    private double average_score;

    @ManyToOne
    @JoinColumn(name = "refusal_count")
    private Refusal refusalCount;

    private int permitNumber;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate refusalDate;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate cancellationDate;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private StatementList list;

    private String comment;

    private boolean completeDocs;

    private boolean reserve;

    public Integer getStatementID() {
        return statementID;
    }

    public void setStatementID(Integer statementID) {
        this.statementID = statementID;
    }

    public LocalDate getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(LocalDate fillingDate) {
        this.fillingDate = fillingDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isSocialGrant() {
        return socialGrant;
    }

    public void setSocialGrant(boolean socialGrant) {
        this.socialGrant = socialGrant;
    }

    public SocialCategory getSocialCategory() {
        return socialCategory;
    }

    public void setSocialCategory(SocialCategory socialCategory) {
        this.socialCategory = socialCategory;
    }

    public SocialWork getSocialWork() {
        return socialWork;
    }

    public void setSocialWork(SocialWork socialWork) {
        this.socialWork = socialWork;
    }

    public double getMoneyCategory() {
        return moneyCategory;
    }

    public void setMoneyCategory(double moneyCategory) {
        this.moneyCategory = moneyCategory;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public TripCount getTripCount() {
        return tripCount;
    }

    public void setTripCount(TripCount tripCount) {
        this.tripCount = tripCount;
    }

    public double getAverage_score() {
        return average_score;
    }

    public void setAverage_score(double average_score) {
        this.average_score = average_score;
    }

    public Refusal getRefusalCount() {
        return refusalCount;
    }

    public void setRefusalCount(Refusal refusalCount) {
        this.refusalCount = refusalCount;
    }

    public int getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(int permitNumber) {
        this.permitNumber = permitNumber;
    }

    public LocalDate getRefusalDate() {
        return refusalDate;
    }

    public void setRefusalDate(LocalDate refusalDate) {
        this.refusalDate = refusalDate;
    }

    public LocalDate getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(LocalDate cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public StatementList getList() {
        return list;
    }

    public void setList(StatementList list) {
        this.list = list;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isCompleteDocs() {
        return completeDocs;
    }

    public void setCompleteDocs(boolean completeDocs) {
        this.completeDocs = completeDocs;
    }

    public boolean isReserve() {
        return reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    public Statement(LocalDate fillingDate, Student student, Event event, Employee employee, boolean socialGrant, SocialCategory socialCategory, SocialWork socialWork, double moneyCategory, Course course, TripCount tripCount, double average_score, Refusal refusalCount, int permitNumber, LocalDate refusalDate, LocalDate cancellationDate, StatementList list, String comment, boolean completeDocs, boolean reserve) {
        this.fillingDate = fillingDate;
        this.student = student;
        this.event = event;
        this.employee = employee;
        this.socialGrant = socialGrant;
        this.socialCategory = socialCategory;
        this.socialWork = socialWork;
        this.moneyCategory = moneyCategory;
        this.course = course;
        this.tripCount = tripCount;
        this.average_score = average_score;
        this.refusalCount = refusalCount;
        this.permitNumber = permitNumber;
        this.refusalDate = refusalDate;
        this.cancellationDate = cancellationDate;
        this.list = list;
        this.comment = comment;
        this.completeDocs = completeDocs;
        this.reserve = reserve;
    }
}

