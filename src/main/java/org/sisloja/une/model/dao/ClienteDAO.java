package org.sisloja.une.model.dao;

import java.sql.SQLException;

import org.sisloja.une.model.entities.Cliente;

public interface ClienteDAO extends AbstractDAO<Cliente>{
	
	public Cliente buscarPorCPF(String CPF) throws SQLException;

}
