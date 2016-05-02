package tk.graalogosh.ppos.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Data
@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "title")
    private String title;
    @Column(name = "dean")
    private String dean;
    @Column(name = "quotas_percentage")
    private double quotasPercentage;


}
