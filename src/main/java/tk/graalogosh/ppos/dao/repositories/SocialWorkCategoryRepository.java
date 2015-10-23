package tk.graalogosh.ppos.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.SocialWorkCategory;

import javax.persistence.Table;

/**
 * Created by graal on 21.09.2015.
 */
@Repository
@Table(name="socialworkcategory")
public interface SocialWorkCategoryRepository extends JpaRepository<SocialWorkCategory, Integer>, JpaSpecificationExecutor {
}
