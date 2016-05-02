package tk.graalogosh.ppos.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Data
@Entity
@Table(name = "socialwork")
public class SocialWork {
    public SocialWork() {
    }

    @Id
    @GeneratedValue
    @Column(name = "social_work_id")
    private Integer socialWorkID;

    @Column(name = "title")
    private String title;

    @Column(name = "point")
    private Integer point;

    @ManyToOne
    @JoinColumn(name = "social_work_category_id")
    private SocialWorkCategory socialWorkCategory;

    @Column(name = "visible")
    private Boolean visible;
}
