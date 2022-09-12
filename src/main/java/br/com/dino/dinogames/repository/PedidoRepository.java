package br.com.dino.dinogames.repository;

import org.springframework.data.jpa.repository.JpaRepository;  //é do spring Data
import org.springframework.stereotype.Repository; //integrar com spring

import br.com.dino.dinogames.model.Pedido;


@Repository   //spring esta gerenciando a classe repository e criando instancia desta classe
public interface PedidoRepository extends JpaRepository <Pedido , Long> {   //interface Jpa define como aquele metodo tem que ser implementado exemplo find all
	//repositorio para retirar responsabilidade da classe controller e o Pacote repository fica com  a lógica de fazer consulta com banco de dados.

	


}