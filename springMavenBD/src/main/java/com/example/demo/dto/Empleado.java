package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="dni")
	private int dni;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="trabajo")
	private String trabajo;
	@Column(name="salario")
	private int salario;
	
	//Constructores
	
	public Empleado() {

	}

	public Empleado(int dni, String nombre, String apellido, String trabajo) {
		this.id = 0;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.trabajo = trabajo;
		asignarSalario(this.trabajo);
	}
	
	
	
	//Getter and Setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	
	//Metodos
	public void asignarSalario(String trabajo) {
		
		switch(trabajo.toLowerCase()) {
		case "jefe":
			this.salario= 1800;
		case "camarero":
			this.salario=1200;
		case "cocinero":
			this.salario= 1400;
		default:
			this.salario= 1300;	
		}
	}
	
	//To String
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", trabajo="
				+ trabajo + ", salario=" + salario + "]";
	}
	
	
	
	
	
}
