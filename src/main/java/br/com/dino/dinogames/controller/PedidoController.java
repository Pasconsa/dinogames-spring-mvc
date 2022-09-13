package br.com.dino.dinogames.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String formulario(RequisicaoNovoPedido requisição) { //05 formulario precisa de uma requisição novo pedido Retirar erro
		return "pedido/formulario"; //04 retornar formulario dentro da pastapedido
	}
	
	@PostMapping("novo") //04 local onde vai receber as informações do pedido
	public String novo(@Valid RequisicaoNovoPedido requisicao , BindingResult result) { //requisição trouxe valores para o pedido  05 @Valid informando ao spring pedido da validação do @noblank
		if(result.hasErrors()) {                  ///05 Binding result o spring da resultado da validação
			return "pedido/formulario";             //05 se houver erros da esse reultado  formulario volta ser preenchido                                    /
		}
		
		
		Pedido pedido = requisicao.toPedido(); // pedir para a requisição criar um “pedido”
		pedidoRepository.save(pedido);
		
		return "redirect:/home"; //07 quando pedido for salvo voltar para home
	} 
	
}
