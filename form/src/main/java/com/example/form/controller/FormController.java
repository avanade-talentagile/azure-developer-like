package com.example.form.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.model.Form;
import com.example.form.model.UserFeedback;

@Controller
public class FormController {
	
	@Value("${app.title}")
	private String appTitle;

	// @Autowired
	// UserFeedbackRepository repository;
	
	
	@GetMapping("/")
	 public String greetingForm(Model model, OAuth2AuthenticationToken auth) {
	    model.addAttribute("form", new Form());
	    model.addAttribute("appTitle", appTitle);
	    model.addAttribute("userName", auth.getName());
	    return "form";
	  }
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute Form form, Model model, OAuth2AuthenticationToken auth) {
		OAuth2User principal = auth.getPrincipal();
		String userId =  principal.getAttribute("oid");
		UserFeedback userFeedback = this.map(form, userId);
		
		model.addAttribute("form",form);
		model.addAttribute("appTitle", appTitle);
		model.addAttribute("userName", auth.getName());
		return "form";
	}

	private UserFeedback map(Form form, String userId){
		return new UserFeedback(userId, form.getTitle(), form.getComment());
	}

}
