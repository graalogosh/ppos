package tk.graalogosh.ppos.models;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "socialwork")
public class SocialWork {
    public SocialWork() {
    }

    //TODO Change field names to JAVA convention
    @Id
    @GeneratedValue
    private Integer social_work_id;
    private String title;
    private int point;

    @ManyToOne
    @JoinColumn(name = "social_work_category_id")
    private SocialWorkCategory socialWorkCategory;

    private boolean visible;

    public Integer getSocial_work_id() {
        return social_work_id;
    }

    public void setSocial_work_id(Integer social_work_id) {
        this.social_work_id = social_work_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public SocialWorkCategory getSocialWorkCategory() {
        return socialWorkCategory;
    }

    public void setSocial_work_category_id(SocialWorkCategory socialWorkCategory) {
        this.socialWorkCategory = socialWorkCategory;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public SocialWork(String title, int point, SocialWorkCategory socialWorkCategory, boolean visible) {
        this.title = title;
        this.point = point;
        this.socialWorkCategory = socialWorkCategory;
        this.visible = visible;
    }
}
