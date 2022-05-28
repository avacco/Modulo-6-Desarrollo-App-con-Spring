package cl.andres.java.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.andres.java.upload.model.Archivo;

public interface ArchivoRepository extends JpaRepository<Archivo, Long> {

}
