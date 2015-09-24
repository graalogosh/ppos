package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tk.graalogosh.ppos.utils.LocalDateDeserializer;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "statement")
@AllArgsConstructor (access = AccessLevel.PUBLIC)
public class Statement {
    public Statement(){}

    @Id
    @GeneratedValue
    @Column(name = "statement_id")
    @Getter @Setter
    private Integer statementID;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Getter @Setter
    private LocalDate fillingDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @Getter @Setter
    private Student student;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @Getter @Setter
    private Event event;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @Getter @Setter
    private Employee employee;

    @Getter @Setter
    private Boolean socialGrant;

    @ManyToOne
    @JoinColumn(name = "social_category_id")
    @Getter @Setter
    private SocialCategory socialCategory;

    @ManyToOne
    @JoinColumn(name = "social_work_id")
    @Getter @Setter
    private SocialWork socialWork;

    @Getter @Setter
    private Double moneyCategory;

    @ManyToOne
    @JoinColumn(name = "course")
    @Getter @Setter
    private Course course;

    @ManyToOne
    @JoinColumn(name = "trip_count")
    @Getter @Setter
    private TripCount tripCount;

    //TODO averageScore
    @Getter @Setter
    private Double average_score;

    @ManyToOne
    @JoinColumn(name = "refusal_count")
    @Getter @Setter
    private Refusal refusalCount;

    @Getter @Setter
    private Integer permitNumber;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Getter @Setter
    private LocalDate refusalDate;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Getter @Setter
    private LocalDate cancellationDate;

    @ManyToOne
    @JoinColumn(name = "list_id")
    @Getter @Setter
    private StatementList list;

    @Getter @Setter
    private String comment;

    @Getter @Setter
    private Boolean completeDocs;

    @Getter @Setter
    private Boolean reserve;

//    public Statement(LocalDate fillingDate, Student student, Event event, Employee employee, boolean socialGrant, SocialCategory socialCategory, SocialWork socialWork, double moneyCategory, Course course, TripCount tripCount, double average_score, Refusal refusalCount, int permitNumber, LocalDate refusalDate, LocalDate cancellationDate, StatementList list, String comment, boolean completeDocs, boolean reserve) {
//        this.fillingDate = fillingDate;
//        this.student = student;
//        this.event = event;
//        this.employee = employee;
//        this.socialGrant = socialGrant;
//        this.socialCategory = socialCategory;
//        this.socialWork = socialWork;
//        this.moneyCategory = moneyCategory;
//        this.course = course;
//        this.tripCount = tripCount;
//        this.average_score = average_score;
//        this.refusalCount = refusalCount;
//        this.permitNumber = permitNumber;
//        this.refusalDate = refusalDate;
//        this.cancellationDate = cancellationDate;
//        this.list = list;
//        this.comment = comment;
//        this.completeDocs = completeDocs;
//        this.reserve = reserve;
//    }
}

