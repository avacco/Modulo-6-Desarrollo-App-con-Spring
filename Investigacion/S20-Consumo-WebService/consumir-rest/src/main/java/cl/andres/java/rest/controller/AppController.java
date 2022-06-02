package cl.andres.java.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import cl.andres.java.rest.modelo.Usuario;

@Controller
public class AppController {

	@GetMapping("/")
	public String consumirWebService(RestTemplate restTemplate, Model modelo) {
		String url = "https://jsonplaceholder.typicode.com/users";
		// transforma el json recibido en un array de usuarios
		Usuario[] usuarios = restTemplate.getForObject(url, Usuario[].class);
		modelo.addAttribute("usuarios",usuarios);
		return "usuarios";
	}
}
