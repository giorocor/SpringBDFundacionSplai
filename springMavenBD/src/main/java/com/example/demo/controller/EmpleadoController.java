package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.Empleado;
import com.example.demo.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping("/empleado")
	public List<Empleado> listarClientes(){
		return empleadoService.listarEmpleado();
	}
	
	//listar Clientes por campo nombre
	@GetMapping("/empleado/nombre/{nombre}")
	public List<Empleado> listarClienteNombre(@PathVariable(name="nombre") String nombre) {
	    return empleadoService.listarEmpleadoNombre(nombre);
	}
	
	public enum Modes{
		Camarero, Cocinero, Jefe;
	}
	
	//listar Clientes por campo trabajo
	@GetMapping("/empleado/trabajo/{trabajo}")
	public List<Empleado> listarClienteTrabajo(@PathVariable("mode") Modes mode) {
	    return empleadoService.listarEmpleadoTrabajo(mode);
	}
	
	
	@PostMapping("/empleado")
	public Empleado salvarCliente(@RequestBody Empleado empleado) {
		return empleadoService.guardarEmpleado(empleado);
	}
	
	
	@GetMapping("/empleado/{id}")
	public Empleado empleadoXID(@PathVariable(name="id") Long id) {
		
		Empleado empleado_xid= new Empleado();
		
		empleado_xid=empleadoService.EmpleadoXID(id);
		
		System.out.println("Empleado XID: "+empleado_xid);
		
		return empleado_xid;
	}
	
	@PutMapping("/empleado/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleado empleado) {
		
		Empleado empleado_seleccionado= new Empleado();
		Empleado empleado_actualizado= new Empleado();
		
		empleado_seleccionado= empleadoService.EmpleadoXID(id);
		
		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellido(empleado.getApellido());
		empleado_seleccionado.setDni(empleado.getDni());
		empleado_seleccionado.setTrabajo(empleado.getTrabajo());
		
		
		empleado_actualizado= empleadoService.actualizarEmpleado(empleado_seleccionado);
		
		System.out.println("El cliente actualizado es: "+ empleado_actualizado);
		
		return empleado_actualizado;
	}
	
	@DeleteMapping("/empleado/{id}")
	public void eliminarEmpleado(@PathVariable(name="id")Long id) {
		empleadoService.eliminarEmpleado(id);
	}
	
	
	
	
}
