package org.sisloja.une.model.entities;

import java.util.List;

public class Departamento {
	private int codDepartamento;
	private VendedorChefe vendedorChefe;
	private String sigla;
	private String nome;
	private double percentualDeComissao;
	private List<Vendedor> listaDeVendedores;
	
	public Departamento(int codDepartamento, VendedorChefe vendedorChefe, String sigla, String nome,
			double percentualDeComissao, List<Vendedor> listaDeVendedores) {
		super();
		this.codDepartamento = codDepartamento;
		this.vendedorChefe = vendedorChefe;
		this.sigla = sigla;
		this.nome = nome;
		this.percentualDeComissao = percentualDeComissao;
		this.listaDeVendedores = listaDeVendedores;
	}
	
	public Departamento() {
		// TODO Auto-generated constructor stub
	}

	public int getCodDepartamento() {
		return codDepartamento;
	}
	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}
	public VendedorChefe getVendedorChefe() {
		return vendedorChefe;
	}
	public void setVendedorChefe(VendedorChefe vendedorChefe) {
		this.vendedorChefe = vendedorChefe;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPercentualDeComissao() {
		return percentualDeComissao;
	}
	public void setPercentualDeComissao(double percentualDeComissao) {
		this.percentualDeComissao = percentualDeComissao;
	}
	public List<Vendedor> getListaDeVendedores() {
		return listaDeVendedores;
	}
	public void setListaDeVendedores(List<Vendedor> listaDeVendedores) {
		this.listaDeVendedores = listaDeVendedores;
	}

	@Override
	public String toString() {
		return "Departamento [codDepartamento=" + codDepartamento + ", vendedorChefe=" + vendedorChefe + ", sigla="
				+ sigla + ", nome=" + nome + ", percentualDeComissao=" + percentualDeComissao + ", listaDeVendedores="
				+"]";
	}
	
	
	
	
}
