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

import com.servitec.modelo.entidad.PaqueteCliente;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/paqueteCliente")
public class PaqueteClienteControlador {

	@Autowired
	@Qualifier("PaqueteClienteServicioImpl")
	private IServicio<PaqueteCliente, Long> paqueteClienteServicio;

	@RequestMapping
	public List<PaqueteCliente> listar() {
		return this.paqueteClienteServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody PaqueteCliente paqueteCliente) {
		this.paqueteClienteServicio.save(paqueteCliente);
	}

	@RequestMapping("/{id}")
	public PaqueteCliente buscar(@PathVariable Long id) {
		return this.paqueteClienteServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody PaqueteCliente paqueteCliente) {
		paqueteCliente.setPaqueteCliente_pk(id);
		this.paqueteClienteServicio.save(paqueteCliente);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.paqueteClienteServicio.deleteById(id);
	}

}
