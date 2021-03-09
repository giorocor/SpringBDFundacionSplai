package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.Empleado;

@SpringBootTest
class SpringMavenBdApplicationTests {

	@Test
	void CrearEmpleado() {
		Empleado empleado=new Empleado(42400237, "valeria", "arias", "Camarero");
		System.out.println(empleado.toString());
	}

}
