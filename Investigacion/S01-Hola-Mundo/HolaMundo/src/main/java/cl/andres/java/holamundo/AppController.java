package cl.andres.java.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/saludo")
	public String saludar() {
		// retorna un archivo html
		return "saludo-view";
	}
}
