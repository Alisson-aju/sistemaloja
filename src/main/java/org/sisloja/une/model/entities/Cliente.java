package org.sisloja.une.model.entities;

import java.util.Date;
import java.util.List;

public class Cliente {
	
	private long idCliente;
	private String nome;
	private Date dataNascimento;
	private String telefone;
	private String CPF;
	private Endereco endereco;
	private List<Venda> listaCompra;
	
	public Cliente() {
		endereco = new Endereco();
		
	}
	
	public Cliente(String nome, Date dataNascimento, String telefone, String cPF, Endereco endereco,
			List<Venda> listaCompra) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		CPF = cPF;
		this.endereco = endereco;
		this.listaCompra = listaCompra;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Venda> getListaCompra() {
		return listaCompra;
	}
	public void setListaCompra(List<Venda> listaCompra) {
		this.listaCompra = listaCompra;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", \n\tnome=" + nome + ", \n\tdataNascimento=" + dataNascimento
				+ ", \n\ttelefone=" + telefone + ", \n\tCPF=" + CPF + ", \n\tendereco=" + endereco.toString() + ", \n\tlistaCompra=" + listaCompra
				+ "]";
	}
	
	
	

}
