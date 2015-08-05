package tk.graalogosh.ppos.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by graalogosh on 03.08.2015.
 */
@Entity
@Table(name="student")
public class Student {

//    @Version
//    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StudentID")
    private String studentID;

    @Column(name = "Name")
    private String name;

    @Column(name = "EntryDate")
    private Date entryDate;

    @Column(name = "EducationalGroup")
    private String educationalGroup;

    @Column(name = "AcademicStatus")
    private int academicStatus;

    @Column(name = "FinancialStatus")
    private int financialStatus;

    @Column(name = "Faculty")
    private String faculty;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "BankAccountNumber")
    private String bankAccountNumber;

    @Column(name = "StudentPaid")
    private int studentPaid;

    @Column(name = "StudentMustPay")
    private int studentMustPay;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getEducationalGroup() {
        return educationalGroup;
    }

    public void setEducationalGroup(String educationalGroup) {
        this.educationalGroup = educationalGroup;
    }

    public int getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(int academicStatus) {
        this.academicStatus = academicStatus;
    }

    public int getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(int financialStatus) {
        this.financialStatus = financialStatus;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getStudentPaid() {
        return studentPaid;
    }

    public void setStudentPaid(int studentPaid) {
        this.studentPaid = studentPaid;
    }

    public int getStudentMustPay() {
        return studentMustPay;
    }

    public void setStudentMustPay(int studentMustPay) {
        this.studentMustPay = studentMustPay;
    }
}
