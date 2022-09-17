package br.com.dino.dinogames.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	public String home(Model model, Principal principal) {  //9.5 Adicionar o princiapl
		
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);  //10.3 ordenar por data de entrega de a primeira pagina 10 itens por pagina
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao); //10.2 pagina home aparecer apenas entregue
		model.addAttribute("pedidos", pedidos);        //passamos valores, variáveis para a “view” utilizando o “model”, aquela interface do Spring? não precisamos colocar como atributo do “HttpServeltRequest”. Nós colocamos como “addAttribute(“pedidos”, pedidos”)”.
		return "home"; 
	}

	
}
