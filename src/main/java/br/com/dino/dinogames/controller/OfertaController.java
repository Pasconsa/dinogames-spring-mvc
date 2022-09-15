package br.com.dino.dinogames.controller;  //11.1 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")    //12.1 recebe requisição da /oferta
public class OfertaController {

	@GetMapping
	public String getFormularioParaOfertas() {  //redireciona direto para view apresenta html
		return "oferta/home";
	}
}
