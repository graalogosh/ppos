package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graal on 05.08.2015.
 */
@Entity
@Table(name = "employees")
public class Employee {
    public Employee() {
    }

    @Id
    @GeneratedValue
    @Column(name="employee_id")
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

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Boolean getDismissed() {
        return dismissed;
    }

    public void setDismissed(Boolean dismissed) {
        this.dismissed = dismissed;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Employee(String name, int accessLevel, String password, String passwordHash, LocalDate registrationDate, LocalDate lastLoginDate, boolean dismissed, Faculty faculty) {
        this.name = name;
        this.accessLevel = accessLevel;
        this.password = password;
        this.passwordHash = passwordHash;
        this.registrationDate = registrationDate;
        this.lastLoginDate = lastLoginDate;
        this.dismissed = dismissed;
        this.faculty = faculty;
    }
}
