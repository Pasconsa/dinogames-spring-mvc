package br.com.dino.dinogames.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dino.dinogames.model.Pedido;
import br.com.dino.dinogames.model.StatusPedido;
import br.com.dino.dinogames.repository.PedidoRepository;

@Controller
@RequestMapping("/home")  //07 todas requisições home vai bater aqui e distribuir nas debaixo
public class HomeController {  //Home controller depende de Pedido , Pedido Repository e anotações acima
	
	@Autowired //serve para você pedir para o Spring – “eu quero uma instância de ‘PedidoRepository’! 
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);        //passamos valores, variáveis para a “view” utilizando o “model”, aquela interface do Spring? não precisamos colocar como atributo do “HttpServeltRequest”. Nós colocamos como “addAttribute(“pedidos”, pedidos”)”.
		return "home"; 
	}
	
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase())); 	//07 para listar somente pedidos que esta aguradando, declarar esse metodo na interface pedido.repository
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home"; 
		
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class) // 07 quando apresentar um erro no na lista volta a pagina home
	public String onError() {
		return "redirect:/home";
	}
}
