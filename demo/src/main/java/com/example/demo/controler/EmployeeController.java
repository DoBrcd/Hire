package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	public String ViewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
	return "index";
	}

}
