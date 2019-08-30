
package com.example.dosan.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.dosan.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    private final static String MAPPING = "/product/";

    @Autowired
    private ProductService service;

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = MAPPING + "{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {

        Object resultMap1 = new HashMap<String, Object>();

        // divided depending on action value
        if ("edit".equals(action)) {
            resultMap1 = service.getObject(paramMap);
        } else if ("input".equals(action)) {
        } else if ("update".equals(action)) {
            resultMap1 = service.updateObject(paramMap);
            action = "read";
        } else if ("insert".equals(action)) {
            resultMap1 = service.saveObject(paramMap);
            action = "read";
        } else if ("read".equals(action)) {
            resultMap1 = service.getObject(paramMap);
        } else if ("list".equals(action)) {
            resultMap1 = service.getList(paramMap);
        } else if ("delete".equals(action)) {
            resultMap1 = service.deleteObject(paramMap);
            action = "list";
        }

        String viewName = MAPPING + action;

        modelandView.setViewName(viewName);

        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("resultMap1", resultMap1);
        return modelandView;
    }
}
