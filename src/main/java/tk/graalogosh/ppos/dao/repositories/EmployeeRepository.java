package tk.graalogosh.ppos.dao.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Employee;

import javax.persistence.Table;

/**
 * Created by graal on 05.08.2015.
 */
@Repository
@Table(name = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor {
}
