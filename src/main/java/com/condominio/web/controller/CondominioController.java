package com.condominio.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Condominio> update(@PathVariable("codCon") long codCon,
	                                      	 @RequestBody Condominio condominio) {
	   return service.findById(codCon)
	           .map(record -> {
	        	   record.setDesCon(condominio.getDesCon());
	        	   record.setEndCon(condominio.getEndCon());
	        	   record.setComEnd(condominio.getComEnd());
	        	   record.setBaiCon(condominio.getBaiCon());	        	   
	        	   record.setCidCon(condominio.getCidCon());
	        	   record.setEstCon(condominio.getEstCon());
	        	   record.setCepCon(condominio.getCepCon());
	        	   record.setFlgVoz(condominio.getFlgVoz());
	        	   record.setCoCnpj(condominio.getCoCnpj());
	               Condominio updated = service.update(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}	
	
	@DeleteMapping(path ={"/{codCon}"})
	public ResponseEntity <?> delete(@PathVariable long codCon) {
	   return service.findById(codCon)
	           .map(record -> {
	               service.deleteById(codCon);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
