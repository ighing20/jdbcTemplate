package com.diego.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diego.jdbc.model.Empleado;
import com.diego.jdbc.service.EmpleadoServiceImpl;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoServiceImpl empleadoService;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView getAllEmpleado() {
		ModelAndView model = new ModelAndView();
		List<Empleado> list = empleadoService.getAllEmpleado();
		model.addObject("empleado_list", list);
		model.setViewName("empleado_list");

		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView editEmpleado(@PathVariable int id) {

		ModelAndView model = new ModelAndView();
		Empleado emp = empleadoService.findeEmpleadoById(id);
		model.addObject("empleadoForm", emp);
		model.setViewName("empleado_form");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		ModelAndView model = new ModelAndView();

		Empleado emp = new Empleado();
		model.addObject("empleadoForm", emp);

		model.setViewName("empleado_form");
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("empleadoForm") Empleado empleado) {
		if (empleado.getIdEmpleado() != null) {
			empleadoService.updateEmpleado(empleado);
		} else {
			empleadoService.addEmpleado(empleado);
		}

		return new ModelAndView("redirect:/empleado/list");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmpleado(@PathVariable("id") int id) {
		empleadoService.deleteEmpleado(id);

		return new ModelAndView("redirect:/empleado/list");
	}

}
