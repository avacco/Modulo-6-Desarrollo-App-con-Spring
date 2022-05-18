package cl.andres.java.tesoreria.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor {

	// JPA se encargara a traves de estas anotaciones de identificar la PK, el auto incremental, los nulls y uniques, entre otros
	// Con todo esto JPA genera la tabla con nombre de la clase y columnas de nombre de los atributos.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long id;
	@Column(nullable = false, length = 10, unique = true)
	private String rut;
	@Column(nullable = false)
	private String razonSocial;
	
	public Proveedor() {}
	
	public Proveedor(Long id, String rut, String razonSocial) {
		this.id = id;
		this.rut = rut;
		this.razonSocial = razonSocial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	
	
}
