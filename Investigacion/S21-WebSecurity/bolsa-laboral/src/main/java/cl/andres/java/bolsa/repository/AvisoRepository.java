package cl.andres.java.bolsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.andres.java.bolsa.model.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {

}
