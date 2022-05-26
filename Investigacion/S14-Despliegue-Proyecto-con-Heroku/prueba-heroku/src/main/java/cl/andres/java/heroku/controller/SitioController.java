package cl.andres.java.heroku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SitioController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/saludo")
	public String saludo() {
		return "saludo";
	}
}
