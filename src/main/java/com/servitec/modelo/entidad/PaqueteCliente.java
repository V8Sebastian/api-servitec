package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paquete_cliente")
public class PaqueteCliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paqueteCliente_pk;
	@ManyToOne
	@JoinColumn(name = "pedidoCliente_fk")
	@JsonIgnoreProperties("paqueteCliente")
	private PedidoCliente pedidoCliente_fk;
	@OneToOne
	@JoinColumn(name = "paquete_fk")
	@JsonIgnoreProperties("paqueteCliente")
	private Paquete paquete_fk;
	@OneToOne(mappedBy = "paqueteCliente_fk")
	private PaqueteClienteSerial paqueteClienteSerial;
	private static final long serialVersionUID = 1L;

	public PaqueteCliente() {
	}

	public PaqueteCliente(PedidoCliente pedidoCliente_fk, Paquete paquete_fk) {
		super();
		this.pedidoCliente_fk = pedidoCliente_fk;
		this.paquete_fk = paquete_fk;
	}

	public Long getPaqueteCliente_pk() {
		return paqueteCliente_pk;
	}

	public PedidoCliente getPedidoCliente_fk() {
		return pedidoCliente_fk;
	}

	public void setPedidoCliente_fk(PedidoCliente pedidoCliente_fk) {
		this.pedidoCliente_fk = pedidoCliente_fk;
	}

	public void setPaqueteCliente_pk(Long paqueteCliente_pk) {
		this.paqueteCliente_pk = paqueteCliente_pk;
	}

	public PedidoCliente getPedidoCliente() {
		return pedidoCliente_fk;
	}

	public Paquete getPaquete_fk() {
		return paquete_fk;
	}

	public void setPaquete_fk(Paquete paquete_fk) {
		this.paquete_fk = paquete_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
