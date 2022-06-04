package cl.andres.java.bolsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.andres.java.bolsa.model.Empresa;
import cl.andres.java.bolsa.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public Empresa crearEmpresa(Empresa empresa) {
		String passCodificado = encoder.encode(empresa.getContrasena());
		empresa.setContrasena(passCodificado);
		return empresaRepository.save(empresa);
	}
	
	public long contarEmpresas() {
		return empresaRepository.count();
	}
	
}
