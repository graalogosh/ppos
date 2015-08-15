package tk.graalogosh.ppos.dao;

import tk.graalogosh.ppos.models.Student;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by graal on 12.08.2015.
 */
public interface StudentDAO {
    List<Student> getStudents(
            String studentID,
            String name,
            LocalDate entryDate,
            String educationalGroup,
            String academicStatus,//TODO status
            String financialStatus,//TODO status
            String faculty,
            String phone,
            String bankAccountNumber,
            int studentPaid,
            int studentMustPay
    );

    Student addStudent(
            String studentID,
            String name,
            LocalDate entryDate,
            String educationalGroup,
            String academicStatus,//TODO status
            String financialStatus,//TODO status
            String faculty,
            String phone,
            String bankAccountNumber,
            int studentPaid,
            int studentMustPay
    );

    Student updateStudent(
            String studentID,
            String name,
            LocalDate entryDate,
            String educationalGroup,
            String academicStatus,//TODO status
            String financialStatus,//TODO status
            String faculty,
            String phone,
            String bankAccountNumber,
            int studentPaid,
            int studentMustPay
    );

    boolean deleteStudent(final String studentID);
}
