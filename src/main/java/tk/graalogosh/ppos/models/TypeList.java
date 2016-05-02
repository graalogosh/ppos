package tk.graalogosh.ppos.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name = "type_id")
    private Integer typeID;
    private String title;

    public TypeList(String title) {
        this.title = title;
    }
}
