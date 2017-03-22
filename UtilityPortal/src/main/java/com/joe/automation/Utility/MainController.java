package com.joe.automation.Utility;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.servlets.FilePathBuilder;
import com.servlets.Upload;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/AutomationUtilityPortal")
public class MainController {

	@RequestMapping(value = {
	        "/"
	}, method = {
	        RequestMethod.GET
	})
	public ModelAndView home1(Map<String, Object> model) {
		return new ModelAndView("AutomationHome");

	}

	@RequestMapping(value = {
	        ""
	}, method = {
	        RequestMethod.GET
	})
	public ModelAndView home2(Map<String, Object> model) {
		return home1(model);
	}

	@RequestMapping(value = "fileChooser", method = {
	        RequestMethod.GET
	})
	public String fileChooser(Map<String, Object> model) {
		return "sub/fileChooser";
	}

	@RequestMapping(value = "FilePathBuilder", method = {
	        RequestMethod.POST
	})
	public void fileEditor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		FilePathBuilder.getInstance().doPost(request, response);
	}

	@RequestMapping(value = "JsonFileEditor", method = {
	        RequestMethod.GET, RequestMethod.POST
	})
	public String openJsonEditor(HttpServletRequest request, HttpServletResponse response) {
		return "sub/JsonFileEditor";
	}

	@RequestMapping(value = "Upload", method = {
	        RequestMethod.POST
	})
	public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Upload.getInstance().doPost(request, response);
	}

}