package com.tutorialspoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutorialspoint.Student;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/test")
	public String home(ModelMap model) {
		return "index";
	}

	@RequestMapping(method=RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		model.addAttribute("newStudent", new Student());
		model.addAttribute("student", new Student());
		return "hello";
	}

	@RequestMapping(method=RequestMethod.POST, value="/addStudent")
	public ModelAndView addStudent(@RequestParam("studentName") String studentName, ModelMap model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");

		mav.addObject("studentName", studentName);
		return mav;
	}

	@RequestMapping(method=RequestMethod.POST, value="/addStudentSpringForm")
	public ModelAndView addStudentSpring(@ModelAttribute("student") Student student) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("student", student);
		return mav;
	}
}
