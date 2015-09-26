package tk.graalogosh.ppos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Status;
import tk.graalogosh.ppos.models.TypeList;

import javax.persistence.Table;

/**
 * Created by graal on 21.09.2015.
 */
@Repository
@Table(name="typelist")
public interface TypeListRepository extends JpaRepository<TypeList, Integer> {
}
