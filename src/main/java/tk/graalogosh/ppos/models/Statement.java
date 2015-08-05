package tk.graalogosh.ppos.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "statement")
public class Statement {
    //TODO Change field names to JAVA convention
    @Id
    @GeneratedValue
    private Integer statement_id;
    private Date date;
    private String student_id;
    private int event_id;
    private int employee_id;
    private boolean social_grant;
    private int social_category_id;
    private int social_work_id;
    private double money_category;
    private int course;
    private int trip_count;
    private double average_score;
    private int refusal_count;
    private int permit_number;
    private Date refusal_date;
    private Date cancellation_date;
    private int list_id;
    private String comment;
    private boolean complete_docs;
    private boolean reserve;

    public int getStatement_id() {
        return statement_id;
    }

    public void setStatement_id(int statement_id) {
        this.statement_id = statement_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public boolean isSocial_grant() {
        return social_grant;
    }

    public void setSocial_grant(boolean social_grant) {
        this.social_grant = social_grant;
    }

    public int getSocial_category_id() {
        return social_category_id;
    }

    public void setSocial_category_id(int social_category_id) {
        this.social_category_id = social_category_id;
    }

    public int getSocial_work_id() {
        return social_work_id;
    }

    public void setSocial_work_id(int social_work_id) {
        this.social_work_id = social_work_id;
    }

    public double getMoney_category() {
        return money_category;
    }

    public void setMoney_category(double money_category) {
        this.money_category = money_category;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getTrip_count() {
        return trip_count;
    }

    public void setTrip_count(int trip_count) {
        this.trip_count = trip_count;
    }

    public double getAverage_score() {
        return average_score;
    }

    public void setAverage_score(double average_score) {
        this.average_score = average_score;
    }

    public int getRefusal_count() {
        return refusal_count;
    }

    public void setRefusal_count(int refusal_count) {
        this.refusal_count = refusal_count;
    }

    public int getPermit_number() {
        return permit_number;
    }

    public void setPermit_number(int permit_number) {
        this.permit_number = permit_number;
    }

    public Date getRefusal_date() {
        return refusal_date;
    }

    public void setRefusal_date(Date refusal_date) {
        this.refusal_date = refusal_date;
    }

    public Date getCancellation_date() {
        return cancellation_date;
    }

    public void setCancellation_date(Date cancellation_date) {
        this.cancellation_date = cancellation_date;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isComplete_docs() {
        return complete_docs;
    }

    public void setComplete_docs(boolean complete_docs) {
        this.complete_docs = complete_docs;
    }

    public boolean isReserve() {
        return reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    public Statement(int statement_id, Date date, String student_id, int event_id, int employee_id, boolean social_grant, int social_category_id, int social_work_id, double money_category, int course, int trip_count, double average_score, int refusal_count, int permit_number, Date refusal_date, Date cancellation_date, int list_id, String comment, boolean complete_docs, boolean reserve) {
        this.statement_id = statement_id;
        this.date = date;
        this.student_id = student_id;
        this.event_id = event_id;
        this.employee_id = employee_id;
        this.social_grant = social_grant;
        this.social_category_id = social_category_id;
        this.social_work_id = social_work_id;
        this.money_category = money_category;
        this.course = course;
        this.trip_count = trip_count;
        this.average_score = average_score;
        this.refusal_count = refusal_count;
        this.permit_number = permit_number;
        this.refusal_date = refusal_date;
        this.cancellation_date = cancellation_date;
        this.list_id = list_id;
        this.comment = comment;
        this.complete_docs = complete_docs;
        this.reserve = reserve;
    }
}
