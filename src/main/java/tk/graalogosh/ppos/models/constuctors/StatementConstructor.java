package tk.graalogosh.ppos.models.constuctors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import tk.graalogosh.ppos.models.*;
import tk.graalogosh.ppos.utils.LocalDateDeserializer;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "statement")
public class StatementConstructor {
    public StatementConstructor(){}

    @JsonProperty(value = "studentID")
    private Student student;

    @JsonProperty(value = "eventID")
    private Event eventID;

    @JsonProperty(value = "socialCategoryID")
    private SocialCategory socialCategory;

    @JsonProperty(value = "socialWorkID")
    private SocialWork socialWork;

    //TODO averageScore
    private Double average_score;

    private String comment;

    private Boolean completeDocs;

    private Boolean reserve;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Event getEventID() {
        return eventID;
    }

    public void setEventID(Event eventID) {
        this.eventID = eventID;
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

    public Double getAverage_score() {
        return average_score;
    }

    public void setAverage_score(Double average_score) {
        this.average_score = average_score;
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

    public StatementConstructor(Student student, Event eventID, SocialCategory socialCategory, SocialWork socialWork, Double average_score, String comment, Boolean completeDocs, Boolean reserve) {
        this.student = student;
        this.eventID = eventID;
        this.socialCategory = socialCategory;
        this.socialWork = socialWork;
        this.average_score = average_score;
        this.comment = comment;
        this.completeDocs = completeDocs;
        this.reserve = reserve;
    }
}

