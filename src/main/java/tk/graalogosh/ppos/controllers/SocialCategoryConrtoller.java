package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.SocialCategory;
import tk.graalogosh.ppos.dao.repositories.SocialCategoryRepository;
import tk.graalogosh.ppos.dao.specifications.SocialCategorySpecification;

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
    public List<SocialCategory> getSocialCategories(
            @RequestParam(value = "socialCategoryID", required = false) Integer socialCategoryID,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "priority", required = false) Integer priority,
            @RequestParam(value = "point", required = false) Integer point,
            @RequestParam(value = "documents", required = false) String documents,
            @RequestParam(value = "money", required = false) Double money,
            @RequestParam(value = "visible", required = false) Boolean visible

    ){
        SocialCategory example = new SocialCategory();
        example.setSocialCategoryID(socialCategoryID);
        example.setTitle(title);
        example.setPoint(point);
        example.setDocuments(documents);
        example.setMoney(money);
        example.setVisible(visible);

        SocialCategorySpecification specification = new SocialCategorySpecification(example);
        List<SocialCategory> categories = socialCategoryRepository.findAll(specification);
        return categories;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postSocialCategory(
            @RequestBody SocialCategory payload){
        throw new UnsupportedOperationException();
    }
}
