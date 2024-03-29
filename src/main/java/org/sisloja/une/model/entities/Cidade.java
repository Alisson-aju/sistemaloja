package org.sisloja.une.model.entities;

public class Cidade {
	
	private String nome;
	private Estado estado;
	
	
	public Cidade(String nome, Estado estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}
	
	public Cidade() {
		estado = new Estado();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cidade [\n\tnome=" + nome + ", \n\testado=" + estado.toString() + "]";
	}
	
	
	
	

}
