package tk.graalogosh.ppos.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Data
@Entity
@Table(name = "tripcount")
public class TripCount {
    public TripCount() {
    }

    @Id
    @Column(name = "trip_count")
    private Integer tripCount;
    private Integer point;
}
