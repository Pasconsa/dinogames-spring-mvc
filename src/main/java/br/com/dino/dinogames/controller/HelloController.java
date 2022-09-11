package br.com.dino.dinogames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller       //anotação controle do spring
public class HelloController {
	
	@GetMapping("/hello")   //Métodos que atendem requisições HTTP são chamados de action
	public String hello(Model model) {            //Em vez de utilizar o http servlet usa a camada Model para requisição que faz parte do spring
		model.addAttribute("nome", "Mundo");      // atributo nome com parametro Mundo que sera demontstrado no html hello pelo thymeleaf
		return "hello"; 
	}
}
