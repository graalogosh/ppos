package tk.graalogosh.ppos.models;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name="section")
public class Section {
    //TODO Change field names to JAVA convention
    @Id
    @GeneratedValue
    private Integer section_id;
    private String title;
    private boolean social_grant;
    private boolean social_category;
    private boolean social_work;
    private boolean average_score;
    private boolean trip_count;
    private boolean refusual_count;
    private boolean course;
    private boolean point_sum;
    private boolean bank_account_number;
    private boolean list;
    private boolean retrip;
    private boolean money_category;

    public Integer getSection_id() {
        return section_id;
    }

    public void setSection_id(Integer section_id) {
        this.section_id = section_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSocial_grant() {
        return social_grant;
    }

    public void setSocial_grant(boolean social_grant) {
        this.social_grant = social_grant;
    }

    public boolean isSocial_category() {
        return social_category;
    }

    public void setSocial_category(boolean social_category) {
        this.social_category = social_category;
    }

    public boolean isSocial_work() {
        return social_work;
    }

    public void setSocial_work(boolean social_work) {
        this.social_work = social_work;
    }

    public boolean isAverage_score() {
        return average_score;
    }

    public void setAverage_score(boolean average_score) {
        this.average_score = average_score;
    }

    public boolean isTrip_count() {
        return trip_count;
    }

    public void setTrip_count(boolean trip_count) {
        this.trip_count = trip_count;
    }

    public boolean isRefusual_count() {
        return refusual_count;
    }

    public void setRefusual_count(boolean refusual_count) {
        this.refusual_count = refusual_count;
    }

    public boolean isCourse() {
        return course;
    }

    public void setCourse(boolean course) {
        this.course = course;
    }

    public boolean isPoint_sum() {
        return point_sum;
    }

    public void setPoint_sum(boolean point_sum) {
        this.point_sum = point_sum;
    }

    public boolean isBank_account_number() {
        return bank_account_number;
    }

    public void setBank_account_number(boolean bank_account_number) {
        this.bank_account_number = bank_account_number;
    }

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }

    public boolean isRetrip() {
        return retrip;
    }

    public void setRetrip(boolean retrip) {
        this.retrip = retrip;
    }

    public boolean isMoney_category() {
        return money_category;
    }

    public void setMoney_category(boolean money_category) {
        this.money_category = money_category;
    }

    public Section(String title, boolean social_grant, boolean social_category, boolean social_work, boolean average_score, boolean trip_count, boolean refusual_count, boolean course, boolean point_sum, boolean bank_account_number, boolean list, boolean retrip, boolean money_category) {
        this.title = title;
        this.social_grant = social_grant;
        this.social_category = social_category;
        this.social_work = social_work;
        this.average_score = average_score;
        this.trip_count = trip_count;
        this.refusual_count = refusual_count;
        this.course = course;
        this.point_sum = point_sum;
        this.bank_account_number = bank_account_number;
        this.list = list;
        this.retrip = retrip;
        this.money_category = money_category;
    }
}
