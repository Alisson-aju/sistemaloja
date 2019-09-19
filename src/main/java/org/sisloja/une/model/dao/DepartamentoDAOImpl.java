package org.sisloja.une.model.dao;

import java.sql.Connection;
import java.sql.Date;
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
			Departamento dep = dDao.buscar(1);
			dep.setNome("CONGELADOS");
			System.out.println(dep.getNome());
			dDao.atualizar(dep);
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
		String sql = "SELECT *\n" + "FROM PUBLIC.DEPARTAMENTO AS DEPT\n" + "JOIN PUBLIC.VENDEDOR_CHEFE AS CHEF\n"
				+ "ON DEPT.FK_COD_VENDEDORCHEFE = CHEF.COD_MATRICULA_VENDEDOR\n" + "JOIN PUBLIC.VENDEDOR AS VENO\n"
				+ "ON CHEF.COD_MATRICULA_VENDEDOR = VENO.COD_MATRICULA\n" + "WHERE DEPT.COD_DEPARTAMENTO = ?";

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
			vendedor.setAtivo(rs.getBoolean("SITUACAO"));
			vendedor.setCpf(rs.getString("CPF"));
			vendedor.setDataAdmissao(rs.getDate("DATA_ADMISSAO"));
			vendedor.setDataInicioChefia(rs.getDate("DATA_INICIO_CHEFIA"));
			vendedor.setDepartamento(result);
			vendedor.setGraduacao(rs.getString("GRADUACAO"));
			vendedor.setRg(rs.getString("RG"));
			vendedor.setNome(rs.getString("NOME_FUNCIONARIO"));
			// falta lista de vendedores
			//
			result.setVendedorChefe(vendedor);
		}

		// mata recursos
		con.close();
		rs.close();

		return result;
	}

	public void inserir(Departamento departamento) throws SQLException {
		// string de query
		String sql = "INSERT INTO PUBLIC.PUBLIC.DEPARTAMENTO\n"
				+ "(SIGLA, NOME, PERCENTUAL_COMISSAO, FK_COD_VENDEDORCHEFE)\n" + "VALUES(?, ?, ?, ?)";

		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, departamento.getSigla());
		ps.setString(2, departamento.getNome());
		ps.setFloat(3, (float) departamento.getPercentualDeComissao());
		if (null != departamento.getVendedorChefe()) {
			ps.setInt(4, departamento.getVendedorChefe().getCodMatricula());
		} else {
			ps.setNull(4, java.sql.Types.INTEGER);
		}

		ps.executeUpdate();

		// mata recursos
		con.close();

	}

	public void remover(Departamento departamento) throws SQLException {
		// string de query
		String sql = "DELETE FROM DEPARTAMENTO WHERE COD_DEPARTAMENTO=?";

		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, departamento.getCodDepartamento());
		ps.execute();

		// mata recursos
		con.close();

	}

	public void atualizar(Departamento departamento) throws SQLException {
		String sql = "UPDATE DEPARTAMENTO " + "SET SIGLA=?, NOME=?, FK_COD_VENDEDORCHEFE=?, PERCENTUAL_COMISSAO=? "
				+ "WHERE COD_DEPARTAMENTO=?";

		openConnection();

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, departamento.getSigla());
		ps.setString(2, departamento.getNome());
		ps.setInt(3, departamento.getVendedorChefe().getCodMatricula());
		ps.setDouble(4, departamento.getPercentualDeComissao());
		ps.setInt(5, departamento.getCodDepartamento());

		ps.executeUpdate();

		// mata recursos
		con.close();

	}

}
