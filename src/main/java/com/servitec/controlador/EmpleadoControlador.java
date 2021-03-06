package com.servitec.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servitec.modelo.entidad.Empleado;
import com.servitec.modelo.servicio.implementacion.EmpleadoServicioImpl;

@RestController
@RequestMapping("/empleado")
public class EmpleadoControlador {

	@Autowired
	private EmpleadoServicioImpl empleadoServicio;

	@RequestMapping
	public List<Empleado> listar() {
		return this.empleadoServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Empleado empleado) {
		this.empleadoServicio.save(empleado);
	}

	@RequestMapping("/{id}")
	public Empleado buscar(@PathVariable Long id) {
		return this.empleadoServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
		empleado.setEmpleado_pk(id);
		this.empleadoServicio.save(empleado);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.empleadoServicio.deleteById(id);
	}

	@RequestMapping("/{alias}/{contrasena}")
	public Map<String, Object> inicioSesion(@PathVariable String alias, @PathVariable String contrasena) {
		return this.empleadoServicio.sesion(alias, contrasena);
	}
}
