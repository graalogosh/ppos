package tk.graalogosh.ppos.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "list")
public class StatementList {
    public StatementList() {
    }

    //TODO fix naming

    @Id
    @GeneratedValue
    @Column(name = "list_id")
    private Integer list_id;
    @Column(name = "transfer_date")
    private Date date;
    @Column(name = "type")
    private int type;
    @Column(name = "count_statement")
    private int count_statement;
    @Column(name = "faculty")
    private String faculty;

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount_statement() {
        return count_statement;
    }

    public void setCount_statement(int count_statement) {
        this.count_statement = count_statement;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public StatementList(Date date, int type, int count_statement, String faculty) {
        this.date = date;
        this.type = type;
        this.count_statement = count_statement;
        this.faculty = faculty;
    }
}
