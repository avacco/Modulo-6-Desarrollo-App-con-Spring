package cl.andres.java.tesoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.andres.java.tesoreria.modelo.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
