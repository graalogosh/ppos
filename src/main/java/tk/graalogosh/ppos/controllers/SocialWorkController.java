package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.SocialWork;
import tk.graalogosh.ppos.dao.repositories.SocialWorkCategoryRepository;
import tk.graalogosh.ppos.dao.repositories.SocialWorkRepository;
import tk.graalogosh.ppos.dao.specifications.SocialWorkSpecification;

import java.util.List;

/**
 * Created by graal on 27.09.2015.
 */
@RestController
@RequestMapping(value = "socialWork")
public class SocialWorkController {
    private SocialWorkRepository socialWorkRepository;
    private SocialWorkCategoryRepository socialWorkCategoryRepository;

    @Autowired
    public SocialWorkController(SocialWorkRepository socialWorkRepository,
                                SocialWorkCategoryRepository socialWorkCategoryRepository) {
        this.socialWorkRepository = socialWorkRepository;
        this.socialWorkCategoryRepository = socialWorkCategoryRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<SocialWork> getSocialWorks(
            @RequestParam(value = "socialWorkID", required = false) Integer socialWorkID,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "point", required = false) Integer point,
            @RequestParam(value = "socialWorkCategoryID", required = false) Integer socialWorkCategoryID,
            @RequestParam(value = "visible", required = false) Boolean visible) {

        SocialWork example = new SocialWork();
        example.setSocialWorkID(socialWorkID);
        example.setTitle(title);
        example.setPoint(point);
        example.setSocialWorkCategory(socialWorkCategoryID != null ? socialWorkCategoryRepository.findOne(socialWorkCategoryID) : null);
        example.setVisible(visible);

        SocialWorkSpecification specification = new SocialWorkSpecification(example);
        List<SocialWork> socialWorks = socialWorkRepository.findAll(specification);
        return socialWorks;

    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postSocialWork(
            @RequestBody SocialWork payload) {
        throw new UnsupportedOperationException();
    }
}

