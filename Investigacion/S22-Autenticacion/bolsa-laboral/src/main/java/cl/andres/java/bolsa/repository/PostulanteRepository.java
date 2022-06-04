package cl.andres.java.bolsa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.andres.java.bolsa.model.Postulante;

public interface PostulanteRepository extends JpaRepository<Postulante, Long>{

	Optional<Postulante> findByEmail(String username);

}
