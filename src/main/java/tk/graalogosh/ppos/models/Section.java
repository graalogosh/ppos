package tk.graalogosh.ppos.models;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name="section")
public class Section {
    public Section() {
    }
    @Id
    @GeneratedValue
    @Column(name = "section_id")
    private Integer sectionID;

    @Column(name = "title")
    private String title;

    @Column(name = "social_grant")
    private Boolean socialGrant;

    @Column(name = "social_category")
    private Boolean socialCategory;

    @Column(name = "social_work")
    private Boolean socialWork;

    @Column(name = "average_score")
    private Boolean averageScore;

    @Column(name = "trip_count")
    private Boolean tripCount;

    @Column(name = "refusual_count")
    private Boolean refusualCount;

    @Column(name = "course")
    private Boolean course;

    @Column(name = "point_sum")
    private Boolean pointSum;

    @Column(name = "bank_account_number")
    private Boolean bankAccountNumber;

    @Column(name = "list")
    private Boolean list;

    @Column(name = "retrip")
    private Boolean retrip;

    @Column(name = "money_category")
    private Boolean moneyCategory;

    public Integer getSectionID() {
        return sectionID;
    }

    public void setSectionID(Integer sectionID) {
        this.sectionID = sectionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getSocialGrant() {
        return socialGrant;
    }

    public void setSocialGrant(Boolean socialGrant) {
        this.socialGrant = socialGrant;
    }

    public Boolean getSocialCategory() {
        return socialCategory;
    }

    public void setSocialCategory(Boolean socialCategory) {
        this.socialCategory = socialCategory;
    }

    public Boolean getSocialWork() {
        return socialWork;
    }

    public void setSocialWork(Boolean socialWork) {
        this.socialWork = socialWork;
    }

    public Boolean getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Boolean averageScore) {
        this.averageScore = averageScore;
    }

    public Boolean getTripCount() {
        return tripCount;
    }

    public void setTripCount(Boolean tripCount) {
        this.tripCount = tripCount;
    }

    public Boolean getRefusualCount() {
        return refusualCount;
    }

    public void setRefusualCount(Boolean refusualCount) {
        this.refusualCount = refusualCount;
    }

    public Boolean getCourse() {
        return course;
    }

    public void setCourse(Boolean course) {
        this.course = course;
    }

    public Boolean getPointSum() {
        return pointSum;
    }

    public void setPointSum(Boolean pointSum) {
        this.pointSum = pointSum;
    }

    public Boolean getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(Boolean bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Boolean getList() {
        return list;
    }

    public void setList(Boolean list) {
        this.list = list;
    }

    public Boolean getRetrip() {
        return retrip;
    }

    public void setRetrip(Boolean retrip) {
        this.retrip = retrip;
    }

    public Boolean getMoneyCategory() {
        return moneyCategory;
    }

    public void setMoneyCategory(Boolean moneyCategory) {
        this.moneyCategory = moneyCategory;
    }

    public Section(String title, Boolean socialGrant, Boolean socialCategory, Boolean socialWork, Boolean averageScore, Boolean tripCount, Boolean refusualCount, Boolean course, Boolean pointSum, Boolean bankAccountNumber, Boolean list, Boolean retrip, Boolean moneyCategory) {
        this.title = title;
        this.socialGrant = socialGrant;
        this.socialCategory = socialCategory;
        this.socialWork = socialWork;
        this.averageScore = averageScore;
        this.tripCount = tripCount;
        this.refusualCount = refusualCount;
        this.course = course;
        this.pointSum = pointSum;
        this.bankAccountNumber = bankAccountNumber;
        this.list = list;
        this.retrip = retrip;
        this.moneyCategory = moneyCategory;
    }


}
