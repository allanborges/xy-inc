package com.xyincemp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class PoI {
	
	private Long id;
	private Integer coorX;
	private Integer coorY;
	private String nome;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull
	public Integer getCoorX() {
		return coorX;
	}
	public void setCoorX(Integer coorX) {
		this.coorX = coorX;
	}
	
	@NotNull
	public Integer getCoorY() {
		return coorY;
	}
	public void setCoorY(Integer coorY) {
		this.coorY = coorY;
	}
	
}
