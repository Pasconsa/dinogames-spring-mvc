package br.com.dino.dinogames.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.dino.dinogames.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();     //Instancia da classe pedido
		pedido.setNomeProduto("Nintendo GameCube Panasonic Q System [JAPAN]");
		pedido.setUrlImagem("https://cdn11.bigcommerce.com/s-kzjsut/images/stencil/608x608/products/1511/3653/1200px-Panasonic-Q-Console-Set__01085.1534195527.jpg?c=2");
		pedido.setUrlProduto("http://videogamesnewyork.com/copy-of-nintendo-gamecube-system-pokemon-xd-special-edition/");
		pedido.setDescricao("Aparelho raro para sua coleção");
		
		List<Pedido> pedidos = Arrays.asList(pedido);  //O método asList() da classe java.util.Arrays é usado para retornar uma lista de tamanho fixo apoiada pela matriz especificada
		model.addAttribute("pedidos", pedidos);        //passamos valores, variáveis para a “view” utilizando o “model”, aquela interface do Spring? não precisamos colocar como atributo do “HttpServeltRequest”. Nós colocamos como “addAttribute(“pedidos”, pedidos”)”.
		
		return "home"; 
	}
}
