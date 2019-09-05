package org.sisloja.une.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sisloja.une.model.entities.Cidade;
import org.sisloja.une.model.entities.Cliente;
import org.sisloja.une.model.entities.Endereco;
import org.sisloja.une.model.entities.Estado;

public class ClienteDAOImpl implements ClienteDAO{

	private Connection con;
	
	public ClienteDAOImpl() {
		con = DatabaseConector.getInstance().getConnection();
	}
	public Cliente buscar(int cod) {
		return null;
	}
	
	public Cliente buscarPorCPF(String CPF) throws SQLException{
		//string de query
		String sql = "SELECT * FROM CLIENTE WHERE CPF=?";
		
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
        
        //mata recursos
        con.close();
        rs.close();
        
        return result;
		
	}

	public void inserir(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	public void remover(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	public void remover(int cod) {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Cliente t) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		ClienteDAOImpl clienteDao = new ClienteDAOImpl();
		try {
			Cliente cliente1 = clienteDao.buscarPorCPF("11892288400");
			System.out.println(cliente1.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
