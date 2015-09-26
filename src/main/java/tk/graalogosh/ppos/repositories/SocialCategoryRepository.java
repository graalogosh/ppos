package tk.graalogosh.ppos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Course;
import tk.graalogosh.ppos.models.SocialCategory;

import javax.persistence.Table;

/**
 * Created by graal on 22.09.2015.
 */
@Repository
@Table(name = "socialcategory")
public interface SocialCategoryRepository extends JpaRepository<SocialCategory, Integer>{
}
