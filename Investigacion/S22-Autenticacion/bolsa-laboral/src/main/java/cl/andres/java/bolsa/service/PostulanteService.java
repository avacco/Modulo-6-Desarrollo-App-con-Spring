package cl.andres.java.bolsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.andres.java.bolsa.model.Postulante;
import cl.andres.java.bolsa.repository.PostulanteRepository;

@Service
public class PostulanteService {

	@Autowired
	PostulanteRepository postulanteRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public Postulante crearPostulante(Postulante postulante) {
		String passCodificado = encoder.encode(postulante.getContrasena());
		postulante.setContrasena(passCodificado);
		return postulanteRepository.save(postulante);
	}
	
	public long contarPosstulantes() {
		return postulanteRepository.count();
	}
	
}
