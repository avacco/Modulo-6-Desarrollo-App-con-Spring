package cl.andres.java.pruebalombok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.andres.java.pruebalombok.modelo.Usuario;

@Controller
public class UsuarioController {

	@GetMapping("/")
	public String index(Model modelo) {
		
		// Una de las ventaja de usar .builder() es que no se necesita dar los args en orden,
		// o siquiera dar args del todo.
		Usuario miUsuario = Usuario.builder()
								.contrasena("1234")
								.usuario("admin@123.cl")
								.rol("ADMIN")
								.build()
							;
		// equivalente a new Usuario(id,pass,username,role,build);
		modelo.addAttribute("miUsuario",miUsuario);
		
		
		return "index";
	}
}
