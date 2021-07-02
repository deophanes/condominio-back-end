package com.condominio.web.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.condominio.web.model.Condominio;
import com.condominio.web.repository.CondominioRepository;

@Service
public class CondominioService {

	@Autowired
	CondominioRepository repository;

	public List<Condominio> findAll() {
		return (List<Condominio>) repository.findAll();
	}

	public Optional<Condominio> findById(long id){
	   return repository.findById(id);
	}
	
	public boolean existsById(long id) {
		return repository.existsById(id);
	}
	
	@Transactional
	public Condominio insert(@RequestBody Condominio condominio) {
		return repository.save(condominio);
	}

	@Transactional
	public Condominio update(@RequestBody Condominio condominio) {
		return repository.save(condominio);
	}
	
	@Transactional
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
