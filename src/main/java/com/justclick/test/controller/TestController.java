package com.justclick.test.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.justclick.test.model.Url;
import com.justclick.test.service.UrlServices;
/**
 * *********************************************************************************************************
 * Name: UrlServices 
 * Description:Service that redirect url whith string parameter entered
 * *********************************************************************************************************
 */
@Controller
public class TestController {
	@Autowired
	private UrlServices urlService;

	@GetMapping("/link/{string}")
	public @ResponseBody ModelAndView home(@PathVariable String string, Model model,
			@CookieValue(value = "currentValue", defaultValue = "0") Integer currentValue,
			@CookieValue(value = "userInfo", defaultValue = "") String userInfo,
			@RequestHeader HttpHeaders headersValues, HttpServletResponse response) {
		Cookie currentValueCookie;
		Url url = urlService.findByName(string);

		if (url != null) {

			currentValue++;
			currentValueCookie = new Cookie("currentValue", Integer.toString(currentValue));
			response.addCookie(currentValueCookie);

			if (currentValue < url.getAttempt()) {
				urlService.loggerRequest(headersValues, response, url.getUri(), string);
				return new ModelAndView("redirect:" + url.getUri());

			} else {
				urlService.loggerRequest(headersValues, response, "404", string);
				return new ModelAndView("redirect:/404");

			}

		} else {
			urlService.loggerRequest(headersValues, response, "404", string);
			return new ModelAndView("redirect:/404");

		}

	}

}
