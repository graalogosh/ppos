package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.SocialCategory;
import tk.graalogosh.ppos.repositories.SocialCategoryRepository;

import java.util.List;

/**
 * Created by graal on 09.10.2015.
 */
@RestController
@RequestMapping("socialCategory")
public class SocialCategoryConrtoller {
    private SocialCategoryRepository socialCategoryRepository;

    @Autowired
    public SocialCategoryConrtoller(SocialCategoryRepository socialCategoryRepository) {
        this.socialCategoryRepository = socialCategoryRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SocialCategory> getSocialCategories(){
        return socialCategoryRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postSocialCategory(
            @RequestBody SocialCategory payload){
        throw new UnsupportedOperationException();
    }
}
