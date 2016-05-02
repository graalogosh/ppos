package tk.graalogosh.ppos.models;

/**
 * Created by graal on 06.08.2015.
 */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "socialcategory")
public class SocialCategory {
    public SocialCategory() {
    }

    @Id
    @GeneratedValue
    @Column(name = "social_category_id")
    private Integer socialCategoryID;
    private String title;
    private Integer priority;
    private Integer point;
    private String documents;
    private Double money;
    private Boolean visible;
}
