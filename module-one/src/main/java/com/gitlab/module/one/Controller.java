package com.gitlab.module.one;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")
    public String index() {
        return "Greetings Gitlab CI/CD from module-one!";
    }

}
