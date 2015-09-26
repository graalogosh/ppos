package tk.graalogosh.ppos.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Employee;
import tk.graalogosh.ppos.models.SocialWork;

import javax.persistence.Table;

/**
 * Created by graal on 05.08.2015.
 */
@Repository
@Table(name = "socialwork")
public interface SocialWorkRepository extends JpaRepository<SocialWork, Integer>{
}
