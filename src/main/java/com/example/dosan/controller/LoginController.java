package com.example.dosan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
    private final static String MAPPING = "/login";
    public static Boolean checker = false ;
    @RequestMapping(value = MAPPING + "/" +"{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap,
                                     @PathVariable String action, ModelAndView modelandView){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = (Map<String, Object>) paramMap;
        modelandView.setViewName(MAPPING);
        modelandView.addObject("resultMap", resultMap);
        checker = true;
        return modelandView;
    }
}