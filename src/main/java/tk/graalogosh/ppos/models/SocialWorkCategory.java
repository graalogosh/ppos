package tk.graalogosh.ppos.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Data
@Entity
@Table(name = "socialworkcategory")
public class SocialWorkCategory {
    public SocialWorkCategory() {
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name = "social_work_category_id")
    private Integer socialWorkCategoryID;
    private String title;
    private Boolean visible;
}
