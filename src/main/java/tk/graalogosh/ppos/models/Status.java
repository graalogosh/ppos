package tk.graalogosh.ppos.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Data
@Entity
@Table(name = "status")
public class Status {
    public Status() {
    }

    @Id
    @GeneratedValue
    @Column(name = "status_id")
    private Integer statusID;
    private String title;
}
