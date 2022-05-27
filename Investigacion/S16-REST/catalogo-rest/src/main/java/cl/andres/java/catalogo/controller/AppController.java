package cl.andres.java.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.andres.java.catalogo.model.Producto;
import cl.andres.java.catalogo.repository.ProductoRepository;

@RestController
@CrossOrigin(origins = "*")
public class AppController {

	@Autowired
	ProductoRepository productoRepository;
	
	
	// crea entradas en la base de datos si es que esta vacia
	@GetMapping("/instalar")
	public String instalar() {
		long count = productoRepository.count();
		if(count == 0) {
			Producto producto1 = Producto.builder()
									.nombre("Correa paseo")
									.precio(9990)
									.build()
								;
			
			Producto producto2 = Producto.builder()
									.nombre("Plato grande")
									.precio(4990)
									.build()
								;
	
			Producto producto3 = Producto.builder()
									.nombre("Pelota juguete")
									.precio(3990)
									.build()
								;
			productoRepository.saveAndFlush(producto1);
			productoRepository.saveAndFlush(producto2);
			productoRepository.saveAndFlush(producto3);
			return "ok";
		} else {
			return "datos ya existentes";
		}
		
	}
	
	// envia las entradas registradas al catalogo-consumer
	@GetMapping("/productos/destacados")
	public List<Producto> productosDestacados() {
		List<Producto> productos = productoRepository.findAll();
		return productos;
	}
}
