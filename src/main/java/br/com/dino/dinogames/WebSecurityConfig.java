package br.com.dino.dinogames;  //08 classe dedicada a segurança do spring login password

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource; 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {  //08.1 configuração de  autorização
		http
		.authorizeRequests()
		.antMatchers("/home/**") //10.2 permitir todos acessar home sem login
			.permitAll()
		.anyRequest()
			.authenticated()  //08.1 esta dizendo que todas aplicações tem que estar autorizao por um login
		.and()
		.formLogin(form -> form   //08.1 Qual é a url da pagina de login vai esta barra login e todo mundo é permitido
            .loginPage("/login")
            .defaultSuccessUrl("/usuario/pedido", true) // 9.1 essa linha que vai resolver seu problema, ela define qual é a 
                                                  //página padrão da sua aplicação, então sempre que você logar ele vai te direcionar para a /home
            .permitAll()
        )
		.logout(logout -> {
			logout.logoutUrl("/logout")                   //08.2 toda vez que o logado fazer logout sera deslogado
				.logoutSuccessUrl("/home");
		}).csrf().disable();                             //9.07  desabilitar erro de cadastrar formulario devido a segurança
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {      //09.2 Deixar aplicação com bastante segurança cripitografar
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();                          //datasource consegue conexão com bancos de dados
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder);
		
		
		
	/*	USAR QUANDO FOR CRIAR USUARIO POR AQUI
	  UserDetails user =
				 User.builder()
					.username("paulo")
					.password (encoder.encode("paulo")) //9.02 criptografa senha
					.roles("ADM")
					.build();

		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder)
			.withUser(user);  */                 
	}
}



