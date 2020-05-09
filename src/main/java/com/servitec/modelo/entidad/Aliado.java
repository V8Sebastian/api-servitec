package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "aliado")
public class Aliado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aliado_pk;
	@OneToOne
	@JoinColumn(name = "usuario_fk")
	@JsonIgnoreProperties("aliado")
	private Usuario usuario_fk;
	@ManyToOne
	@JoinColumn(name = "tipoDoc_fk")
	@JsonIgnoreProperties("aliado")
	private TipoDoc tipoDoc_fk;
	@Column(length = 20)
	private String documento;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aliado_fk")
	private List<PedidoCliente> pedidoCliente;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aliado_fk")
	private List<PedidoProveedor> pedidoProveedor;
	private static final long serialVersionUID = 1L;

	public Aliado() {
	}

	public Aliado(Usuario usuario_fk, TipoDoc tipoDoc_fk, String documento, List<PedidoCliente> pedidoCliente,
			List<PedidoProveedor> pedidoProveedor) {
		this.usuario_fk = usuario_fk;
		this.tipoDoc_fk = tipoDoc_fk;
		this.documento = documento;
		this.pedidoCliente = pedidoCliente;
		this.pedidoProveedor = pedidoProveedor;
	}

	public Long getAliado_pk() {
		return aliado_pk;
	}

	public void setAliado_pk(Long aliado_pk) {
		this.aliado_pk = aliado_pk;
	}

	public Usuario getUsuario_fk() {
		return usuario_fk;
	}

	public void setUsuario_fk(Usuario usuario_fk) {
		this.usuario_fk = usuario_fk;
	}

	public TipoDoc getTipoDoc_fk() {
		return tipoDoc_fk;
	}

	public void setTipoDoc_fk(TipoDoc tipoDoc_fk) {
		this.tipoDoc_fk = tipoDoc_fk;
	}

	public List<PedidoCliente> getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(List<PedidoCliente> pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public List<PedidoProveedor> getPedidoProveedor() {
		return pedidoProveedor;
	}

	public void setPedidoProveedor(List<PedidoProveedor> pedidoProveedor) {
		this.pedidoProveedor = pedidoProveedor;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
