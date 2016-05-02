package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graal on 05.08.2015.
 */
@Data
@Entity
@Table(name = "employees")
public class Employee {
    public Employee() {
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "employee_id")
    private Integer employeeID;

    @Column(name = "name")
    private String name;
    @Column(name = "access_level")
    private Integer accessLevel;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "hash")
    @JsonIgnore
    private String passwordHash;

    @Column(name = "registration_date")
    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    private LocalDate registrationDate;
    @Column(name = "last_login_date")
    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    private LocalDate lastLoginDate;
    @Column(name = "dismissed")
    private Boolean dismissed;
    @ManyToOne
    @JoinColumn(name = "faculty")
    private Faculty faculty;
}
