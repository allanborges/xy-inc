package com.xyincemp.models.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PoIDto implements Serializable {


	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;
	private Integer coorX;
	private Integer coorY;
	private BigDecimal distancia;
	private BigDecimal distanciaMax;
	
	public PoIDto(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getCoorX() {
		return coorX;
	}
	public void setCoorX(Integer coorX) {
		this.coorX = coorX;
	}
	
	public Integer getCoorY() {
		return coorY;
	}
	public void setCoorY(Integer coorY) {
		this.coorY = coorY;
	}
	
	public BigDecimal getDistancia() {
		return distancia;
	}
	public void setDistancia(BigDecimal distancia) {
		this.distancia = distancia;
	}

	public BigDecimal getDistanciaMax() {
		return distanciaMax;
	}

	public void setDistanciaMax(BigDecimal distanciaMax) {
		this.distanciaMax = distanciaMax;
	}

}
