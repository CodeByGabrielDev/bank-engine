package Controllers;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import Connection.MySQL;
import Interfaces.EnderacamentoDAO;

import Entities.*;

public class EnderecamentoController implements EnderacamentoDAO {

	@Override
	public void findEnderecamento(String column1,String column2,String where, String valorWhere) {
		
		
	}

	
	
	@Override
	public List<Enderecamento> findAll() {
		return null;
		
		
		
	}

	@Override
	public void insert(Enderecamento enderecamento) {
		Connection conexao = MySQL.conectar(); //fazer a CONEXAO
		final String instrucao = "INSERT INTO tbEnderecamento(cep,estado,municipio,bairro,logradouro)VALUES(?,?,?,?,?)";
		PreparedStatement comando;
		
		try {
		comando = conexao.prepareStatement(instrucao);
		comando.setString(1, enderecamento.getCep());
		comando.setString(2, enderecamento.getEstado());
		comando.setString(3, enderecamento.getMunicipio());
		comando.setString(4, enderecamento.getBairro());
		comando.setString(5, enderecamento.getLogradouro());
		
		
		comando.execute();
		}catch (SQLException e) {
			throw new RuntimeException("Error");
		}
		finally {
			MySQL.desconectar(conexao);
		}
	}
	@Override
	public void update(String campo, String valor, String whereCampo, String whereValor) {
		Connection conexao = MySQL.conectar();
		
		final String instrucao = "UPDATE tbEnderecamento SET " + campo + " = ? WHERE " + whereCampo + " = ?";
		PreparedStatement comando;
		
		try {
		comando = conexao.prepareStatement(instrucao);
		comando.setString(1, valor);
		comando.setString(2, whereValor);
		
		comando.executeUpdate();
			
		}catch(SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao executar o UPDATE, com a seguinte mensagem" +e.getMessage());
		}
	}
	
	

	@Override
	public void save(Enderecamento enderecamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String where,String whereValue) {
		Connection conexao = MySQL.conectar();
		final String instrucao = "DELETE FROM tbEnderecamento where " +where+ " = ? "; //delete from tbenderecamento where bairro = '';
		PreparedStatement comando;
		
		
		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setString(1, whereValue);
			
			comando.executeUpdate();
			
			
			
		}catch(SQLException e) {
			throw new RuntimeException("Erro ao realizar o delete" +e.getMessage());
		}
		
		
		
		
	}

	@Override
	public void Delete(String enderecamento) {
		// TODO Auto-generated method stub
		
	}

	

	


}
