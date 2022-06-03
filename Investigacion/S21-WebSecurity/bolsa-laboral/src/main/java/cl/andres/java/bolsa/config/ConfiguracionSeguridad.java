package cl.andres.java.bolsa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad {

	@Bean
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filtro(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(authorize -> authorize
										.mvcMatchers("/").permitAll()
										.anyRequest().authenticated()
			)
			.formLogin(form -> form
						.loginPage("/ingreso")
						.defaultSuccessUrl("/",true)
						.permitAll()
			)
			.logout(logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/salir","GET"))
					
			)
		;
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() { 
		// ignora los requisitos de seguridad para las siguientes carpetas y sus archivos  
		return (web) -> web.ignoring().antMatchers("/img/**","/css/**","/js/**");
	}
}
