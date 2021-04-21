package com.condominio.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominio.web.Service.ContatoService;
import com.condominio.web.model.Contato;

@RestController
@RequestMapping({"/contatos"})
public class ContatoController {

	@Autowired
	private ContatoService service;
	
	@GetMapping
	public Iterable<Contato> findAll() {
		return service.findAll();
	}

}
