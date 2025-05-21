package Controllers;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Connection.MySQL;
import Interfaces.EnderacamentoDAO;

import Entities.*;

public class EnderecamentoController implements EnderacamentoDAO {

	@Override
	public Enderecamento findEnderecamento(int id) {
		
		return null;
	}

	@Override
	public Enderecamento findEnderecamento(String sigla) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enderecamento> findAll() {
		// TODO Auto-generated method stub
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
	public void update(Enderecamento enderecamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Enderecamento enderecamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int enderecamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(String enderecamento) {
		// TODO Auto-generated method stub
		
	}

	

	


}
