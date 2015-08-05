package tk.graalogosh.ppos.models;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "typelist")
public class TypeList {
    public TypeList() {
    }

    @Id
    @GeneratedValue
    @Column(name = "type_id")
    private Integer typeID;
    private String title;

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TypeList(String title) {
        this.title = title;
    }
}
