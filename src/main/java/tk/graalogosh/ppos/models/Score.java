package tk.graalogosh.ppos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by graal on 06.08.2015.
 */
@Entity
@Table(name = "score")
public class Score {
    public Score() {
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name = "score_id")
    @JsonIgnore
    private Integer scoreID;

    @Column(name = "min_score")
    private Double minScore;

    @Column(name = "max_score")
    private Double maxScore;

    private Integer point;

    public Integer getScoreID() {
        return scoreID;
    }

    public void setId(Integer scoreID) {
        this.scoreID = scoreID;
    }

    public Double getMinScore() {
        return minScore;
    }

    public void setMinScore(Double minScore) {
        this.minScore = minScore;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Score(Double minScore, Double maxScore, Integer point) {
        this.minScore = minScore;
        this.maxScore = maxScore;
        this.point = point;
    }
}
