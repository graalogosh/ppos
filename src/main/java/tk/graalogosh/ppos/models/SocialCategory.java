package tk.graalogosh.ppos.models;

/**
 * Created by graal on 06.08.2015.
 */

import javax.persistence.*;

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

    public Integer getSocialCategoryID() {
        return socialCategoryID;
    }

    public void setSocialCategoryID(Integer socialCategoryID) {
        this.socialCategoryID = socialCategoryID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public SocialCategory(String title, Integer priority, Integer point, String documents, Double money, Boolean visible) {
        this.title = title;
        this.priority = priority;
        this.point = point;
        this.documents = documents;
        this.money = money;
        this.visible = visible;
    }
}
