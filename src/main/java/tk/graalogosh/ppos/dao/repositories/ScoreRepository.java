package tk.graalogosh.ppos.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.graalogosh.ppos.models.Score;

import javax.persistence.Table;

/**
 * Created by graal on 22.09.2015.
 */
@Repository
@Table(name = "score")
public interface ScoreRepository extends JpaRepository<Score, Integer>{
    //TODO findByScore
}
