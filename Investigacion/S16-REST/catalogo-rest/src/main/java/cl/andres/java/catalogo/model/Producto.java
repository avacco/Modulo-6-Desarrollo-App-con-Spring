package cl.andres.java.catalogo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	private String nombre;
	private double precio;
	
}
