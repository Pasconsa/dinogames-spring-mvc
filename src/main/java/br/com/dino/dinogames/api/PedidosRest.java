package br.com.dino.dinogames.api;  //11.1 end point para consumir os pedidos via rest

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dino.dinogames.model.Pedido;
import br.com.dino.dinogames.model.StatusPedido;
import br.com.dino.dinogames.repository.PedidoRepository;


@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;  //11.1 Para recuperar os pedidos
	
	@GetMapping("aguardando")                           
	public List<Pedido> getPedidosAguardandoOfertas() {           //11.1 Quais os dados que vão ser enviado no formato Json
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);   //11.1 Retornar os ultimos dez pedidos mais novos no caso ordenar por ID
	}
}
