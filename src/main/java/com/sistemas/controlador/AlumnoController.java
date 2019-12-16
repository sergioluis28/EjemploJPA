package com.sistemas.controlador;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sistemas.entidad.Alumno;
import com.sistemas.servicio.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	private AlumnoService alumnoServicio; 
	
	@RequestMapping(value="/poblar", method = RequestMethod.GET)
	public String poblarAlumnos() {
		Alumno a1= new Alumno(10, "Juan", "Torres", "968523789", 
				Date.valueOf("1980-01-01"), "jtorres@sistemas.edu.pe", 
				"Urb. abc", 12.5);
		Alumno a2= new Alumno(20, "Carlos", "Pelaes", "937200455", 
				Date.valueOf("1980-05-11"), "cpelaes@sistemas.edu.pe",
				"Urb. 123", 16.2);
		Alumno a3= new Alumno(30, "Mario", "Bunge", "979300124", 
				Date.valueOf("1986-02-10"), "mbunge@sistemas.edu.pe",
				"Urb. xyz", 15.2);
		Alumno a4= new Alumno(40, "Ricardo", "Linares", "931555824", 
				Date.valueOf("1980-08-05"), "jtorres@sistemas.edu.pe", 
				"Urb. 789", 14.4);
		alumnoServicio.agregar(a1);
		alumnoServicio.agregar(a2);
		alumnoServicio.agregar(a3);
		alumnoServicio.agregar(a4);
		
		return "index";
	}
	
	@RequestMapping("/mostrar")
	public String mostarAlumnos() {
		//muestra en consola
		System.out.println("Alumnos en DB:");
		
		for(Alumno x:alumnoServicio.listarTodos()){
			System.out.println(x.toString());
		}
		
		return "index";
	}
	
	@GetMapping(value= {"/", "/index"})
	public String listarAlumnos(Model model) {
		Iterable<Alumno> listadoAlumnos = alumnoServicio.listarTodos();
		
		model.addAttribute("modeloAlumnos", listadoAlumnos);
		
		return "alumnoIndex";
	}
	
	@GetMapping(value = "/nuevo")
	public String mostrarAlumnoFormNuevo(Alumno alumno) {
		return "alumnoFormNuevo";
	}

	@PostMapping(value = "/nuevo")
	public String procesarAlumnoFormNuevo(
			@Valid @ModelAttribute("alumno") Alumno alumno, 
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			// Corregir errores 
			return "alumnoFormNuevo";
		}
		// Si llegamos hasta aqui es que no hubo errores
		alumnoServicio.agregar(alumno);
		
		return "redirect:/alumno/index";
	}
}
