package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import Connection.MySQL;
import Entities.Banco;
import Interfaces.BancoDAO;

public class BancoController implements BancoDAO {

	@Override
	public Banco findBanco(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banco> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Banco banco) {
		Connection conexao = MySQL.conectar();
		final String instrucao = "INSERT INTO banco(codigo_febraban,nome,mascara_uso)VALUES(?,?,?)";
		PreparedStatement comando;
		/*
		 * private int id; private int codigoFebraban; private String nome; private int
		 * mascaraDeUso;
		 */
		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setInt(1, banco.getCodigoFebraban());
			comando.setString(2, banco.getNome());
			comando.setInt(3, banco.getMascaraDeUso());
			
			
			
			comando.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao executar o insert, confira os commands: " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void update(Banco banco) {
		Connection conexao = MySQL.conectar();
		final String instrucao = "UPDATE banco SET codigo_febraban = ?, nome = ?,mascara_uso = ? where id = ?";
		PreparedStatement comando;
		/*
		 * private int id; private int codigoFebraban; private String nome; private int
		 * mascaraDeUso;
		 */
		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setInt(1, banco.getCodigoFebraban());
			comando.setString(2, banco.getNome());
			comando.setInt(3, banco.getMascaraDeUso());
			comando.setInt(4, banco.getId());
			comando.execute();
			
			

		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao executar o UPDATE, confira os commands: " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}


	}

	@Override
	public void save(Banco banco) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Banco enderecamento) {
		// TODO Auto-generated method stub

	}

}
