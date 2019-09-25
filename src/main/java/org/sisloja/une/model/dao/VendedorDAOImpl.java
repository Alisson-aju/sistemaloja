package org.sisloja.une.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sisloja.une.model.entities.Departamento;
import org.sisloja.une.model.entities.Vendedor;
import org.sisloja.une.model.entities.VendedorChefe;

public class VendedorDAOImpl implements VendedorDAO {

	private Connection con;

	/**
	 * Abre conexão com o banco de dados.
	 */
	private void openConnection() {
		con = DatabaseConector.getInstance().getConnection();
	}

	public Vendedor buscar(int cod) throws SQLException {
		String sql = "SELECT " + "* " + "FROM " + "PUBLIC.VENDEDOR AS VENO " + "JOIN PUBLIC.DEPARTAMENTO AS DEPT ON "
				+ "VENO.FK_COD_DEPARTAMENTO = DEPT.COD_DEPARTAMENTO " + "WHERE " + "VENO.COD_MATRICULA = ?";
		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, cod);
		ResultSet rs = ps.executeQuery();

		Vendedor result = null;

		if (rs.next()) {
			result = new Vendedor();
			result.setAtivo(rs.getBoolean("SITUACAO"));
			result.setCodMatricula(rs.getInt("COD_MATRICULA"));
			result.setCpf(rs.getString("CPF"));
			result.setDataAdmissao(rs.getDate("DATA_ADMISSAO"));
			Departamento departamento = new Departamento();
			departamento.setCodDepartamento(rs.getInt("FK_COD_DEPARTAMENTO"));
			departamento.setNome(rs.getString("NOME"));
			departamento.setSigla(rs.getString("SIGLA"));
			departamento.setPercentualDeComissao(rs.getDouble("PERCENTUAL_COMISSAO"));
			result.setDepartamento(departamento);
			result.setNome(rs.getString("NOME_FUNCIONARIO"));
			result.setRg(rs.getString("RG"));

		}

		// mata recursos
		con.close();
		rs.close();

		return result;
	}

	public void inserir(Vendedor vendedor) throws SQLException {
		// string de query
		String sql = "INSERT INTO PUBLIC.PUBLIC.VENDEDOR "
				+ "(COD_MATRICULA, CPF, RG, DATA_ADMISSAO, FK_COD_DEPARTAMENTO, NOME_FUNCIONARIO, SITUACAO) "
				+ "VALUES(?, ?, ?, ?, ?, ?, TRUE)";

		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, vendedor.getCodMatricula());
		ps.setString(2, vendedor.getCpf());
		ps.setString(3, vendedor.getRg());
		ps.setDate(4, (Date) vendedor.getDataAdmissao());
		ps.setInt(5, vendedor.getDepartamento().getCodDepartamento());
		ps.setString(6, vendedor.getNome());

		ps.executeUpdate();

		// mata recursos
		con.close();

	}

	public void remover(Vendedor vendedor) throws SQLException {
		// string de query
		String sql = "DELETE FROM VENDEDOR WHERE COD_MATRICULA=?";

		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, vendedor.getCodMatricula());
		ps.execute();

		// mata recursos
		con.close();

	}

	public void atualizar(Vendedor vendedor) throws SQLException {
		String sql = "UPDATE PUBLIC.PUBLIC.VENDEDOR SET CPF=?, RG=?, DATA_ADMISSAO=?, FK_COD_DEPARTAMENTO=?, NOME_FUNCIONARIO=?, SITUACAO=TRUE WHERE COD_MATRICULA=?";

		openConnection();

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, vendedor.getCpf());
		ps.setString(2, vendedor.getRg());
		ps.setDate(3, (Date) vendedor.getDataAdmissao());
		ps.setInt(4, vendedor.getDepartamento().getCodDepartamento());
		ps.setString(5, vendedor.getNome());
		ps.setInt(6, vendedor.getCodMatricula());


		ps.executeUpdate();

		// mata recursos
		con.close();
	}

	public static void main(String[] args) {
		VendedorDAOImpl d = new VendedorDAOImpl();

		try {
			System.out.println(d.buscar(887887).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
