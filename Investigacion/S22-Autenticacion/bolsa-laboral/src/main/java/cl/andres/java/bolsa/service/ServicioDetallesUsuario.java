package cl.andres.java.bolsa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.andres.java.bolsa.model.Empresa;
import cl.andres.java.bolsa.model.Postulante;
import cl.andres.java.bolsa.repository.EmpresaRepository;
import cl.andres.java.bolsa.repository.PostulanteRepository;
import cl.andres.java.bolsa.security.Usuario;

@Service
public class ServicioDetallesUsuario implements UserDetailsService {

	@Autowired
	private EmpresaRepository empresaRepo;
	
	@Autowired
	private PostulanteRepository postulanteRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Postulante> postulanteOpt = postulanteRepo.findByEmail(username);
		if(postulanteOpt.isPresent()) {
			return new Usuario(postulanteOpt.get(), null);
		} else {
			Optional<Empresa> empresaOpt = empresaRepo.findByRut(username);
			if(empresaOpt.isPresent()) {
				return new Usuario(null, empresaOpt.get());
			}
		}
		throw new UsernameNotFoundException("Usuario no encontrado.");
	}

}
