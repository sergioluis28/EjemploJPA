package com.sistemas.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistemas.entidad.Usuario;
import com.sistemas.repositorio.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired UsuarioRepository repositorio;
	
	@Override
	public Usuario agregar(Usuario entidad) {
		entidad.setClave(passwordEncoder.encode(entidad.getClave()));
		repositorio.saveAndFlush(entidad);
		return null;
	}

	@Override
	public List<Usuario> listarTodos() {
		
		return repositorio.findAll();
	}

	@Override
	public Usuario buscar(Long id) {
		Usuario	result = null;
		Optional<Usuario> buscado;
		
		buscado = repositorio.findById(id);
		if (buscado.isPresent()) {
			result = buscado.get();
		}
		return result;
	}

}

