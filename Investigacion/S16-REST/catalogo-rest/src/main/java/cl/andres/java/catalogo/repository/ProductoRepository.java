package cl.andres.java.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.andres.java.catalogo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
