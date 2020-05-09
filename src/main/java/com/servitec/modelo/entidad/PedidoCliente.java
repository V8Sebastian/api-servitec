package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pedido_cliente")
public class PedidoCliente implements Serializable {

	@Id
	private Long pedidoCliente_pk;
	@OneToMany(mappedBy = "pedidoCliente_fk")
	private List<PaqueteCliente> paqueteClientes;
	@ManyToOne
	@JoinColumn(name = "aliado_fk")
	@JsonIgnoreProperties("pedidoCliente")
	private Aliado aliado_fk;
	@OneToOne
	@JoinColumn(name = "pedido_fk")
	@JsonIgnoreProperties("pedidoCliente")
	private Pedido pedido_fk;
	private static final long serialVersionUID = 1L;

	public PedidoCliente() {
	}

	public PedidoCliente(List<PaqueteCliente> paqueteClientes, Aliado aliado_fk, Pedido pedido_fk) {
		this.paqueteClientes = paqueteClientes;
		this.aliado_fk = aliado_fk;
		this.pedido_fk = pedido_fk;
	}

	public Pedido getPedido_fk() {
		return pedido_fk;
	}

	public void setPedido_fk(Pedido pedido_fk) {
		this.pedido_fk = pedido_fk;
	}

	public Aliado getAliado_fk() {
		return aliado_fk;
	}

	public void setAliado_fk(Aliado aliado_fk) {
		this.aliado_fk = aliado_fk;
	}

	public Long getPedidoCliente_pk() {
		return pedidoCliente_pk;
	}

	public List<PaqueteCliente> getPaqueteClientes() {
		return paqueteClientes;
	}

	public void setPaqueteClientes(List<PaqueteCliente> paqueteClientes) {
		this.paqueteClientes = paqueteClientes;
	}

	public void setPedidoCliente_pk(Long pedidoCliente_pk) {
		this.pedidoCliente_pk = pedidoCliente_pk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
