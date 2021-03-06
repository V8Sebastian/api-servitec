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

import com.servitec.modelo.entidad.TipoDoc;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/tipoDoc")
public class TipoDocControlador {

	@Autowired
	@Qualifier("TipoDocServicioImpl")
	private IServicio<TipoDoc, Long> tipoDocServicio;

	@RequestMapping
	public List<TipoDoc> listar() {
		return this.tipoDocServicio.findAll();
	}

	@RequestMapping("/{id}")
	public TipoDoc buscar(@PathVariable Long id) {
		return this.tipoDocServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody TipoDoc tipoDoc) {
		this.tipoDocServicio.save(tipoDoc);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody TipoDoc tipoDoc) {
		tipoDoc.setTipoDoc_pk(id);
		this.tipoDocServicio.save(tipoDoc);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.tipoDocServicio.deleteById(id);
	}

}
