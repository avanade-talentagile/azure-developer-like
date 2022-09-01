package com.example.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.model.Form;

@Controller
public class FormController {
	
	@GetMapping("/")
	 public String greetingForm(Model model) {
	    model.addAttribute("form", new Form());
	    return "form";
	  }
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute Form form, Model model) {
		model.addAttribute("form",form);
		return "form";
	}

		
	
		  
	 

}
