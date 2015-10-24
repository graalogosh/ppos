package tk.graalogosh.ppos.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Faculty;

import javax.persistence.Table;

/**
 * Created by graal on 22.09.2015.
 */
@Repository
@Table(name = "faculty")
public interface FacultyRepository extends JpaRepository<Faculty, String>{
}
