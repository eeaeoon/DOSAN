package com.example.dosan.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.example.dosan.service.SendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SendController {
    private final static String MAPPING = "/send/";

    @Autowired
	private SendService service;

    @RequestMapping(value = MAPPING + "{action}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
			ModelAndView modelandView) {
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		String today = (new SimpleDateFormat("yyyyMMdd").format(date));
		Object resultMap = new HashMap<String, Object>();
		
		// divided depending on action value
		if ("edit".equals(action)) {
			resultMap = service.getObject(paramMap);
		} else if ("input".equals(action)) {
		} else if ("update".equals(action)) {
			resultMap = service.updateObject(paramMap);
			action = "read";
		} else if ("insert".equals(action)) {
			paramMap.put("ACCOUNT_NUM", "1111-1111-1111");
			paramMap.put("DATE", today);
			String VALUE = (String) paramMap.get("VALUE");
			Map<String, Object> updateMap = new HashMap<String, Object>();
			updateMap.put("VALUE", VALUE);
			updateMap.put("ACCOUNT_NUM", "1111-1111-1111");
			resultMap = service.updateObject(updateMap);
			resultMap = service.saveObject(paramMap);
			action = "read";
		} else if ("read".equals(action)) {
			resultMap = service.getObject(paramMap);
		} else if ("list".equals(action)) {
			resultMap = service.getList(paramMap);
		} else if ("delete".equals(action)) {
			resultMap = service.deleteObject(paramMap);
			action = "list";
		}

		String viewName = MAPPING + action;

		modelandView.setViewName(viewName);

		modelandView.addObject("paramMap", paramMap);
		modelandView.addObject("resultMap", resultMap);
		return modelandView;
	}
}
