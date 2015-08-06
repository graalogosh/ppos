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
    private int priority;
    private int point;
    private String documents;
    private double money;
    private boolean visible;

    public Integer getSocialCategoryID() {
        return socialCategoryID;
    }

    public void setSocial_category_id(Integer socialCategoryID) {
        this.socialCategoryID = socialCategoryID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public SocialCategory(String title, int priority, int point, String documents, double money, boolean visible) {
        this.title = title;
        this.priority = priority;
        this.point = point;
        this.documents = documents;
        this.money = money;
        this.visible = visible;
    }
}
