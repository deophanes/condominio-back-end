package com.condominio.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominio.web.Service.ContatoService;
import com.condominio.web.model.Contato;

@RestController
@RequestMapping({ "/contatos" })
public class ContatoController {

	@Autowired
	private ContatoService service;

	@GetMapping
	public List<Contato> findAll() {
		return service.findAll();
	}

	@PostMapping
	public Contato save(@RequestBody Contato contato) {
		return service.save(contato);
	}

}
