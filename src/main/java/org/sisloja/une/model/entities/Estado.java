package org.sisloja.une.model.entities;

public class Estado {
	
	private String nome;
	private String sigla;
	
	public Estado(String nome, String sigla) {
		super();
		this.nome = nome;
		this.sigla = sigla;
	}

	public Estado() {
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

	@Override
	public String toString() {
		return "Estado [nome=" + nome + ", sigla=" + sigla + "]";
	}
	
	

}
