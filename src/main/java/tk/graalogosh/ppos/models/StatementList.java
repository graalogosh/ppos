package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "list")
public class StatementList {
    public StatementList() {
    }

    @Id
    @GeneratedValue
    @Column(name = "list_id")
    private Integer listID;

    @Column(name = "transfer_date")
    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    private LocalDate date;

    @Column(name = "type")
    private Integer type;

    @Column(name = "count_statement")
    private Integer countStatement;

    @Column(name = "faculty")
    private String faculty;

    public Integer getListID() {
        return listID;
    }

    public void setListID(Integer listID) {
        this.listID = listID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCountStatement() {
        return countStatement;
    }

    public void setCountStatement(Integer countStatement) {
        this.countStatement = countStatement;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public StatementList(LocalDate date, Integer type, Integer countStatement, String faculty) {
        this.date = date;
        this.type = type;
        this.countStatement = countStatement;
        this.faculty = faculty;
    }
}
