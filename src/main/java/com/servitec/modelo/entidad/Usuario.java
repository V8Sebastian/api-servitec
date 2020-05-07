package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.Mapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuario_pk;
	@Column(length = 100, nullable = false)
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "ubicacion_fk")
	@JsonIgnoreProperties("usuario")
	private Ubicacion ubicacion_fk;
	@Column(length = 10)
	private String telefono;
	@Column(length = 120, unique = true, nullable = false)
	private String correo;
	@OneToOne(mappedBy = "administrador_fk")
	private Administrador administrador_fk;
	@OneToOne(mappedBy = "empleado_fk")
	private Empleado empleado_fk;
	
	private static final long serialVersionUID = 1L;

	public Usuario() {
	}

	public Usuario(String nombre, Ubicacion ubicacion_fk, String telefono, String correo) {
		this.nombre = nombre;
		this.ubicacion_fk = ubicacion_fk;
		this.telefono = telefono;
		this.correo = correo;
	}

	public Long getUsuario_pk() {
		return usuario_pk;
	}

	public void setUsuario_pk(Long usuario_pk) {
		this.usuario_pk = usuario_pk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ubicacion getUbicacion_fk() {
		return ubicacion_fk;
	}

	public void setUbicacion_fk(Ubicacion ubicacion_fk) {
		this.ubicacion_fk = ubicacion_fk;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

	public Administrador getAdministrador_fk() {
		return administrador_fk;
	}

	public void setAdministrador_fk(Administrador administrador_fk) {
		this.administrador_fk = administrador_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Empleado getEmpleado_fk() {
		return empleado_fk;
	}

	public void setEmpleado_fk(Empleado empleado_fk) {
		this.empleado_fk = empleado_fk;
	}
	
	
}
