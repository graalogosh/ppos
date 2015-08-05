package tk.graalogosh.ppos.models;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "events")
public class Faculty {
    @Id
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "title")
    private String title;
    @Column(name = "dean")
    private String dean;
    @Column(name = "quotas_percentage")
    private double quotasPercentage;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public double getQuotasPercentage() {
        return quotasPercentage;
    }

    public void setQuotasPercentage(double quotasPercentage) {
        this.quotasPercentage = quotasPercentage;
    }

    public Faculty(String faculty, String title, String dean, Double quotasPercentage) {
        this.faculty = faculty;
        this.title = title;
        this.dean = dean;
        this.quotasPercentage = quotasPercentage;
    }
}
