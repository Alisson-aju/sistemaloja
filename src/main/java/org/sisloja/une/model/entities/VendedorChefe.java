package org.sisloja.une.model.entities;

import java.util.Date;

public class VendedorChefe extends Vendedor{
	
	private Date dataInicioChefia;
	private String graduacao;
	
	

	public VendedorChefe(Departamento departamento, int codMatricula, String nome, String cpf, String rg, boolean ativo,
			double salario, Date dataAdmissao, Date dataInicioChefia, String graduacao) {
		super(departamento, codMatricula, nome, cpf, rg, ativo, salario, dataAdmissao);
		this.dataInicioChefia = dataInicioChefia;
		this.graduacao = graduacao;
	}

	public VendedorChefe() {
		// TODO Auto-generated constructor stub
	}

	public String getGraduacao() {
		return graduacao;
	}

	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}

	public Date getDataInicioChefia() {
		return dataInicioChefia;
	}

	public void setDataInicioChefia(Date dataInicioChefia) {
		this.dataInicioChefia = dataInicioChefia;
	}

	@Override
	public String toString() {
		return " [nome= "+ getNome() +", " + "dataInicioChefia=" + dataInicioChefia + ", graduacao=" + graduacao + "]";
	}

	
	
	

}
