package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import Connection.MySQL;
import Entities.Banco;
import Interfaces.BancoDAO;

public class BancoController implements BancoDAO {

	@Override
	public Banco findBanco(int id) {
		Connection conexao = MySQL.conectar();
		Banco banco = null;

		String sql = "SELECT * FROM banco WHERE id = ?";

		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				banco = new Banco();
				banco.setId(rs.getInt("id"));
				banco.setCodigoFebraban(rs.getInt("codigo_febraban"));
				banco.setNome(rs.getString("nome"));
				banco.setMascaraDeUso(rs.getInt("mascara_uso"));
			}

		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao buscar banco por ID: " + ex.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

		return banco;
	}

	@Override
	public List<Banco> findAll() {
		Connection conexao = MySQL.conectar();
		String instrucao = "SELECT * FROM banco";
		PreparedStatement comando = null;
		ResultSet rs = null;
		List<Banco> lista = new ArrayList<>();
		try {
			comando = conexao.prepareStatement(instrucao);
			rs = comando.executeQuery();
			while (rs.next()) {
				Banco banco = new Banco();
				banco.setId(rs.getInt("id"));
				banco.setCodigoFebraban(rs.getInt("codigo_febraban"));
				banco.setNome(rs.getString("nome"));
				banco.setMascaraDeUso(rs.getInt("mascara_uso"));
				lista.add(banco);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao executar a query" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return lista;
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
	public void delete(int id) {
		Connection conexao = MySQL.conectar();
		final String instrucao = "DELETE FROM banco where id = ?";
		
		PreparedStatement comando;
		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setInt(1, id);
		}catch(SQLException e) {
			throw new RuntimeException("ERRO AO EXECUTAR O DELETE, SEGUE ERRO:" +e.getMessage());
		}finally {
			MySQL.desconectar(conexao);
		}

	}

}
