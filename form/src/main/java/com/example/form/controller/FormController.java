package com.example.form.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.model.Form;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FormController {
	
	
	
	
	
	@Value("${app.title}")
	private String appTitle;
	
	
	@GetMapping("/")
	 public String greetingForm(Model model, OAuth2AuthenticationToken auth) {
	    model.addAttribute("form", new Form());
	    model.addAttribute("appTitle", appTitle);
	    model.addAttribute("userName", auth.getName());
	    return "form";
	  }
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute Form form, Model model, OAuth2AuthenticationToken auth) {
		model.addAttribute("form",form);
		model.addAttribute("appTitle", appTitle);
		model.addAttribute("userName", auth.getName());
		return "form";
	}
	
	
	

		
	
		  
	 

}
