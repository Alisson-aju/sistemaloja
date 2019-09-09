package org.sisloja.une.model.dao;

import java.sql.SQLException;

public interface AbstractDAO<T> {

	public T buscar(int cod) throws SQLException;
	public void inserir(T t) throws SQLException;
	public void remover(T t) throws SQLException;
	public void atualizar(T t) throws SQLException;
}
