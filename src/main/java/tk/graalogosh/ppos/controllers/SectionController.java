package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.repositories.SectionRepository;
import tk.graalogosh.ppos.specifications.SectionSpecification;

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
            @RequestParam(value = "sectionID", required = false) Integer sectionID,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "socialGrant", required = false) Boolean socialGrant,
            @RequestParam(value = "socialCategory", required = false) Boolean socialCategory,
            @RequestParam(value = "socialWork", required = false) Boolean socialWork,
            @RequestParam(value = "averageScore", required = false) Boolean averageScore,
            @RequestParam(value = "tripCount", required = false) Boolean tripCount,
            @RequestParam(value = "refusualCount", required = false) Boolean refusualCount,
            @RequestParam(value = "course", required = false) Boolean course,
            @RequestParam(value = "pointSum", required = false) Boolean pointSum,
            @RequestParam(value = "bankAccountNumber", required = false) Boolean bankAccountNumber,
            @RequestParam(value = "list", required = false) Boolean list,
            @RequestParam(value = "retrip", required = false) Boolean retrip,
            @RequestParam(value = "moneyCategory", required = false) Boolean moneyCategory){

        Section example = new Section();
        example.setSectionID(sectionID);
        example.setTitle(title);
        example.setSocialGrant(socialGrant);
        example.setSocialCategory(socialCategory);
        example.setSocialWork(socialWork);
        example.setAverageScore(averageScore);
        example.setTripCount(tripCount);
        example.setRefusualCount(refusualCount);
        example.setCourse(course);
        example.setPointSum(pointSum);
        example.setBankAccountNumber(bankAccountNumber);
        example.setList(list);
        example.setRetrip(retrip);
        example.setMoneyCategory(moneyCategory);

        SectionSpecification specification = new SectionSpecification(example);
        List<Section> sections = sectionRepository.findAll(specification);
        return sections;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postSection(
            @RequestBody Section payload){
        throw new UnsupportedOperationException();
    }
}
