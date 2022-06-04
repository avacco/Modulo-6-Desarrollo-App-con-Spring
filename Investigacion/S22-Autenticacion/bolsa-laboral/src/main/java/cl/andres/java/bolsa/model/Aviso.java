package cl.andres.java.bolsa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(nullable = false)
	private String titulo;
	@NotBlank
	@Column(nullable = false)
	private String descripcion;
	@Builder.Default
	@Column(nullable = false)
	private LocalDateTime fechaPublicacion = LocalDateTime.now();
	@ManyToOne
	@JoinColumn(nullable = false) // en un manyToOne no se puede usar @column, ni nullable, asi que se usa esto
	private Empresa empresa;
}
