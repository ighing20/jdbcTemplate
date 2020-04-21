package com.diego.jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpleadoRowMapper implements RowMapper<Empleado> {

	@Override
	public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
		Empleado emp = new Empleado();
		emp.setIdEmpleado(rs.getInt("idEmpleado"));
		emp.setNombre(rs.getString("nombre"));
		emp.setApellido(rs.getString("apellido"));
		emp.setEmail(rs.getString("email"));
		emp.setTelefono(rs.getString("telefono"));

		return emp;
	}

}
