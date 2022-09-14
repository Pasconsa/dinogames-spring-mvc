package br.com.dino.dinogames.repository;    //9.05 Criar User repository para usurio esta associado a seus pedidos

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dino.dinogames.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(String username);

	
}
