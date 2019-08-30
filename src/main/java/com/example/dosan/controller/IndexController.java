package com.example.dosan.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {

	// @RequestMapping(value = { "/index", "/layout/defaultLayout" }, method =
	// RequestMethod.GET)

	@RequestMapping(value = "/{action}", method = RequestMethod.GET)
	public String actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
			ModelAndView modelandView) {
		if ("login".equals(action) || "sign".equals(action) || "intro".equals(action)) {
			return  action;
		} else if (LoginController.checker) {
			return  action;
		} else
			return "/false";
	}
}
