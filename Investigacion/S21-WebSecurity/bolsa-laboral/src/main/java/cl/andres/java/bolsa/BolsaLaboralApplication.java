package cl.andres.java.bolsa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.andres.java.bolsa.model.Empresa;
import cl.andres.java.bolsa.model.Postulante;
import cl.andres.java.bolsa.service.EmpresaService;
import cl.andres.java.bolsa.service.PostulanteService;

@SpringBootApplication
public class BolsaLaboralApplication {

	public static void main(String[] args) {
		SpringApplication.run(BolsaLaboralApplication.class, args);
	}

	@Bean // Inicializa datos si la bd esta vacia
	public CommandLineRunner datosIniciales(PostulanteService pService, EmpresaService eService) {
		return args -> {
			if( eService.contarEmpresas() == 0) {
				Empresa empresa = Empresa.builder()
											.contrasena("123")
											.email("correo@empresa.com")
											.razonSocial("razonsocial")
											.rut("12345678-9")
											.build();
				eService.crearEmpresa(empresa);
			}
			if( pService.contarPosstulantes() == 0) {
				Postulante postulante = Postulante.builder()
													.contrasena("123")
													.email("correo@dominio.com")
													.nombre("Pepito Morcilla")
													.rut("98765432-1")
													.build();
				pService.crearPostulante(postulante);
			}
		};
	}
}
