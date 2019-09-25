package org.sisloja.une.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sisloja.une.model.entities.Produto;

public class ProdutoDAO {
	
	private Connection con;
	
	public ProdutoDAO() {
		
	}
	
	private void openConnection() {
		con = DatabaseConector.getInstance().getConnection();
	}
	
	public Produto buscar(int cod) throws SQLExcepcion {
		
		String sql = "SELECT * FROM PRODUTO WHERE cod_produto";
		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, cod);
		ResultSet rs = ps.executeQuery();
		
		Produto result = null
				
		if(rs.next()) {
			result new Produto();
			result.setCodProduto(rs.getInt("codProduto"));
			result.setDepartamento(rs.getString("departamento"));
			result.setDescricao(rs.getString("descricao"));
			result.setNome(rs.getString("nome"));
			result.setPrecoDeVenda(rs.getDouble("preçoDeVenda"));
			result.setQuantidadeEmEstoque(rs.getInt("quantidadeEmEstoque"));
			
		}
		
		con.close();
		rs.close();
		
		return result;
		
	}
	
	public void inserir(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO "
				+ "(DEPARTAMENTO, DESCRICAO, NOME, PRECO_DE_VENDA, QUANTIDADE_EM_ESTOQUE) "
				+ "VALUES(?, ?, ?, ?, ?);";

		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, produto.getDepartamento());
		ps.setString(2, produto.getDescricao());
		ps.setString(3, produto.getNome());
		ps.setDouble(4, produto.getPrecoDeVenda());
		ps.setInt(5, produto.getQuantidadeEmEstoque());
		
		ps.executeUpdate();

		con.close();
		
	}
	
	public void removerPorCod(int cod) throws SQLException {
		String sql = "DELETE FROM PRODUTO WHERE cod=?";
		openConnection();
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, cod);
		
		ps.executeUpdate();

		con.close();

	}
	
	public void atualizar(Produto produto) throws SQLException {

		String sql = "UPDATE PRODUTO SET DEPARTAMENTO=?, DESCRICAO=?, NOME=?, PRECO_DE_VENDA=?, QUANTIDADE_EM_ESTOQUE=?";
		openConnection();
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, produto.getDepartamento());
		ps.setString(2, produto.getDescricao());
		ps.setString(3, produto.getNome());
		ps.setDouble(4, produto.getPrecoDeVenda());
		ps.setInt(5, produto.getQuantidadeEmEstoque());
		
		ps.executeUpdate();

		con.close();
		
	}


}
