package cl.andres.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize
					.mvcMatchers("/", "/nosotros", "/contacto", "/login").permitAll() //permite acceso sin autenticacion
					.mvcMatchers("/admin/index", "/admin/reporte").hasRole("ADMIN")
					.anyRequest().authenticated() // requiere autenticacion
					)
			.logout(logout -> logout
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
					)
			;
	}	
}
