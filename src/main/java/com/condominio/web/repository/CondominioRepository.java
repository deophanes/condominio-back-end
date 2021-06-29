package com.condominio.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.condominio.web.model.Condominio;

@Repository
public interface CondominioRepository extends CrudRepository<Condominio, Long>  {

}
