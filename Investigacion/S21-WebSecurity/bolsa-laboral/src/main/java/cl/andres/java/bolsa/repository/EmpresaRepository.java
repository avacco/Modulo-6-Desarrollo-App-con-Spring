package cl.andres.java.bolsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.andres.java.bolsa.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
