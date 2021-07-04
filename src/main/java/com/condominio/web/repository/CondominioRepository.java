package com.condominio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominio.web.model.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long>  {

}
