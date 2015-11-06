package tk.graalogosh.ppos.models.constuctors;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by graal on 06.08.2015.
 */
public class StatementConstructor {
    public StatementConstructor(){}

    //for statement update
    @JsonProperty(value = "statementID")
    private Integer statementID;

    @JsonProperty(value = "studentID")
    private String  studentID;

    @JsonProperty(value = "eventID")
    private Integer eventID;

    @JsonProperty(value = "socialCategoryID")
    private Integer socialCategoryID;

    @JsonProperty(value = "socialWorkID")
    private Integer socialWorkID;

    //TODO averageScore
    private Double averageScore;

    private String comment;

    private Boolean completeDocs;

    private Boolean reserve;

    public Integer getStatementID() {
        return statementID;
    }

    public void setStatementID(Integer statementID) {
        this.statementID = statementID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getSocialCategoryID() {
        return socialCategoryID;
    }

    public void setSocialCategoryID(Integer socialCategoryID) {
        this.socialCategoryID = socialCategoryID;
    }

    public Integer getSocialWorkID() {
        return socialWorkID;
    }

    public void setSocialWorkID(Integer socialWorkID) {
        this.socialWorkID = socialWorkID;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
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

    public StatementConstructor(Integer statementID, String studentID, Integer eventID, Integer socialCategoryID, Integer socialWorkID, Double averageScore, String comment, Boolean completeDocs, Boolean reserve) {
        this.statementID = statementID;
        this.studentID = studentID;
        this.eventID = eventID;
        this.socialCategoryID = socialCategoryID;
        this.socialWorkID = socialWorkID;
        this.averageScore = averageScore;
        this.comment = comment;
        this.completeDocs = completeDocs;
        this.reserve = reserve;
    }
}

