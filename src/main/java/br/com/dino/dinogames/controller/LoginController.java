package br.com.dino.dinogames.controller;                    

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {                 //08 objetivo mostrar a tela de login

	@GetMapping
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
