package com.diego.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diego.jdbc.model.Empleado;
import com.diego.jdbc.model.EmpleadoRowMapper;

@Transactional
@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Empleado> getAllEmpleado() {

		String query = "SELECT * from empleado";
		RowMapper<Empleado> rowMapper = new EmpleadoRowMapper();
		List<Empleado> list = jdbcTemplate.query(query, rowMapper);

		return list;
	}

	@Override
	public Empleado findeEmpleadoById(int id) {
		String query = "SELECT * FROM empleado where idEmpleado=?;";
		RowMapper<Empleado> rowMapper = new BeanPropertyRowMapper<Empleado>(Empleado.class);
		Empleado emp = jdbcTemplate.queryForObject(query, rowMapper, id);
		return emp;
	}

	@Override
	public void addEmpleado(Empleado empleado) {
		String query = "INSERT INTO empleado(idEmpleado, nombre, apellido, email, telefono) VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(query,empleado.getIdEmpleado(), empleado.getNombre(), empleado.getApellido(), empleado.getEmail(),
				empleado.getTelefono());

	}

	@Override
	public void updateEmpleado(Empleado empleado) {

		String query = "Update empleado set idEmpleado=?, nombre=?, apellido=?, email=?, telefono=?";
		jdbcTemplate.update(query, empleado.getIdEmpleado(), empleado.getNombre(), empleado.getApellido(), empleado.getEmail(),
				empleado.getTelefono());

	}

	@Override
	public void deleteEmpleado(int id) {
		String query = "Delete from empleado where idEmpleado=?";
		jdbcTemplate.update(query, id);

	}

}
