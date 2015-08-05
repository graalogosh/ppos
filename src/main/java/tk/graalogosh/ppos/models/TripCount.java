package tk.graalogosh.ppos.models;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "tripcount")
public class TripCount {
    @Id
    @Column(name = "trip_count")
    private Integer tripCount;
    private int point;

    public Integer getTripCount() {
        return tripCount;
    }

    public void setTripCount(Integer tripCount) {
        this.tripCount = tripCount;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public TripCount(Integer tripCount, int point) {
        this.tripCount = tripCount;
        this.point = point;
    }
}
