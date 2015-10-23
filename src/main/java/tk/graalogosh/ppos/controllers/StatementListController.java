package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.StatementList;
import tk.graalogosh.ppos.dao.repositories.StatementListRepository;

import java.util.List;

/**
 * Created by graal on 09.10.2015.
 */
@RestController
@RequestMapping(value = "statementList")
public class StatementListController {
    private StatementListRepository statementListRepository;

    @Autowired
    public StatementListController(StatementListRepository statementListRepository) {
        this.statementListRepository = statementListRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<StatementList> getStatementLists(){
        return statementListRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean postStatementList(
           @RequestBody StatementList payload){
        throw new UnsupportedOperationException();
    }
}
