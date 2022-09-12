package br.com.dino.dinogames.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.dino.dinogames.model.Pedido;
import br.com.dino.dinogames.repository.PedidoRepository;

@Controller
public class HomeController {  //Home controller depende de Pedido , Pedido Repository e anotações acima
	
	@Autowired //serve para você pedir para o Spring – “eu quero uma instância de ‘PedidoRepository’! 
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);        //passamos valores, variáveis para a “view” utilizando o “model”, aquela interface do Spring? não precisamos colocar como atributo do “HttpServeltRequest”. Nós colocamos como “addAttribute(“pedidos”, pedidos”)”.
		
		return "home"; 
	}
}
