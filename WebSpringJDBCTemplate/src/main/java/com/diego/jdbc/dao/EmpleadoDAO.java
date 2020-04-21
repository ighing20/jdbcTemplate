package com.diego.jdbc.dao;

import java.util.List;

import com.diego.jdbc.model.Empleado;

public interface EmpleadoDAO {

	public List<Empleado> getAllEmpleado();

	public Empleado findeEmpleadoById(int id);

	public void addEmpleado(Empleado empleado);

	public void updateEmpleado(Empleado empleado);

	public void deleteEmpleado(int id);

}
