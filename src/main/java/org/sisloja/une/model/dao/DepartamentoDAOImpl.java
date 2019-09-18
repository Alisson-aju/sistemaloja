package org.sisloja.une.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sisloja.une.model.entities.Cidade;
import org.sisloja.une.model.entities.Cliente;
import org.sisloja.une.model.entities.Departamento;
import org.sisloja.une.model.entities.Endereco;
import org.sisloja.une.model.entities.Estado;
import org.sisloja.une.model.entities.Vendedor;
import org.sisloja.une.model.entities.VendedorChefe;

public class DepartamentoDAOImpl implements DepartamentoDAO {

	private Connection con;

	public static void main(String[] args) {
		DepartamentoDAOImpl dDao = new DepartamentoDAOImpl();
		try {
			Departamento dep = dDao.buscar(7);
			System.out.println(dep.getNome());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * Abre conexão com o banco de dados.
	 */
	private void openConnection() {
		con = DatabaseConector.getInstance().getConnection();
	}
	


	public Departamento buscar(int codDepartamento) throws SQLException {
		// string de query
		String sql = "SELECT * \r\n" + 
				"FROM PUBLIC.DEPARTAMENTO AS DEPT\r\n" + 
				"JOIN PUBLIC.VENDEDOR_CHEFE AS CHEF\r\n" + 
				" ON DEPT.FK_COD_VENDEDORCHEFE = CHEF.COD_MATRICULA_VENDEDOR "
				+ "WHERE DEPT.COD_DEPARTAMENTO = ?";
		
		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, codDepartamento);
		ResultSet rs = ps.executeQuery();

		Departamento result = null;

		if (rs.next()) {
			result = new Departamento();
			result.setCodDepartamento(codDepartamento);
			result.setNome(rs.getString("NOME"));
			result.setSigla(rs.getString("SIGLA"));
			result.setPercentualDeComissao(rs.getDouble("PERCENTUAL_COMISSAO"));
			VendedorChefe vendedor = new VendedorChefe();
			vendedor.setCodMatricula(rs.getInt("FK_COD_VENDEDORCHEFE"));
			//
			result.setVendedorChefe(vendedor);
		}

		// mata recursos
		con.close();
		rs.close();

		return result;
	}

	public void inserir(Departamento t) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void remover(Departamento t) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void atualizar(Departamento t) throws SQLException {
		// TODO Auto-generated method stub

	}

}
