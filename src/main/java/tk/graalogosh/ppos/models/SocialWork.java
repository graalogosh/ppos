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

    @Id
    @GeneratedValue
    @Column(name = "social_work_id")
    private Integer socialWorkID;

    @Column(name = "title")
    private String title;

    @Column(name = "point")
    private int point;

    @ManyToOne
    @JoinColumn(name = "social_work_category_id")
    private SocialWorkCategory socialWorkCategory;

    @Column(name = "visible")
    private boolean visible;

    public Integer getSocialWorkID() {
        return socialWorkID;
    }

    public void setSocialWorkID(Integer socialWorkID) {
        this.socialWorkID = socialWorkID;
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

    public void setSocialWorkCategory(SocialWorkCategory socialWorkCategory) {
        this.socialWorkCategory = socialWorkCategory;
    }

    public boolean isVisible() {
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
