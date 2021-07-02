package com.condominio.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominio.web.Service.CondominioService;
import com.condominio.web.model.Condominio;

@RestController
@RequestMapping(value = "/condominio")
public class CondominioController {

	@Autowired
	private CondominioService service;
	
	@GetMapping
	public ResponseEntity<List<Condominio>> findAll() {
		List<Condominio> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(path = {"/{codCon}"})
	public ResponseEntity<Condominio> findById(@PathVariable long codCon){
	   return service.findById(codCon)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Condominio condominio) {
		service.insert(condominio);
		return ResponseEntity.created(null).build(); 
	}
	
	@PutMapping(value="/{codCon}")
	public ResponseEntity<Condominio> update( @Validated @PathVariable long codCon,
	                                      	 @RequestBody Condominio condominio) {
		Optional<Condominio> conAtual = service.findById(codCon);
		if (conAtual.isPresent()) {
			BeanUtils.copyProperties(condominio, conAtual.get() , "codCon");	
			var updated = service.insert(conAtual.get());
			return ResponseEntity.ok().body(updated);
		}
		return ResponseEntity.notFound().build();
	}	
	
	@DeleteMapping(path ={"/{codCon}"})
	public ResponseEntity <Void> delete(@PathVariable long codCon) {
		if (service.existsById(codCon)) {
			service.deleteById(codCon);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
