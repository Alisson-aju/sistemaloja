package org.sisloja.une.model.entities;

import java.util.Date;

public class Vendedor {
	private Departamento departamento;
	private int codMatricula;
	private String nome;
	private long cpf;
	private long rg;
	private boolean ativo;
	private double salario;
	private Date dataAdmissao;
	
	

	public Vendedor(Departamento departamento, int codMatricula, String nome, long cpf, long rg, boolean ativo,
			double salario, Date dataAdmissao) {
		super();
		this.departamento = departamento;
		this.codMatricula = codMatricula;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.ativo = ativo;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public int getCodMatricula() {
		return codMatricula;
	}

	public void setCodMatricula(int codMatricula) {
		this.codMatricula = codMatricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	
	
	
}
