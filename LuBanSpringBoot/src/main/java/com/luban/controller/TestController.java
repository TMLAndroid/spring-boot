package com.luban.controller;

import com.luban.properties.Student;
import com.luban.properties.TestYmlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@Autowired
	Student student;

	@Autowired
	TestYmlProperties testYmlProperties;

	@RequestMapping("/hello")
	@ResponseBody
	public String test(){
		System.out.println(student.toString());
		System.out.println(testYmlProperties.toString());
		return "hello world ";
	}
}
