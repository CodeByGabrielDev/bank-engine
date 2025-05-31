package Controllers;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import Connection.MySQL;
import Interfaces.EnderacamentoDAO;

import Entities.*;

public class EnderecamentoController implements EnderacamentoDAO {

	
	@Override
		public Enderecamento findEnderecamento(int id) {
		    Connection conexao = MySQL.conectar();
		    Enderecamento e = null;

		    String instrucao = "SELECT * FROM enderecamento WHERE id = ?";

		    try (PreparedStatement ps = conexao.prepareStatement(instrucao)) {
		        ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		            e = new Enderecamento();
		            e.setId(rs.getInt("id"));
		            e.setCep(rs.getString("cep"));
		            e.setEstado(rs.getString("estado"));
		            e.setMunicipio(rs.getString("municipio"));
		            e.setBairro(rs.getString("bairro"));
		            e.setLogradouro(rs.getString("logradouro"));
		        }

		    } catch (SQLException ex) {
		        throw new RuntimeException("Erro ao buscar enderecamento por id: " + ex.getMessage());
		    } finally {
		        MySQL.desconectar(conexao);
		    }
		    return e;
		}

	


	@Override
	public List<Enderecamento> findAll() {
		return null;
	}

	@Override
	public void insert(Enderecamento enderecamento) {
		Connection conexao = MySQL.conectar(); // fazer a CONEXAO
		final String instrucao = "INSERT INTO enderecamento(cep,estado,municipio,bairro,logradouro)VALUES(?,?,?,?,?)";
		PreparedStatement comando;

		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setString(1, enderecamento.getCep());
			comando.setString(2, enderecamento.getEstado());
			comando.setString(3, enderecamento.getMunicipio());
			comando.setString(4, enderecamento.getBairro());
			comando.setString(5, enderecamento.getLogradouro());

			comando.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Error");
		} finally {
			MySQL.desconectar(conexao);
		}
	}

	@Override
	public void update(Enderecamento e) {
	    Connection conexao = MySQL.conectar();
	    final String sql = "UPDATE enderecamento SET cep=?, estado=?, municipio=?, bairro=?, logradouro=? WHERE id=?";
	    try {
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setString(1, e.getCep());
	        stmt.setString(2, e.getEstado());
	        stmt.setString(3, e.getMunicipio());
	        stmt.setString(4, e.getBairro());
	        stmt.setString(5, e.getLogradouro());
	        stmt.setInt(6, e.getId());
	        stmt.executeUpdate();
	    } catch (SQLException ex) {
	        throw new RuntimeException("Erro ao atualizar: " + ex.getMessage());
	    } finally {
	        MySQL.desconectar(conexao);
	    }
	}

	@Override
	public void save(Enderecamento enderecamento) {
		if(enderecamento.getId() == 0) {
			insert(enderecamento);
		}else {
			update(enderecamento);
		}
		

	}

	@Override
	public void delete(Enderecamento enderecamento) {
		Connection conexao = MySQL.conectar();
		final String instrucao = "DELETE FROM enderecamento where id= ? "; // delete from tbenderecamento
																							// where bairro = '';
		PreparedStatement comando;

		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setInt(1, enderecamento.getId());

			comando.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao realizar o delete" + e.getMessage());
		}

	}

	

}
