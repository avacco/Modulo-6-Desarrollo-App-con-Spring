package cl.andres.java.bolsa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private LocalDateTime fechaPublicacion;
	@ManyToOne
	@JoinColumn(nullable = false) // en un manyToOne no se puede usar @column, ni nullable, asi que se usa esto
	private Empresa empresa;
}
