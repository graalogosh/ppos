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
    private boolean visible;

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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public SocialWorkCategory(String title, boolean visible) {
        this.title = title;
        this.visible = visible;
    }
}
