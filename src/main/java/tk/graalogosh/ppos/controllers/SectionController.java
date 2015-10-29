package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.graalogosh.ppos.models.Section;
import tk.graalogosh.ppos.dao.repositories.SectionRepository;
import tk.graalogosh.ppos.dao.specifications.SectionSpecification;

import java.util.List;

/**
 * Контроллер для обработки видов мероприятий
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 27.09.2015.
 */
@RestController
@RequestMapping(value = "section")
public class SectionController {
    private SectionRepository sectionRepository;

    @Autowired
    public SectionController(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    /**
     *
     * @param sectionID идентификатор вида мероприятия
     * @param title название мероприятия
     * @param socialGrant требуется ли социальная стимендия
     * @param socialCategory требуется ли социальная категория
     * @param socialWork требуется ли социальная работа
     * @param averageScore учитывается ли средний академический балл
     * @param tripCount учитывается ли общее число поездок
     * @param refusualCount учитывается ли число отказов
     * @param course учитывается ли курс
     * @param pointSum учитывается ли сумма баллов
     * @param bankAccountNumber проверяется ли наличие в базе номера бансковского счета
     * @param list требуется ли отправка ведомости по мероприятию
     * @param reTrip проверяется ли повторная поездка
     * @param moneyCategory выдаются ли деньги
     * @return List(Section) - список видов мероприятий, подходящих под описание
     */
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
            @RequestParam(value = "reTrip", required = false) Boolean reTrip,
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
        example.setRetrip(reTrip);
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
