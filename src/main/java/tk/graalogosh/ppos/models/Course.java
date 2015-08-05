package tk.graalogosh.ppos.models;

import javax.persistence.*;
/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name="course")
public class Course {
    @Id
    @Column(name = "course")
    private Integer course;

    @Column(name = "point")
    private int point;

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Course(int course, int point) {
        this.course = course;
        this.point = point;
    }
}
