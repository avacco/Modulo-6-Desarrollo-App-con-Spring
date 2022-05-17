package cl.andres.java.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	
	@GetMapping("/saludo")
	public String saludar(Model modelo) {
		// envia un atributo y su valor
		modelo.addAttribute("nombre", "Pedro");
		
		// retorna un archivo html
		return "saludo-view";
	}
	
	@GetMapping("/salu2")
	public String salu2(Model modelo) {
		// envia un atributo y su valor
		modelo.addAttribute("nombre", "Juan");
		
		// retorna un archivo html
		return "salu2";
	}
	
	@GetMapping("/saludo3")
	public String saludo3(@RequestParam(name = "nombre", defaultValue = "Mundo") String nombre, Model modelo) {
		// envia un atributo y el valor ingresado, por defecto "mundo".
		modelo.addAttribute("nombre", nombre);
		
		return "saludo3";
	}
}
