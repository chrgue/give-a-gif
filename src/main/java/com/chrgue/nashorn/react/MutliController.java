package com.chrgue.nashorn.react;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chrgue.nashorn.service.FakeService;

@Controller
public class MutliController {
	
	@Autowired
	private FakeService service;
	
	@GetMapping("/users")
	@ResponseBody
	public List<String> getIds(@RequestParam(defaultValue="10") int count) {
		return service.createUuids(count);
	}
}
