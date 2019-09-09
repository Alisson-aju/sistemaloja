package org.sisloja.une.model.entities;

import java.util.Date;
import java.util.List;

public class Venda {

	private double valorTotal;
	private long codRegistroVenda;
	private Cliente cliente;
	private Vendedor vendedor;
	private Date dataVenda;
	private List<ItemVenda> listaItens;
	private float comissao;
	private Departamento departamento;
	
	
	public Venda(double valorTotal, long codRegistroVenda,Departamento departamento,  Cliente cliente, Vendedor vendedor, Date dataVenda,
			List<ItemVenda> listaItens, float comissao) {
		super();
		this.valorTotal = valorTotal;
		this.codRegistroVenda = codRegistroVenda;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.dataVenda = dataVenda;
		this.listaItens = listaItens;
		this.comissao = comissao;
		this.departamento = departamento;
	}
	
	public void adicionarProduto(Produto produto, int quantidade, float desconto) {
		
		listaItens.add(new ItemVenda(produto.getPrecoDeVenda() - desconto,
				quantidade, produto, this));
	}
	
	public void removerProduto(int codProduto) {
		for(ItemVenda i: listaItens) {
			if(i.getProduto().getCodProduto() == codProduto) {
				listaItens.remove(i);
			}
		}
	}
	
	public void finalizarVenda() {}
	
	public List<Produto> obterProdutosSimilares(){ return null;}
	
	public List<Produto> obterProdutosDestaques(){return null;}
	
	public void removerProduto(ItemVenda item) {
		this.listaItens.remove(item);
	}
	
	
	
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public long getCodRegistroVenda() {
		return codRegistroVenda;
	}
	public void setCodRegistroVenda(long codRegistroVenda) {
		this.codRegistroVenda = codRegistroVenda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public List<ItemVenda> getListaItens() {
		return listaItens;
	}
	public void setListaItens(List<ItemVenda> listaItens) {
		this.listaItens = listaItens;
	}
	public float getComissao() {
		return comissao;
	}
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	
	
	
}
