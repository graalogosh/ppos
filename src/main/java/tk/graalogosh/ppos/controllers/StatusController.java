package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.Status;
import tk.graalogosh.ppos.repositories.StatusRepository;

import java.util.List;

/**
 * Created by graal on 09.10.2015.
 */
@RestController
@RequestMapping(value = "status")
public class StatusController {
    private StatusRepository statusRepository;

    @Autowired
    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Status> getStatuses(){
        return statusRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postStatus(
            @RequestBody Status body){
        throw new UnsupportedOperationException();
    }
}
