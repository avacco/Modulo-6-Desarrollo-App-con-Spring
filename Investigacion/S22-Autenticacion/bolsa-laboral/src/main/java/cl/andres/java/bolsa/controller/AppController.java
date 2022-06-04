package cl.andres.java.bolsa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.andres.java.bolsa.model.Aviso;
import cl.andres.java.bolsa.model.Empresa;
import cl.andres.java.bolsa.repository.AvisoRepository;
import cl.andres.java.bolsa.repository.EmpresaRepository;
import cl.andres.java.bolsa.security.Usuario;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	EmpresaRepository empresaRepo;
	
	@Autowired
	AvisoRepository avisoRepo;

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

	@GetMapping("/aviso/crear")
	public String avisoCrear(Aviso aviso) {
		return "aviso/form";
	}
	
	@PostMapping("/aviso/crear")
	public String avisoProcesar(@Valid Aviso aviso, BindingResult validacion, Authentication usuarioAutenticado) {
		if(validacion.hasErrors()) return "aviso/form";
		
		Usuario usuario = (Usuario) usuarioAutenticado.getPrincipal();
		Empresa empresa = empresaRepo.findById(usuario.getEmpresa().getId()).get();
		aviso.setEmpresa(empresa);
		avisoRepo.save(aviso);
		return "redirect:/";
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
