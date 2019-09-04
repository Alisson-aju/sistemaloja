package org.sisloja.une.model.entities;

public class Cidade {
	
	private String nome;
	private String sigla;
	private Estado estado;
	
	
	public Cidade(String nome, String sigla, Estado estado) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.estado = estado;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

}
