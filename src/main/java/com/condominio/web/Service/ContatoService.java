package com.condominio.web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condominio.web.model.Contato;
import com.condominio.web.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;

	public Iterable<Contato> findAll() {
		return repository.findAll();

	}
}
