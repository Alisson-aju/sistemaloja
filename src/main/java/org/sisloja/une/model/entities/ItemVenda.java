package org.sisloja.une.model.entities;

public class ItemVenda {
	
	private double precoUnitario;
	private int quantidade;
	private Produto produto;
	private Venda venda;
	
	
	public ItemVenda(double precoUnitario, int quantidade, Produto produto, Venda venda) {
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.produto = produto;
		this.venda = venda;
	}
	
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	

}
