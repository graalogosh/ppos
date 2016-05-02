package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import tk.graalogosh.ppos.models.constuctors.StatementConstructor;
import tk.graalogosh.ppos.utils.LocalDateDeserializer;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graal on 06.08.2015.
 */
@Data
@Entity
@Table(name = "statement")
//@AllArgsConstructor (access = AccessLevel.PUBLIC)
public class Statement {
    public Statement(){}

    @Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
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

    private Boolean socialGrant;

    @ManyToOne
    @JoinColumn(name = "social_category_id")
    private SocialCategory socialCategory;

    @ManyToOne
    @JoinColumn(name = "social_work_id")
    private SocialWork socialWork;

    private Double moneyCategory;

    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "trip_count")
    private TripCount tripCount;

    //TODO averageScore
    private Double averageScore;

    @ManyToOne
    @JoinColumn(name = "refusal_count")
    private Refusal refusalCount;

    @Column(name = "permit_number")
    private Integer permitNumber;

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

    private Boolean completeDocs;

    private Boolean reserve;

    public Statement(StatementConstructor constructor){

    }

    public Boolean studentHaveBeenOnEvent() {
        return  getPermitNumber() != null && //человек прошел по конкурсу
                getCancellationDate() == null && //не отменил
                getRefusalDate() == null; //не отказался
    }

//    public Boolean isActive(){
//        return getCancellationDate()!=null && getRefusalDate()!=null;
//    }
}

