package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.repositories.SectionRepository;

import java.util.List;

/**
 * Created by graal on 27.09.2015.
 */
@RestController
@RequestMapping(value = "section")
public class SectionController {
    private SectionRepository sectionRepository;

    @Autowired
    public SectionController(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Section> getSections(

    ){
        //TODO make search
        return sectionRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postSection(
            @RequestBody Section payload){
        throw new NotImplementedException();
    }
}
