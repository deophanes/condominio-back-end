package com.condominio.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Condominio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long codCon;
	
	@Column(nullable=false, length = 50)
	public String desCon;
	@Column(nullable=false, length = 50)    
	public String endCon;
	@Column(length = 30)
    public String comEnd;
	@Column(nullable=false, length = 50)
	public String baiCon;
	@Column(nullable=false, length = 50)
    public String cidCon;
	@Column(nullable=false, length = 2)
    public String estCon;
	@Column(nullable=false, length = 10)
    public String cepCon;
	@Column(nullable=false, length = 1)
    public String flgVoz;
	@Column(nullable=false, length = 14)
    public String coCnpj;
  
}
