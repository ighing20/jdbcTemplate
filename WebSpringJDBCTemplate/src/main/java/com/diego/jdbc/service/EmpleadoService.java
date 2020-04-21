package com.diego.jdbc.service;

import java.util.List;

import com.diego.jdbc.model.Empleado;

public interface EmpleadoService {
	
	public List<Empleado> getAllEmpleado();

	public Empleado findeEmpleadoById(int id);

	public void addEmpleado(Empleado empleado);

	public void updateEmpleado(Empleado empleado);

	public void deleteEmpleado(int id);

}
