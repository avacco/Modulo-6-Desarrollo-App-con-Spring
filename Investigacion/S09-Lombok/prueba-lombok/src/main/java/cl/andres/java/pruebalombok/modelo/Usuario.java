package cl.andres.java.pruebalombok.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Crea los getters, setters, constructores (con y sin args) y habilita el metood build() para crear instancias
// Para que funcione primero se debe descargar el .jar de Lombok desde su pagina, instalarlo y luego reconstruir el proyecto.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
	
	private Long id;
	private String usuario;
	private String contrasena;
	private String rol;
}
