package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.MySQL;
import Entities.Agencia;
import Entities.Enderecamento;
import Enum.SituacaoEmpresa;
import Interfaces.AgenciaDAO;

public class AgenciaController implements AgenciaDAO {

	@Override
	public Agencia findAgencia(int id) {
		Connection conexao = MySQL.conectar();
		Agencia ag = null;
		Enderecamento end;
		String instrucao = "SELECT * FROM agencia WHERE id = ?";

		try (PreparedStatement ps = conexao.prepareStatement(instrucao)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				BancoController bc = new BancoController();
				EnderecamentoController endc = new EnderecamentoController();
				end = new Enderecamento();

				ag = new Agencia();

				ag.setId(rs.getInt("id"));

				ag.setCodigoFebraban(bc.findBanco(rs.getInt("id_banco")));
				ag.setCep(endc.findEnderecamento(rs.getInt("id_enderecamento")));
				ag.setNumeroEndereco(rs.getInt("numero_endereco"));
				ag.setComplementoEndereco(rs.getString("complemento_endereco"));
				ag.setTelefone(rs.getString("telefone"));
				ag.setSituacao(SituacaoEmpresa.fromDescricao(rs.getString("situacao_empresa")));

			}

		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao buscar enderecamento por id: " + ex.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return ag;

	}

	@Override
	public List<Agencia> findAll() {
		Connection conexao = MySQL.conectar();
		String instrucao = "SELECT * FROM agencia";
		List<Agencia> lista = new ArrayList<>();
		try (PreparedStatement ps = conexao.prepareStatement(instrucao)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Agencia agencia = new Agencia();
				BancoController bc = new BancoController();
				EnderecamentoController ec = new EnderecamentoController();
				agencia.setCodigoFebraban(bc.findBanco(rs.getInt("id_banco")));
				agencia.setCep(ec.findEnderecamento(rs.getInt("id_enderecamento")));
				agencia.setNumeroEndereco(rs.getInt("numero_endereco"));
				agencia.setComplementoEndereco(rs.getString("complemento_endereco"));
				agencia.setTelefone(rs.getString("telefone"));
				agencia.setSituacao(SituacaoEmpresa.fromDescricao(rs.getString("situacao_empresa")));
				agencia.setId(rs.getInt("id"));
				lista.add(agencia);

			}
		} catch (SQLException e) {
			throw new RuntimeException("erro ao executar a query" + e.getMessage());
		} finally {

		}
		return lista;
	}

	@Override
	public void insert(Agencia agencia) {
		Connection conexao = MySQL.conectar();

		final String instrucao = "INSERT INTO agencia(id_banco,id_enderecamento,numero_endereco,complemento_endereco,telefone,situacao_empresa)VALUES(?,?,?,?,?,?)";
		PreparedStatement comando;

		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setInt(1, agencia.getCodigoFebraban().getId());
			comando.setLong(2, agencia.getCep().getId());
			comando.setLong(3, agencia.getNumeroEndereco());
			comando.setString(4, agencia.getComplementoEndereco());
			comando.setString(5, agencia.getTelefone());
			comando.setString(6, agencia.getSituacao().toString());

			comando.execute();

		} catch (SQLException e) {
			throw new RuntimeException("erro ao executar o insert, por gentileza revise os commands:" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void update(Agencia agencia) {
		Connection conexao = MySQL.conectar();
		final String instrucao = "UPDATE agencia SET id_banco = ?,id_enderecamento = ?,numero_endereco = ?,complemento_endereco = ?,telefone = ?,situacao_empresa = ? where id = ?";
		PreparedStatement comando;

		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setLong(1, agencia.getCodigoFebraban().getId()); // retorna o ID do OBJETO BANCO,
			comando.setInt(2, agencia.getCep().getId());// retorna o ID do objeto ENDERECAMENTO, MUITO UTIL PARA
														// REFERENCIAR OBJETOS
			comando.setInt(3, agencia.getNumeroEndereco());
			comando.setString(4, agencia.getComplementoEndereco());
			comando.setString(5, agencia.getTelefone());
			comando.setString(6, agencia.getSituacao().toString());
			comando.setLong(7, agencia.getId());

			comando.execute();

		} catch (SQLException e) {
			throw new RuntimeException("ERRO AO EXECUTAR O UPDATE, VERIFIQUE O COMANDO " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
	}

	@Override
	public void save(Agencia agencia) {
		if (agencia.getId() == 0) {
			insert(agencia);
		} else {
			update(agencia);
		}
	}

	@Override
	public void delete(int id) {
		Connection conexao = MySQL.conectar();
		final String instrucao = "DELETE FROM agencia WHERE id = ?";

		PreparedStatement comando;

		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setInt(1, id);
			comando.execute();
		} catch (SQLException e) {
			throw new RuntimeException("ERRO AO EXECUTAR O DELETE, VERIFIQUE OS COMANDOS " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

}
