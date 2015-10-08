package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.SocialWork;
import tk.graalogosh.ppos.repositories.SocialWorkRepository;

import java.util.List;

/**
 * Created by graal on 27.09.2015.
 */
@RestController
@RequestMapping(value = "socialWork")
public class SocialWorkController {
    private SocialWorkRepository socialWorkRepository;

    @Autowired
    public SocialWorkController(SocialWorkRepository socialWorkRepository) {
        this.socialWorkRepository = socialWorkRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<SocialWork> getSocialWorks() {
        //TODO make search
        return socialWorkRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postSocialWork(
            @RequestBody SocialWork payload) {
          throw new UnsupportedOperationException();
    }
}

