package tk.graalogosh.ppos.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by graal on 05.08.2015.
 */
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private Integer employeeID;

    @Column(name = "name")
    private String name;
    @Column(name = "access_level")
    private int accessLevel;
    @Column(name = "password")
    private String password;
    @Column(name = "hash")
    private String passwordHash;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "last_login_date")
    private Date lastLoginDate;
    @Column(name = "dismissed")
    private boolean dismissed;
    @Column(name = "faculty")
    private String faculty;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public boolean isDismissed() {
        return dismissed;
    }

    public void setDismissed(boolean dismissed) {
        this.dismissed = dismissed;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Employee(String name, int accessLevel, String password, String passwordHash, Date registrationDate, Date lastLoginDate, boolean dismissed, String faculty) {
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
