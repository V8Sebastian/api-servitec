package com.servitec.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servitec.modelo.entidad.Ciudad;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/ciudad")
public class CiudadControlador {

	@Autowired
	@Qualifier("CiudadServicioImpl")
	private IServicio<Ciudad, Long> ciudadServicio;

	@RequestMapping
	public List<Ciudad> listar() {
		return this.ciudadServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Ciudad buscar(@PathVariable Long id) {
		return this.ciudadServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Ciudad ciudad) {
		this.ciudadServicio.save(ciudad);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Ciudad ciudad) {
		ciudad.setCiudad_pk(id);
		this.ciudadServicio.save(ciudad);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.ciudadServicio.deleteById(id);
	}

}
