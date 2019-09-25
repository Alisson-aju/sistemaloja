package org.sisloja.une.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sisloja.une.model.entities.Departamento;
import org.sisloja.une.model.entities.VendedorChefe;

public class VendedorChefeDAOImpl implements VendedorChefeDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private DepartamentoDAO depDAO;

	public VendedorChefeDAOImpl() {
		depDAO = new DepartamentoDAOImpl();
	}

	private Connection con;

	private void openConnection() {
		con = DatabaseConector.getInstance().getConnection();
	}

	public VendedorChefe buscar(int cod) throws SQLException {
		// string de query
		String sql = "SELECT *\n" + "FROM PUBLIC.VENDEDOR_CHEFE AS CHEF\n" + "JOIN PUBLIC.VENDEDOR AS COMUM\n"
				+ "ON CHEF.COD_MATRICULA_VENDEDOR = COMUM.COD_MATRICULA\n" + "WHERE CHEF.COD_MATRICULA_VENDEDOR = ?";
		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, cod);
		ResultSet rs = ps.executeQuery();

		VendedorChefe result = null;

		if (rs.next()) {
			result = new VendedorChefe();
			result.setCodMatricula(cod);
			result.setAtivo(rs.getBoolean("ATIVO"));
			result.setCpf(rs.getString("CPF"));
			result.setDataAdmissao(rs.getDate("DATA_ADMISSAO"));
			result.setDataInicioChefia(rs.getDate("DATA_INICIO_CHEFIA"));
			Departamento departamento = depDAO.buscar(Integer.parseInt(rs.getString("FK_COD_DEPARTAMENTO")));
			result.setDepartamento(departamento);
			result.setGraduacao(rs.getString("GRADUACAO"));
			result.setNome(rs.getString("NOME_FUNCIONARIO"));
			result.setRg(rs.getString("RG"));
		}

		// mata recursos
		con.close();
		rs.close();

		return result;
	}

	public void inserir(VendedorChefe vendedor) throws SQLException {
		String sql = "INSERT INTO VENDEDOR_CHEFE" + "(COD_MATRICULA_VENDEDOR, GRADUACAO, DATA_INICIO_CHEFIA) "
				+ "VALUES(?, ?, ?)";

		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, vendedor.getCodMatricula());
		ps.setString(2, vendedor.getGraduacao());
		ps.setDate(3, (Date) vendedor.getDataInicioChefia());
		ps.executeUpdate();

		// mata recursos
		con.close();

	}

	public void remover(VendedorChefe vendedor) throws SQLException {
		String sql = "DELETE FROM VENDEDOR_CHEFE WHERE COD_MATRICULA_VENDEDOR=?";

		openConnection();

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, vendedor.getCodMatricula());
		ps.executeUpdate();

		// mata recursos
		con.close();

	}

	public void atualizar(VendedorChefe vendedor) throws SQLException {

		// string de query
		String sql = "UPDATE VENDEDOR_CHEFE SET GRADUACAO=?, DATA_INICIO_CHEFIA=? WHERE COD_MATRICULA_VENDEDOR=?";
		openConnection();

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, vendedor.getGraduacao());
		ps.setDate(2, (Date) vendedor.getDataInicioChefia());
		ps.setInt(3, vendedor.getCodMatricula());
		ps.executeUpdate();

		// mata recursos
		con.close();

	}

}
