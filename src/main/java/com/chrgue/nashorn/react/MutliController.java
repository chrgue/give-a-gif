package com.chrgue.nashorn.react;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chrgue.nashorn.service.FakeService;

@Controller
public class MutliController {
	
	private static final String DEFAULT_COUNT = "10";
	
	@Autowired
	private FakeService service;
	
	@Autowired
	private ReactService reactService;
	
	
	@GetMapping(path="/users",  produces = "application/json")
	@ResponseBody
	public List<String> getIds(@RequestParam(defaultValue=DEFAULT_COUNT) int count) {
		return service.createUuids(count);
	}
	
	@GetMapping("/users")
	public String getIdsHtml(@RequestParam(defaultValue=DEFAULT_COUNT) int count, Model model) {
		List<String> users = service.createUuids(count);
		
		
		model.addAttribute("title", "React example");
		model.addAttribute("users", users);
		model.addAttribute("content", reactService.renderUserBox(users));
		
		return "index";
		
	}
}
