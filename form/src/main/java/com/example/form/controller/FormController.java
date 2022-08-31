package com.example.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.model.Formulaire;

@Controller
public class FormController {
	
	@GetMapping("/formulaire")
	 public String greetingForm(Model model) {
	    model.addAttribute("formu", new Formulaire());
	    return "formulaire";
	  }

		
	
		  
	 

}
