package cl.andres.java.bolsa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping("/ingreso")
	public String ingreso() {
		return "ingreso";
	}
	
	@GetMapping("/salir")
	public String salir() {
		return "logout";
	}
	
	@GetMapping("/empresa/registro")
	public String empresaRegistro() {
		return "empresa/registro";
	}
	
	@GetMapping("/postulante/registro")
	public String postulanteRegistro() {
		return "postulante/registro";
	}
	
	@GetMapping("empresa/panel")
	public String empresaPanel(){
		return "empresa/panel";
	}
	
	@GetMapping("postulante/panel")
	public String postulantePanel() {
		return "postulante/panel";
	}
	
}
