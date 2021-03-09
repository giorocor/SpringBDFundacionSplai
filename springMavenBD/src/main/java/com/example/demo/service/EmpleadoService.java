package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.EmpleadoController.Modes;
import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.dto.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
	IEmpleadoDAO iEmpleadoDAO;
	
	public List<Empleado> listarEmpleado(){
		return iEmpleadoDAO.findAll();
	}
	
	public Empleado guardarEmpleado(Empleado empleado) {
		return iEmpleadoDAO.save(empleado);
	}
	
	@Override
	public Empleado EmpleadoXID(Long id) {
		return iEmpleadoDAO.findById(id).get();
	}
	
	public List<Empleado> listarEmpleadoNombre(String nombre){
		return iEmpleadoDAO.findByNombre(nombre);
	}
	
	public List<Empleado> listarEmpleadoTrabajo(Modes mode){
		return iEmpleadoDAO.findByTrabajo(mode);
	}
	
	public Empleado actualizarEmpleado(Empleado empleado) {
		return iEmpleadoDAO.save(empleado);
	}
	

	public void eliminarEmpleado(Long id) {
		iEmpleadoDAO.deleteById(id);
	}


}
