package org.sisloja.une.model.entities;

public class Produto {
	private int codProduto;
	private String nome;
	private String descricao;
	private double precoDeVenda;
	private int quantidadeEmEstoque;
	private Departamento departamento;
	
	public Produto(int codProduto, String nome, String descricao, double precoDeVenda, int quantidadeEmEstoque,
			Departamento departamento) {
		this.codProduto = codProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.precoDeVenda = precoDeVenda;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.departamento = departamento;
	}
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoDeVenda() {
		return precoDeVenda;
	}
	public void setPrecoDeVenda(double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
}
