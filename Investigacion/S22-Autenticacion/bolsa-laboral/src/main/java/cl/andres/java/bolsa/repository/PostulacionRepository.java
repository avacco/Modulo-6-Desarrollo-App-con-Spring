package cl.andres.java.bolsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.andres.java.bolsa.model.Postulacion;

public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {

}
