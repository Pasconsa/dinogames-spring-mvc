package br.com.dino.dinogames.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;  //é do spring Data
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository; //integrar com spring

import br.com.dino.dinogames.model.Pedido;
import br.com.dino.dinogames.model.StatusPedido;



@Repository   //spring esta gerenciando a classe repository e criando instancia desta classe
public interface PedidoRepository extends JpaRepository <Pedido , Long> {
	//interface Jpa define como aquele metodo tem que ser implementado exemplo find all
		//repositorio para retirar responsabilidade da classe controller e o Pacote repository fica com  a lógica de fazer consulta com banco de dados.

	@Cacheable("books") //10.4 liberar cache para pesquisa na memoria da pagina enão no banco de dados
	List<Pedido> findByStatus(StatusPedido status, Pageable sort);   //10.3 o spring data jpa pageable e não sort sort
														//07 então se declara um metodo com uma lista de pedido faz um select na tabela pedido
														//07 find status faz um filtro onde p status é igual a pedido
	
@Query("select p from Pedido p join p.user u where u.username = :username")  //9.5 criar uma query para ler os pedidos do usuario individual no banco de dados
	List<Pedido> findAllByUsuario(@Param("username")String username);


@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status") //10.1
List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status,@Param ("username")String username);
	


}