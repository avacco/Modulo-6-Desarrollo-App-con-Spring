package cl.andres.java.cft;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CFTController {

	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	// desde alumno-form se accede a un form con method POST, que lleva a la accion PostMapping
	
	@GetMapping("/alumno")
	public String alumnoForm(Alumno alumno) {
		return "alumno-form";
	}
	
	// Validando con Hibernate Validator
	@PostMapping("/alumno")
	public String alumnoProcesar(@Valid Alumno alumno, BindingResult informeValidacion) {
		if(informeValidacion.hasErrors()) {
			return "alumno-form"; // si hubieron errores, vuelve a la vista del form
		}
		return "alumno-ficha"; // si no hay errores, continua al html alumno-ficha
	}
}
