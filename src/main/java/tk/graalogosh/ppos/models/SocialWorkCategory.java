package tk.graalogosh.ppos.models;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "socialworkcategory")
public class SocialWorkCategory {
    //TODO Change field names to JAVA convention
    @Id
    @GeneratedValue
    private Integer social_work_category_id;
    private String title;
    private boolean visible;

    public Integer getSocial_work_category_id() {
        return social_work_category_id;
    }

    public void setSocial_work_category_id(Integer social_work_category_id) {
        this.social_work_category_id = social_work_category_id;
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
