package com.travel.dit.springwebpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	@GetMapping("/")
	String home() {
		return "Hello world!";
	}
}
