package cl.andres.java.cft;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Alumno {
 	// Min es utilizado para datos numericos. Por defecto, y si no se han escrito atributos, asume que el valor escrito entre parentesis se atribuye al atributo "value"
	@Min(0)
	private int id;
	
	// Con Hibernate Validator, se puede usar la anotacion Size(min = x, max = y) para definir un minimo y un maximo
	@Size(min = 3, max = 20)
	private String nombre;
	
	private LocalDate fechaNacimiento;
	
	// Si estos "test" no se cumplen, tiraran errores en el controlador a la hora de intentar hacer POST.
	// Desde el mismo controlador se decidiran las acciones a tomar en caso de error
	
	
	public Alumno() {	
	}

	public Alumno(int id,  String nombre, LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	
	
	
}
