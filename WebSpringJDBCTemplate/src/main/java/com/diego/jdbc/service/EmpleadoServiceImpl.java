package com.diego.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.jdbc.dao.EmpleadoDAOImpl;
import com.diego.jdbc.model.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoDAOImpl empleadoDAO;

	@Override
	public List<Empleado> getAllEmpleado() {
		return empleadoDAO.getAllEmpleado();
	}

	@Override
	public Empleado findeEmpleadoById(int id) {
		return empleadoDAO.findeEmpleadoById(id);
	}

	@Override
	public void addEmpleado(Empleado empleado) {
		empleadoDAO.addEmpleado(empleado);

	}

	@Override
	public void updateEmpleado(Empleado empleado) {
		empleadoDAO.updateEmpleado(empleado);

	}

	@Override
	public void deleteEmpleado(int id) {
		empleadoDAO.deleteEmpleado(id);

	}

}
