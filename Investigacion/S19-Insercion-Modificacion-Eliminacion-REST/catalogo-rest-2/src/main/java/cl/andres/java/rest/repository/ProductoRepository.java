package cl.andres.java.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.andres.java.rest.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
