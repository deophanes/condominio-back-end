package com.condominio.web.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.condominio.web.model.Condominio;
import com.condominio.web.repository.CondominioRepository;

@Service
public class CondominioService {

	@Autowired
	CondominioRepository repository;

	public Page<Condominio> findAll(@RequestParam(value = "page", defaultValue = "0") Integer pagina, 
									@RequestParam(value = "size", defaultValue = "5") Integer tamanho	) {
		PageRequest pageRequest = PageRequest.of(pagina, tamanho);
		return repository.findAll(pageRequest);
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
