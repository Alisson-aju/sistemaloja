package org.sisloja.une.model.dao;

public interface AbstractDAO<T> {

	public T buscar(int cod);
	public void inserir(T t);
	public void remover(T t);
	public void remover(int cod);
	public void atualizar(T t);
}
