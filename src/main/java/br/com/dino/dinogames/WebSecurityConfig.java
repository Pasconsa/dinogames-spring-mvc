package br.com.dino.dinogames;  //08 classe dedicada a segurança do spring login password

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {  //08.1 configuração de  autorização
		http
		.authorizeRequests()
			.anyRequest().authenticated()  //08.1 esta dizendo que todas aplicações tem que estar autorizao por um login
		.and()
		.formLogin(form -> form   //08.1 Qual é a url da pagina de login vai esta barra login e todo mundo é permitido
            .loginPage("/login")
            .defaultSuccessUrl("/home", true) // 9.1 essa linha que vai resolver seu problema, ela define qual é a 
                                                  //página padrão da sua aplicação, então sempre que você logar ele vai te direcionar para a /home
            .permitAll()
        )
		.logout(logout -> logout.logoutUrl("/logout")); //08.2 toda vez que o logado fazer logout sera deslogado
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {  //08.1 autentificação para o usuario
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("joao")
				.password("joao")
				.roles("ADM")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
