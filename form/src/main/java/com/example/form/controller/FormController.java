package com.example.form.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.model.Form;

@Controller
public class FormController {
	
	@Value("${app.title}")
	private String appTitle;
	
	@GetMapping("/")
	 public String greetingForm(Model model) {
	    model.addAttribute("form", new Form());
	    model.addAttribute("appTitle", appTitle);
	    return "form";
	  }
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute Form form, Model model) {
		model.addAttribute("form",form);
		model.addAttribute("appTitle", appTitle);
		return "form";
	}

		
	
		  
	 

}
