package com.condominio.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.condominio.web.model.Contato;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Long> {

}
