package tk.graalogosh.ppos.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Data
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

    public TypeList(String title) {
        this.title = title;
    }
}
