package com.gitlab.module.two;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")
    public String index() {
        return "Greetings Gitlab CI/CD from module-two!";
    }

}
