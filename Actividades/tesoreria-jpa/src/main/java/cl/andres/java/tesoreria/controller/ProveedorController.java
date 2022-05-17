package cl.andres.java.tesoreria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.andres.java.tesoreria.modelo.Proveedor;
import cl.andres.java.tesoreria.repository.ProveedorRepository;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	ProveedorRepository proveedorRepository;
	
	@GetMapping("/nuevo")
	public String nuevo(Proveedor proveedor) {
		return "proveedor/form";
	}
	
	@PostMapping("/procesar")
	public String procesar(@Valid Proveedor proveedor, BindingResult informeValidacion) {
		if(informeValidacion.hasErrors()) return "proveedor/form";
		// Guarda la entidad con funciones de JPA
		proveedorRepository.saveAndFlush(proveedor);
		return "redirect:/proveedor/listado";
	}
	
	@GetMapping("/listado")
	public String listado(Model modelo) {
		List<Proveedor> proveedores = proveedorRepository.findAll();
		modelo.addAttribute("proveedores",proveedores);
		return "proveedor/listado";
	}
	
}
