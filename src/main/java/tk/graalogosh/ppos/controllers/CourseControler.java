package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tk.graalogosh.ppos.models.Course;
import tk.graalogosh.ppos.repositories.CourseRepository;

import java.util.List;

/**
 * Created by graal on 09.10.2015.
 */
@RestController
@RequestMapping(value = "course")
public class CourseControler {
    private CourseRepository courseRepository;

    @Autowired
    public CourseControler(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postCourse(
            @RequestBody Course payload){
        throw new NotImplementedException();
    }
}
