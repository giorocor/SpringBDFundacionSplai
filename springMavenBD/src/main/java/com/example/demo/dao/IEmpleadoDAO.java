package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controller.EmpleadoController.Modes;
import com.example.demo.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long> {
	
	//Listar Empleados por campo nombre
	public List<Empleado> findByNombre(String nombre);
	
	//Listar Empleados por campo trabajo
	public List<Empleado> findByTrabajo(Modes mode);
	
}
