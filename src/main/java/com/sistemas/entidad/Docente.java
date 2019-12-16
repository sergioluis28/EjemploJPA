package com.sistemas.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Docente")
public class Docente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=60, nullable=false)
	@NotBlank(message="El nombre no puede estar vacio")
	@Size(min=2, max=60, message="El nombre debe tener entre 2 y 60 caracteres")
	private String nombre;
	
	@Column(length=60)
	@NotBlank(message="El apellido no puede estar vacio")
	@Size(min=2, max=60, message="El apellido debe tener entre 2 y 60 caracteres")
	private String apellido;
	
	@Column(length=15)
	@NotBlank(message="El celular no puede estar vacio")
	@Size(min=2, max=15, message="El celular debe tener entre 2 y 15 numeros")
	private String celular;
	
	@Column(length=100)
	@NotBlank(message="La especialidad no puede estar vacio")
	@Size(min=2, max=60, message="La especialidad debe tener entre 2 y 60 caracteres")
	private String especialidad;
	
	
	@Past(message="La fecha de ingreso debe ser anteior a la fecha actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaIngreso;
	
	@Past(message="La fecha de nacimiento debe ser anteior a la fecha actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fNacimiento;
	
	public Docente(){
		
	}

	public Docente(long id, String nombre, String apellido, String celular, 
			String especialidad,Date fechaIngreso, Date fNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.especialidad = especialidad;
		this.fechaIngreso=fechaIngreso;
		this.fNacimiento=fNacimiento;
	}
	
	
	@Override
	public String toString() {
		return "Docente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido 
				+ ", celular=" + celular + ", especialidad=" + especialidad + ", fNacimiento=" 
				+ fNacimiento + ", fechaIngreso=" + fechaIngreso+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
}
