package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tk.graalogosh.ppos.utils.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by graal on 06.08.2015.
 */
@Data
@Entity
@Table(name = "list")
public class StatementList {
    public StatementList() {
    }

    @Id
    @GeneratedValue
    @Column(name = "list_id")
    private Integer listID;

    @Column(name = "transfer_date")
    @Convert(converter = LocalDatePersistenceConverter.class)
    @JsonIgnoreProperties(value = {"dayOfWeek", "era", "dayOfYear", "leapYear", "chronology"})
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "type")
    private TypeList type;

    @Column(name = "count_statement")
    private Integer countStatement;

    @ManyToOne
    @JoinColumn(name = "faculty")
    private Faculty faculty;
}
