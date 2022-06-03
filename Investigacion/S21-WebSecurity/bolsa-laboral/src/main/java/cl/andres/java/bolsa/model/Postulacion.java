package cl.andres.java.bolsa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"aviso_id","postulante_id"})}) // genera una llave compuesta unica entre aviso_id y postulante_id
public class Postulacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Aviso aviso;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Postulante postulante;
	@Column(nullable = false)
	private LocalDateTime fecha;
	
}
