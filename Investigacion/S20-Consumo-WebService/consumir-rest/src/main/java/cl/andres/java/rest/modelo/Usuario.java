package cl.andres.java.rest.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //ignora las propiedades desconocidas, se deja solo las que correspondan con esta clase
public class Usuario {

	// los nombres de atributo deben ser igual a los que llegaran por JSON
	private Long id;
	@JsonProperty("name") // pero se puede utilizar esta anotacion para hacer la asignacion manualmente
	private String nombre;
	private String username;
	private String email;
	private String phone;
	private String website;
	private Direccion address;
}
