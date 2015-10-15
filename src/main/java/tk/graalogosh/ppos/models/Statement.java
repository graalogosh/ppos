package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
import tk.graalogosh.ppos.utils.LocalDateDeserializer;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "statement")
//@AllArgsConstructor (access = AccessLevel.PUBLIC)
public class Statement {
    public Statement(){}

    @Id
//    @GeneratedValue
    @Column(name = "statement_id")
//    @Getter @Setter
    private Integer statementID;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @Getter @Setter
    private LocalDate fillingDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
//    @Getter @Setter
    private Student student;

    @ManyToOne
    @JoinColumn(name = "event_id")
//    @Getter @Setter
    private Event event;

    @ManyToOne
    @JoinColumn(name = "employee_id")
//    @Getter @Setter
    private Employee employee;

//    @Getter @Setter
    private Boolean socialGrant;

    @ManyToOne
    @JoinColumn(name = "social_category_id")
//    @Getter @Setter
    private SocialCategory socialCategory;

    @ManyToOne
    @JoinColumn(name = "social_work_id")
//    @Getter @Setter
    private SocialWork socialWork;

//    @Getter @Setter
    private Double moneyCategory;

    @ManyToOne
    @JoinColumn(name = "course")
//    @Getter @Setter
    private Course course;

    @ManyToOne
    @JoinColumn(name = "trip_count")
//    @Getter @Setter
    private TripCount tripCount;

    //TODO averageScore
//    @Getter @Setter
    private Double average_score;

    @ManyToOne
    @JoinColumn(name = "refusal_count")
//    @Getter @Setter
    private Refusal refusalCount;

//    @Getter @Setter
    @Column(name = "permit_number")
    private Integer permitNumber;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @Getter @Setter
    private LocalDate refusalDate;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @Getter @Setter
    private LocalDate cancellationDate;

    @ManyToOne
    @JoinColumn(name = "list_id")
//    @Getter @Setter
    private StatementList list;

//    @Getter @Setter
    private String comment;

//    @Getter @Setter
    private Boolean completeDocs;

//    @Getter @Setter
    private Boolean reserve;

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

    public Boolean getSocialGrant() {
        return socialGrant;
    }

    public void setSocialGrant(Boolean socialGrant) {
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

    public Double getMoneyCategory() {
        return moneyCategory;
    }

    public void setMoneyCategory(Double moneyCategory) {
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

    public Double getAverage_score() {
        return average_score;
    }

    public void setAverage_score(Double average_score) {
        this.average_score = average_score;
    }

    public Refusal getRefusalCount() {
        return refusalCount;
    }

    public void setRefusalCount(Refusal refusalCount) {
        this.refusalCount = refusalCount;
    }

    public Integer getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(Integer permitNumber) {
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

    public Boolean getCompleteDocs() {
        return completeDocs;
    }

    public void setCompleteDocs(Boolean completeDocs) {
        this.completeDocs = completeDocs;
    }

    public Boolean getReserve() {
        return reserve;
    }

    public void setReserve(Boolean reserve) {
        this.reserve = reserve;
    }

    public Statement(Integer statementID, LocalDate fillingDate, Student student, Event event, Employee employee, Boolean socialGrant, SocialCategory socialCategory, SocialWork socialWork, Double moneyCategory, Course course, TripCount tripCount, Double average_score, Refusal refusalCount, Integer permitNumber, LocalDate refusalDate, LocalDate cancellationDate, StatementList list, String comment, Boolean completeDocs, Boolean reserve) {
        this.statementID = statementID;
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

