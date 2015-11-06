package tk.graalogosh.ppos.models;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "refusal")
public class Refusal {
    public Refusal() {
    }

    @Id
    @Column(name = "refusal_count")
    private Integer refusalCount;
    private Integer point;

    public int getRefusalCount() {
        return refusalCount;
    }

    public void setRefusalCount(int refusalCount) {
        this.refusalCount = refusalCount;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Refusal(int refusalCount, int point) {
        this.refusalCount = refusalCount;
        this.point = point;
    }
}
