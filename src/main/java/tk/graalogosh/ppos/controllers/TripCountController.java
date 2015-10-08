package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.TripCount;
import tk.graalogosh.ppos.repositories.TripCountRepository;

import java.util.List;

/**
 * Created by graal on 09.10.2015.
 */
@RestController
@RequestMapping(value = "tripCount")
public class TripCountController {
    private TripCountRepository tripCountRepository;

    @Autowired
    public TripCountController(TripCountRepository tripCountRepository) {
        this.tripCountRepository = tripCountRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<TripCount> getTripCounts(){
        return tripCountRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postTripCount(
            @RequestBody TripCount payload){
        throw new UnsupportedOperationException();
    }
}
