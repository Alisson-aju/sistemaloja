package org.sisloja.une.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sisloja.une.model.entities.Cidade;
import org.sisloja.une.model.entities.Cliente;
import org.sisloja.une.model.entities.Endereco;
import org.sisloja.une.model.entities.Estado;

public class ClienteDAOImpl implements ClienteDAO {

	private Connection con;

	public ClienteDAOImpl() {
		
	}
	
	/**
	 * Abre conexão com o banco de dados.
	 */
	private void openConnection() {
		con = DatabaseConector.getInstance().getConnection();
	}

	public Cliente buscar(int id) throws SQLException {
		// string de query
		String sql = "SELECT * FROM CLIENTE WHERE id_cliente=?";
		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		Cliente result = null;

		if (rs.next()) {
			result = new Cliente();
			result.setIdCliente(rs.getInt("id_cliente"));
			result.setCPF(rs.getString("CPF"));
			result.setNome(rs.getString("nome"));
			result.setTelefone(rs.getString("telefone"));
			result.setDataNascimento(rs.getDate("data_nascimento"));
			result.setEndereco(new Endereco(rs.getString("rua"), rs.getString("numero"), rs.getString("bairro"),
					new Cidade(rs.getString("cidade"), new Estado(rs.getString("estado"), rs.getString("UF"))),
					rs.getString("cep")));
		}

		// mata recursos
		con.close();
		rs.close();

		return result;
	}

	public Cliente buscarPorCPF(String CPF) throws SQLException {
		// string de query
		String sql = "SELECT * FROM CLIENTE WHERE CPF=?";
		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, CPF);
		ResultSet rs = ps.executeQuery();

		Cliente result = null;

		if (rs.next()) {
			result = new Cliente();
			result.setIdCliente(rs.getInt("id_cliente"));
			result.setCPF(rs.getString("CPF"));
			result.setNome(rs.getString("nome"));
			result.setTelefone(rs.getString("telefone"));
			result.setDataNascimento(rs.getDate("data_nascimento"));
			result.setEndereco(new Endereco(rs.getString("rua"), rs.getString("numero"), rs.getString("bairro"),
					new Cidade(rs.getString("cidade"), new Estado(rs.getString("estado"), rs.getString("UF"))),
					rs.getString("cep")));
		}

		// mata recursos
		con.close();
		rs.close();

		return result;

	}

	public void inserir(Cliente cliente) throws SQLException {
		// string de query
		String sql = "INSERT INTO CLIENTE "
				+ "(CPF, NOME, DATA_NASCIMENTO, TELEFONE, CIDADE, ESTADO, RUA, NUMERO, CEP, BAIRRO, UF) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, cliente.getCPF());
		ps.setString(2, cliente.getNome());
		ps.setDate(3, (Date) cliente.getDataNascimento());
		ps.setString(4, cliente.getTelefone());
		ps.setString(7, cliente.getEndereco().getRua());
		ps.setString(8, cliente.getEndereco().getNumero());
		ps.setString(9, cliente.getEndereco().getCep());
		ps.setString(10, cliente.getEndereco().getBairro());
		ps.setString(5, cliente.getEndereco().getCidade().getNome());
		ps.setString(6, cliente.getEndereco().getCidade().getEstado().getNome());

		ps.setString(11, cliente.getEndereco().getCidade().getEstado().getSigla());
		ps.executeUpdate();

		// mata recursos
		con.close();

	}

	public void remover(Cliente cliente) throws SQLException {
		// string de query
		String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE=?";
		openConnection();
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, cliente.getIdCliente());
		ps.executeUpdate();

		// mata recursos
		con.close();

	}

	public void removerPorCPF(String CPF) throws SQLException {
		// string de query
		String sql = "DELETE FROM CLIENTE WHERE CPF=?";
		openConnection();
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, CPF);
		ps.executeUpdate();

		// mata recursos
		con.close();

	}

	public void atualizar(Cliente cliente) throws SQLException {
		// string de query
		String sql = "UPDATE CLIENTE SET CPF=?, NOME=?, DATA_NASCIMENTO=?, TELEFONE=?, CIDADE=?, ESTADO=?, RUA=?, NUMERO=?, CEP=?, BAIRRO=?, UF=?";
		openConnection();
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, cliente.getCPF());
		ps.setString(2, cliente.getNome());
		ps.setDate(3, (Date) cliente.getDataNascimento());
		ps.setString(4, cliente.getTelefone());
		ps.setString(7, cliente.getEndereco().getRua());
		ps.setString(8, cliente.getEndereco().getNumero());
		ps.setString(9, cliente.getEndereco().getCep());
		ps.setString(10, cliente.getEndereco().getBairro());
		ps.setString(5, cliente.getEndereco().getCidade().getNome());
		ps.setString(6, cliente.getEndereco().getCidade().getEstado().getNome());
		ps.setString(11, cliente.getEndereco().getCidade().getEstado().getSigla());
		ps.executeUpdate();

		// mata recursos
		con.close();

	}

	public static void main(String[] args) {
		ClienteDAOImpl clienteDao = new ClienteDAOImpl();
		try {
			Cliente cliente = clienteDao.buscar(1);
			cliente.setNome("Bruninha");
			clienteDao.atualizar(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
