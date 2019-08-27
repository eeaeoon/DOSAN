package com.example.dosan.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ByPassController {
    @RequestMapping(value = "/layout/thymeleafBase", method = RequestMethod.GET)
    public void action() {

    }
}