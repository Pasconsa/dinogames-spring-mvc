package br.com.dino.dinogames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dino.dinogames.dto.RequisicaoNovoPedido;
import br.com.dino.dinogames.model.Pedido;
import br.com.dino.dinogames.repository.PedidoRepository;


@Controller
@RequestMapping("pedido") //todas as requisições pedido vão bater neste controle
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;  //04 para salvar no pedido repository banco dedados

	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario"; //04 retornar formulario dentro da pastapedido
	}
	
	@PostMapping("novo") //04 local onde vai receber as informações do pedido
	public String novo(RequisicaoNovoPedido requisicao) { //requisição trouxe valores para o pedido
		Pedido pedido = requisicao.toPedido(); // pedir para a requisição criar um “pedido”
		pedidoRepository.save(pedido);
		
		return "pedido/formulario";
	} 
	
}
