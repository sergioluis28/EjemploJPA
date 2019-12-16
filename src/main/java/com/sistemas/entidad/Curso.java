package com.sistemas.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="Curso")
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=60, nullable=false)
	@NotBlank(message="El nombre no puede estar vacio")
	@Size(min=2, max=60, message="El nombre debe tener entre 2 y 60 caracteres")
	private String nombre;
	
	@Column(length=60)
	@NotBlank(message="La descripcion no puede estar vacio")
	@Size(min=2, max=60, message="La descripcion debe tener entre 2 y 60 caracteres")
	private String descripcion;
	
	@Column(length=15)
	@NotBlank(message="El credito no puede estar vacio")
	@Size(min=1, max=15, message="El credito debe tener entre 1 a 2 numeros")
	private String creditos;
	
	@Column(length=15)
	@NotBlank(message="Las horas no pueden estar vacio")
	@Size(min=1, max=15, message="Las horas deben tener entre 1 y 4 numeros")
	private String ht;
	
	@Column(length=15)
	@NotBlank(message="Las horas no puede estar vacio")
	@Size(min=1, max=15, message="Las horas deben tener entre 1 y 4 numeros")
	private String hp;
	
	@Column(length=15)
	@NotBlank(message="La escolaridad no puede estar vacio")
	@Size(min=2, max=15, message="La escaloridad debe tener entre 2 y 15 numeros")
	private String escolaridad;
	
	public Curso(){
		
	}

	public Curso(long id, String nombre, String descripcion, String creditos, String ht,
			String hp, String escolaridad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion=descripcion;
		this.creditos=creditos;
		this.ht=ht;
		this.hp=hp;
		this.escolaridad=escolaridad;
	}
	

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", creditos=" + creditos
				+ ", ht=" + ht + ", hp=" + hp + ", escolaridad=" + escolaridad + "]";
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public String getHt() {
		return ht;
	}

	public void setHt(String ht) {
		this.ht = ht;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}
	
	
	
}
