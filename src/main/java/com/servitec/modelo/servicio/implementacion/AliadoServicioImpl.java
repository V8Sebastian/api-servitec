package com.servitec.modelo.servicio.implementacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IAliadoDao;
import com.servitec.modelo.entidad.Aliado;
import com.servitec.modelo.entidad.PedidoCliente;
import com.servitec.modelo.entidad.PedidoProveedor;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("AliadoServicioImpl")
public class AliadoServicioImpl implements IServicio<Aliado, Long> {

	@Autowired
	private IAliadoDao aliadoDao;
	@Autowired
	private PedidoServicioImpl pedidoServicio;

	@Override
	@Transactional(readOnly = true)
	public List<Aliado> findAll() {
		return (List<Aliado>) this.aliadoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Aliado Aliado) {
		this.aliadoDao.save(Aliado);
	}

	@Override
	@Transactional(readOnly = true)
	public Aliado findById(Long id) {
		return this.aliadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.aliadoDao.deleteById(id);
	}

	@Transactional
	public Map<String, Object> reporte(Long id) {
		Map<String, Object> objeto = new HashMap<>();
		objeto.put("aliado_pk", id);
		List<Object> listaPedido = new ArrayList<>();
		Aliado aliado = findById(id);
		for (PedidoCliente pc : aliado.getPedidoCliente()) {
			listaPedido.add(this.pedidoServicio.reporte(pc.getPedido_fk().getPedido_pk()));
		}
		for (PedidoProveedor pp : aliado.getPedidoProveedor()) {
			listaPedido.add(this.pedidoServicio.reporte(pp.getPedido_fk().getPedido_pk()));
		}
		objeto.put("listaPedido", listaPedido);
		return objeto;
	}

	@Transactional
	public List<Object> reporteTodo() {
		List<Aliado> listaAliado = findAll();
		List<Object> lista = new ArrayList<>();
		for (Aliado aliado : listaAliado) {
			lista.add(reporte(aliado.getAliado_pk()));
		}
		return lista;
	}

	@Transactional
	public Map<String, Object> devolucion(Long id) {
		Map<String, Object> objeto = new HashMap<>();
		List<Object> lista = new ArrayList<>();
		Aliado aliado = findById(id);
		if (aliado.getPedidoCliente() != null) {
			objeto.put("tipo", "cliente");
			for (PedidoCliente pedidoCliente : aliado.getPedidoCliente()) {
				lista.add(pedidoServicio.devolucion(pedidoCliente.getPedido_fk().getPedido_pk()));
			}
		}
		if (aliado.getPedidoProveedor() != null) {
			objeto.put("tipo", "proveedor");
			for (PedidoProveedor pedidoProveedor : aliado.getPedidoProveedor()) {
				lista.add(pedidoServicio.devolucion(pedidoProveedor.getPedido_fk().getPedido_pk()));
			}
		}
		objeto.put("aliado_pk", aliado.getAliado_pk());
		objeto.put("listaPedido", lista);
		return objeto;
	}
}
