package com.sistemas.controlador;

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
import com.sistemas.entidad.Curso;
import com.sistemas.servicio.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	@Autowired
	private CursoService cursoServicio;
	@RequestMapping(value="/poblar", method = RequestMethod.GET)
	public String poblarCursos() {
		Curso c1 = new Curso(1,"Electronica DIgital","Enfocado en arduino","4","2","2","Nacional");
		Curso c2 = new Curso(1,"Dinamica","Enfoque Sistemico","3","2","4","Nacional");
		
		cursoServicio.agregar(c1);
		cursoServicio.agregar(c2);
		
		return "index";
	}
	
	@RequestMapping("/mostrar")
	public String mostarCursos() {
		//muestra en consola
		System.out.println("Cursos en DB:");
		
		for(Curso x:cursoServicio.listarTodos()){
			System.out.println(x.toString());
		}
		
		return "index";
	}
	
	@GetMapping(value= {"/", "/index"})
	public String listarCursos(Model model) {
		Iterable<Curso> listadoCursos = cursoServicio.listarTodos();
		
		model.addAttribute("modeloCursos", listadoCursos);
		
		return "cursoIndex";
	}
	
	@GetMapping(value = "/nuevo")
	public String mostrarCursoFormNuevo(Curso curso) {
		return "cursoFormNuevo";
	}
	
	@PostMapping(value = "/nuevo")
	public String procesarCursoFormNuevo(
			@Valid @ModelAttribute("curso") Curso curso, 
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			// Corregir errores 
			return "cursoFormNuevo";
		}
		// Si llegamos hasta aqui es que no hubo errores
		cursoServicio.agregar(curso);
		
		return "redirect:/curso/index";
	}
}
