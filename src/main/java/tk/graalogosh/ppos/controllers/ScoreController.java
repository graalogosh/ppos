package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.Score;
import tk.graalogosh.ppos.repositories.ScoreRepository;

import java.util.List;

/**
 * Created by graal on 09.10.2015.
 */
@RestController
@RequestMapping(value = "score")
public class ScoreController {
    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Score getScore(
            @RequestParam (value = "score", required = true) Double score){
        List<Score> scores = scoreRepository.findAll();

        //TODO move to Repository custom methods
        for (Score curLine:scores){
            if (curLine.getMinScore()<=score && curLine.getMaxScore()>=score){
                return curLine;
            }
        }
        return null;
    }
}
