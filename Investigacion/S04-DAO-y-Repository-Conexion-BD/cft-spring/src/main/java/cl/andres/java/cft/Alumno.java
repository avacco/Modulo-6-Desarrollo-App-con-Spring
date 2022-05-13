package cl.andres.java.cft;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Alumno {
 	// Min es utilizado para datos numericos. Por defecto, y si no se han escrito atributos, asume que el valor escrito entre parentesis se atribuye al atributo "value"
	@Min(0)
	private int id;
	
	// Con Hibernate Validator, se puede usar la anotacion Size(min = x, max = y) para definir un minimo y un maximo
	@Size(min = 3, max = 20)
	private String nombre;
	
	//  Se puede utilizar el atributo message para mandar un mensaje personalizado en caso de error
	@Min(value = 18, message = "Debe ser mayor de edad")
	private int edad;
	
	// Si estos "test" no se cumplen, tiraran errores en el controlador a la hora de intentar hacer POST.
	// Desde el mismo controlador se decidiran las acciones a tomar en caso de error
	
	public Alumno() {	
	}
	
	public Alumno(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Alumno(int id, String nombre, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
