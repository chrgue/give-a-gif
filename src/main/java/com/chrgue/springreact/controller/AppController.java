package com.chrgue.springreact.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chrgue.springreact.model.Post;
import com.chrgue.springreact.repository.PostRepository;

@Controller
public class AppController {

	@Autowired
	private PostRepository repository;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "React example");
		model.addAttribute("posts", repository.findAll().collect(Collectors.toList()));
		return "index";
	}
}
