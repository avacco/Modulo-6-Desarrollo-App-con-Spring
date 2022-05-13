package cl.andres.java.cft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.andres.java.cft.Alumno;

@Repository
public class AlumnoRepositoryImp implements AlumnoRepository {

	// Spring autoinstancia esta clase con Autowired. Utiliza los datos en application.properties para conectar a la BD.
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// Crea un objeto alumno con los resultados del query entrante.
	private Alumno makeObject(ResultSet rs, int numFila) throws SQLException{
		return new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"));
	}
	
	// Los query entrantes en cuestion
	@Override
	public List<Alumno> findAll() {
		return jdbcTemplate.query("SELECT * FROM alumnosact2", this::makeObject);
	}

	@Override
	public Alumno findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM alumnosact2 WHERE id = ?", this::makeObject, id);
	}

	@Override
	public void create(Alumno alumno) {
		String sql = "INSERT INTO alumnosact2(nombre, edad) VALUES(?, ?)";
		jdbcTemplate.update(sql,alumno.getNombre(), alumno.getEdad());
	}

	@Override
	public void edit(Alumno alumno) {
		String sql = "UPDATE alumnosact2 SET nombre = ?, edad = ? WHERE id = ?";
		jdbcTemplate.update(sql, alumno.getNombre(), alumno.getEdad(), alumno.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM alumnosact2 WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

}
