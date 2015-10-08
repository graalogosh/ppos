package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tk.graalogosh.ppos.models.Refusal;
import tk.graalogosh.ppos.repositories.RefusalRepository;

import java.util.List;

/**
 * Created by graal on 08.10.2015.
 */
@RestController
@RequestMapping(value = "refusal")
public class RefusalController {
    private RefusalRepository refusalRepository;

    @Autowired
    public RefusalController(RefusalRepository refusalRepository) {
        this.refusalRepository = refusalRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Refusal> getRefusals(){
        return refusalRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postRefusal(
            @RequestBody Refusal payload){
        throw new NotImplementedException();
    }
}
