package com.sistemas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemas.entidad.Usuario;
import com.sistemas.servicio.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired private UsuarioService servicio;
	
	@GetMapping(value="/poblar")
	public String poblar() {
		Usuario u1 = new Usuario("Yelko", "123456", "ADMIN", 1);
		Usuario u2 = new Usuario("Yelko", "123456", "USER", 1);
		Usuario u3 = new Usuario("Pasache", "123456", "USER", 1);
		Usuario u4 = new Usuario("Aranda", "123456", "ADMIN", 1);
		Usuario u5 = new Usuario("Aranda", "123456", "USER", 1);
		Usuario u6 = new Usuario("Sergio", "123456", "USER", 1);
		Usuario u7 = new Usuario("Pacherres", "123456", "USER", 1);
		servicio.agregar(u1);
		servicio.agregar(u2);
		servicio.agregar(u3);
		servicio.agregar(u4);
		servicio.agregar(u5);
		servicio.agregar(u6);
		servicio.agregar(u7);
		
		return "index";
	}
	
	@GetMapping(value="/denegado")
	public String accesoDenegado(Authentication authResult, Model model) {
		String role = authResult.getAuthorities().toString();
		model.addAttribute("roles", role);
		return "pagina403";
	}
}

