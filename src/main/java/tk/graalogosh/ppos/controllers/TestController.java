package tk.graalogosh.ppos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 03.03.2016.
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    String runTestFunc(
            @RequestParam(value = "test", required = true) String test
    ){
        StringBuilder response = new StringBuilder();
        switch (test){
            case "gc":
                response.append("Start GC test \n Before: \n");
                response.append(Runtime.getRuntime().freeMemory());

                System.gc();

                response.append("\n After: \n");
                response.append(Runtime.getRuntime().freeMemory());
                response.append("\n Finist GC test");
                return response.toString();
            default:
                return "No test was run";
        }
    }
}
