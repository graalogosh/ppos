package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.SocialWorkCategory;
import tk.graalogosh.ppos.dao.repositories.SocialWorkCategoryRepository;
import tk.graalogosh.ppos.dao.specifications.SocialWorkCategorySpecification;

import java.util.List;

/**
 * Created by graal on 27.09.2015.
 */
@RestController
@RequestMapping(value = "/api/socialWorkCategory")
public class SocialWorkCategoryController {
    private SocialWorkCategoryRepository socialWorkCategoryRepository;

    @Autowired
    public SocialWorkCategoryController(SocialWorkCategoryRepository socialWorkCategoryRepository) {
        this.socialWorkCategoryRepository = socialWorkCategoryRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<SocialWorkCategory> getSocialWorkCategories(
            @RequestParam(value = "socialWorkCategoryID", required = false) Integer socialWorkCategoryID,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "visible", required = false)Boolean visible) {

        SocialWorkCategory example = new SocialWorkCategory();
        example.setSocialWorkCategoryID(socialWorkCategoryID);
        example.setTitle(title);
        example.setVisible(visible);

        SocialWorkCategorySpecification specification = new SocialWorkCategorySpecification(example);
        List<SocialWorkCategory> categories = socialWorkCategoryRepository.findAll(specification);
        return categories;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postSocialWorkCategory(
            @RequestBody SocialWorkCategory payload) {
          throw new UnsupportedOperationException();
    }
}

