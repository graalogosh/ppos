package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.SocialWork;
import tk.graalogosh.ppos.models.SocialWorkCategory;
import tk.graalogosh.ppos.repositories.SocialWorkCategoryRepository;
import tk.graalogosh.ppos.repositories.SocialWorkRepository;

import java.util.List;

/**
 * Created by graal on 27.09.2015.
 */
@RestController
@RequestMapping(value = "socialWorkCategory")
public class SocialWorkCategoryController {
    private SocialWorkCategoryRepository socialWorkCategoryRepository;

    @Autowired
    public SocialWorkCategoryController(SocialWorkCategoryRepository socialWorkCategoryRepository) {
        this.socialWorkCategoryRepository = socialWorkCategoryRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<SocialWorkCategory> getSocialWorkCategories() {
        //TODO make search
        return socialWorkCategoryRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postSocialWorkCategory(
            @RequestBody SocialWorkCategory payload) {
          throw new UnsupportedOperationException();
    }
}

