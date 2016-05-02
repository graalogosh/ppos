package tk.graalogosh.ppos.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Data
@Entity
@Table(name="section")
public class Section {
    public Section() {
    }
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
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

}
