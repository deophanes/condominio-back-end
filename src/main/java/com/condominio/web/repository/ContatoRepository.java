package com.condominio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominio.web.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
