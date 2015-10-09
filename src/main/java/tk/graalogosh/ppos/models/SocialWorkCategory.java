package tk.graalogosh.ppos.models;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "socialworkcategory")
public class SocialWorkCategory {
    public SocialWorkCategory() {
    }

    @Id
    @GeneratedValue
    @Column(name = "social_work_category_id")
    private Integer socialWorkCategoryID;
    private String title;
    private Boolean visible;

    public Integer getSocialWorkCategoryID() {
        return socialWorkCategoryID;
    }

    public void setSocialWorkCategoryID(Integer socialWorkCategoryID) {
        this.socialWorkCategoryID = socialWorkCategoryID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public SocialWorkCategory(String title, Boolean visible) {
        this.title = title;
        this.visible = visible;
    }
}
