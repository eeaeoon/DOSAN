
package com.example.dosan.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.dosan.service.ManageService;
import com.example.dosan.service.SendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManageController {

    private final static String MAPPING = "/manage/";

    @Autowired
    private ManageService service;

    @Autowired
    private SendService send_service;

    @Autowired
    private  LoginController loginController;
    /*
    @RequestMapping(value = "manage/input", method = {RequestMethod.GET, RequestMethod.POST})
    public void viewInput(){
    }
*/
    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = MAPPING + "{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {
            if (loginController.checker){
                Object resultMap = new HashMap<String, Object>();
                Object sendMap = new HashMap<String, Object>();
                // divided depending on action value
                if ("edit".equals(action)) {
                    resultMap = service.getObject(paramMap);
                } else if ("update".equals(action)) {
                    resultMap = service.updateObject(paramMap);
                    action = "read";
                } else if ("insert".equals(action)) {
                    resultMap = service.saveObject(paramMap);
                    action = "read";
                } else if ("read".equals(action)) {
                    resultMap = service.getObject(paramMap);
                } else if ("list".equals(action)) {
                    resultMap = service.getList(paramMap);
                    sendMap = send_service.getList(paramMap);
                } else if ("delete".equals(action)) {
                    resultMap = service.deleteObject(paramMap);
                    action = "read";
                }
                String viewName = MAPPING + action;
                modelandView.setViewName(viewName);
                modelandView.addObject("paramMap", paramMap);
                modelandView.addObject("resultMap", resultMap);
                modelandView.addObject("sendMap", sendMap);
        }
        else {
            modelandView.setViewName("/false");
        }
        return modelandView;
    }
}
