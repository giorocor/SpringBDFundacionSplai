package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.EmpleadoController.Modes;
import com.example.demo.dto.Empleado;

public interface IEmpleadoService {

	//Metodos del CRUD
	public List<Empleado> listarEmpleado(); //Listar All 
	
	public Empleado guardarEmpleado(Empleado empleado);	//Guarda un Empleado CREATE
	
	public Empleado EmpleadoXID(Long id); //Leer datos de un Empleado READ
	
	public List<Empleado> listarEmpleadoNombre(String nombre);//Listar Empleado por campo nombre
	
	public List<Empleado> listarEmpleadoTrabajo(Modes mode);//Listar Empleado por campo trabajo
	
	public Empleado actualizarEmpleado(Empleado Empleado); //Actualiza datos del Empleado UPDATE
	
	public void eliminarEmpleado(Long id);// Elimina el Empleado DELETE
}
