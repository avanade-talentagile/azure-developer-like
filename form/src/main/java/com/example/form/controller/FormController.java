package com.example.form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.form.model.Form;
import com.example.form.model.UserFeedback;
import com.example.form.repository.UserFeedbackRepository;
import com.example.form.service.FileService;

@Controller
public class FormController {

	@Value("${app.title}")
	private String appTitle;

	@Autowired
	UserFeedbackRepository repository;
	@Autowired
	FileService fileService;

	@GetMapping("/")
	public String greetingForm(Model model, OAuth2AuthenticationToken auth) {
		Iterable<UserFeedback> feedbacks = repository.findAll();

		model.addAttribute("form", new Form());
		model.addAttribute("appTitle", appTitle);
		model.addAttribute("userName", auth.getName());
		model.addAttribute("feedbacks", feedbacks);
		model.addAttribute("message", null);
		return "form";
	}

	@PostMapping("/save")
	public String saveForm(@ModelAttribute Form form, @RequestParam("file") MultipartFile file, Model model, OAuth2AuthenticationToken auth) {
		try {

			OAuth2User principal = auth.getPrincipal();
			String userId = principal.getAttribute("oid");
			model.addAttribute("appTitle", appTitle);
			model.addAttribute("userName", auth.getName());

			if (form.getTitle() == null || form.getTitle().isEmpty() || 
				form.getComment() == null || form.getComment().isEmpty() ||
				file.isEmpty()) {
				model.addAttribute("form", form);
				model.addAttribute("message", "Invalid form");

				Iterable<UserFeedback> feedbacks = repository.findAll();
				model.addAttribute("feedbacks", feedbacks);
				return "form";
			} else {
				model.addAttribute("form", new Form());
				model.addAttribute("message", null);
			}

			UserFeedback userFeedback = this.map(form, userId);
			String fileUrl = fileService.uploadFile(file, "raw-images", userFeedback.getId());
			userFeedback.setUrl(fileUrl);

			repository.save(userFeedback);
			Iterable<UserFeedback> feedbacks = repository.findAll();
			model.addAttribute("feedbacks", feedbacks);
		} catch (Exception ex) {
			model.addAttribute("message", "Failed to save feedback");
		}

		return "form";
	}

	private UserFeedback map(Form form, String userId) {
		return new UserFeedback(userId, form.getTitle(), form.getComment());
	}
}
