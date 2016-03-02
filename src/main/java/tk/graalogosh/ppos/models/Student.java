package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import tk.graalogosh.ppos.utils.LocalDateDeserializer;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graalogosh on 03.08.2015.
 */
@Data
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
    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate entryDate;

    @Column(name = "educational_group")
    private String educationalGroup;

    @ManyToOne
    @JoinColumn(name = "academic_status")
    private Status academicStatus;

    @ManyToOne
    @JoinColumn(name = "financial_status")
    private Status financialStatus;

    @ManyToOne
    @JoinColumn(name = "faculty")
    private Faculty faculty;

    @Column(name = "phone")
    private String phone;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "student_paid")
    private Integer studentPaid;

    @Column(name = "student_must_pay")
    private Integer studentMustPay;

    public Integer getCourse(){
        return Character.getNumericValue(educationalGroup.charAt(0));
    }
}
