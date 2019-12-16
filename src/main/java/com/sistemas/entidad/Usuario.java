package com.sistemas.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false) private String nombre;
	
	@Column(nullable=false)	private String clave;
	
	@Column(nullable=false)	private String rol;
	
	@Column(nullable=false)	private int estado;
	
	public Usuario() {
	}
	public Usuario(String nombre, String clave, String rol, int estado) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.rol = rol;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", clave=" + clave + ", rol=" + rol + ", estado=" + estado	+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}