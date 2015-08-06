package tk.graalogosh.ppos.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by graalogosh on 03.08.2015.
 */
@Entity
@Table(name="student")
public class Student {
    public Student() {
    }

    @Id
    @Column(name = "student_id")
    private String studentID;

    @Column(name = "name")
    private String name;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "educational_group")
    private String educationalGroup;

    @ManyToOne
    @JoinColumn(name = "academic_status")
    private Status academicStatus;

    @ManyToOne
    @JoinColumn(name = "financial_status")
   // @Column(name = "financial_status")
    private Status financialStatus;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "phone")
    private String phone;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "student_paid")
    private int studentPaid;

    @Column(name = "student_must_pay")
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

    public Status getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(Status academicStatus) {
        this.academicStatus = academicStatus;
    }

    public Status getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(Status financialStatus) {
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

    public Student(String studentID, String name, Date entryDate, String educationalGroup, Status academicStatus, Status financialStatus, String faculty, String phone, String bankAccountNumber, int studentPaid, int studentMustPay) {
        this.studentID = studentID;
        this.name = name;
        this.entryDate = entryDate;
        this.educationalGroup = educationalGroup;
        this.academicStatus = academicStatus;
        this.financialStatus = financialStatus;
        this.faculty = faculty;
        this.phone = phone;
        this.bankAccountNumber = bankAccountNumber;
        this.studentPaid = studentPaid;
        this.studentMustPay = studentMustPay;
    }
}
