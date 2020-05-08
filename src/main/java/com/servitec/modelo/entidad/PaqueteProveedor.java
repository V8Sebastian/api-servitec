package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="paqueteProveedor")
public class PaqueteProveedor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paqueteProveedor;
	@Column
	private	Long pedidoProveedor_fk;

	@OneToOne
	@JoinColumn(name = "paqueteProveedor_fk")
	private Paquete paqueteProveedor_fk;
	
	public PaqueteProveedor() {
	}

	public PaqueteProveedor(Long paqueteProveedor, Long pedidoProveedor_fk, Paquete paqueteProveedor_fk) {
		this.paqueteProveedor = paqueteProveedor;
		this.pedidoProveedor_fk = pedidoProveedor_fk;
		this.paqueteProveedor_fk = paqueteProveedor_fk;
	}

	public Long getPaqueteProveedor() {
		return paqueteProveedor;
	}

	public void setPaqueteProveedor(Long paqueteProveedor) {
		this.paqueteProveedor = paqueteProveedor;
	}

	public Long getPedidoProveedor_fk() {
		return pedidoProveedor_fk;
	}

	public void setPedidoProveedor_fk(Long pedidoProveedor_fk) {
		this.pedidoProveedor_fk = pedidoProveedor_fk;
	}

	public Paquete getPaqueteProveedor_fk() {
		return paqueteProveedor_fk;
	}

	public void setPaqueteProveedor_fk(Paquete paquete_fk) {
		this.paqueteProveedor_fk = paquete_fk;
	}

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
