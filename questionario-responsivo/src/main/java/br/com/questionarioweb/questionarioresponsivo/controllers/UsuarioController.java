package br.com.questionarioweb.questionarioresponsivo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.questionarioweb.questionarioresponsivo.model.entities.Usuario;
import br.com.questionarioweb.questionarioresponsivo.model.repositories.QuestionarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	QuestionarioRepository questionarioRepository;

	@GetMapping
	public Usuario obterUsuario() {
		return new Usuario(1, "Jonathan");
	}


}
