package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.Faculty;
import tk.graalogosh.ppos.dao.repositories.FacultyRepository;

import java.util.List;

/**
 * Created by graal on 08.10.2015.
 */
@RestController
@RequestMapping(value = "faculty")
public class FacultyController {
    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Faculty> getFaculties(){
        return facultyRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postFaculty(
            @RequestBody Faculty payload){
        throw new UnsupportedOperationException();
    }
}
