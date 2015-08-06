package tk.graalogosh.ppos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.graalogosh.ppos.models.Statement;
import tk.graalogosh.ppos.models.Student;
import tk.graalogosh.ppos.repositories.StatementRepository;
import tk.graalogosh.ppos.repositories.StudentRepository;

import javax.swing.plaf.nimbus.State;

/**
 * Created by graal on 05.08.2015.
 */
@RestController
public class StatementController {
    private StatementRepository statementRepository;

    @Autowired
    public StatementController(StatementRepository statementRepository){
        this.statementRepository = statementRepository;
    }

    @RequestMapping("statement")
    public Statement getStudent(@RequestParam("statementID") Integer statementID){
        Statement statement = statementRepository.findOne(statementID);
       // System.out.println(student);
        return statement;
    }
}
