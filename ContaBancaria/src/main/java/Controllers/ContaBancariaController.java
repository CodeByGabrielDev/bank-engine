package Controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import Connection.MySQL;
import Entities.Agencia;
import Entities.ContaBancaria;
import Entities.ContaCorrente;
import Entities.ContaEspecial;
import Entities.ContaPoupanca;
import Entities.ContaSalario;
import Entities.Pessoa;
import Entities.PessoaFisica;
import Entities.PessoaJuridica;
import Enum.Sexo;
import Enum.SituacaoCliente;
import Enum.SituacaoContaBancaria;
import Interfaces.ContaBancariaDAO;

public class ContaBancariaController implements ContaBancariaDAO {

	@Override
	public ContaCorrente findContaCorrente(int id) {
		Connection conexao = MySQL.conectar();
		String select = "SELECT * FROM conta_bancaria JOIN conta_corrente on conta_bancaria.id = conta_corrente.id_conta_Bancaria where conta_bancaria.id = ?";
		ContaCorrente contaCorrente = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				contaCorrente = new ContaCorrente();
				EnderecamentoController ec = new EnderecamentoController();
				AgenciaController ac = new AgenciaController();
				PessoaController pc = new PessoaController();

				contaCorrente.setId(rs.getInt("id"));
				contaCorrente.setCodigoAgencia(ac.findAgencia(rs.getInt("id_agencia")));
				contaCorrente.setPrimeiroTitular(pc.findPessoaFisica(rs.getInt("id_primeiro_titular")));

				contaCorrente.setSegundoTitular(pc.findPessoaFisica(rs.getInt("id_segundo_titular")));
				contaCorrente.setDataAbertura(rs.getDate("data_abertura"));
				contaCorrente.setSaldoAtual(rs.getDouble("saldo_atual"));
				contaCorrente.setSenha(rs.getString("senha"));
				contaCorrente.setBandeiraCartao(rs.getString("bandeira_cartao"));
				contaCorrente.setNumeroCartao(rs.getInt("numero_cartao"));
				contaCorrente.setExpiraCartao(rs.getDate("expira_cartao"));
				contaCorrente.setCvv(rs.getInt("cvv"));
				contaCorrente.setSituacaoConta(SituacaoContaBancaria.fromDescricao(rs.getString("situacao_conta")));

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return contaCorrente;
	}

	@Override
	public ContaPoupanca findContaPoupanca(int id) {
		Connection conexao = MySQL.conectar();
		String select = "select * from conta_bancaria JOIN conta_poupanca ON conta_poupanca.id_conta_Bancaria = conta_bancaria.id where conta_bancaria.id = ?";
		ContaPoupanca contaPoupanca = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				contaPoupanca = new ContaPoupanca();
				EnderecamentoController ec = new EnderecamentoController();
				AgenciaController ac = new AgenciaController();
				PessoaController pc = new PessoaController();

				contaPoupanca.setId(rs.getInt("id"));
				contaPoupanca.setCodigoAgencia(ac.findAgencia(rs.getInt("id_agencia")));
				contaPoupanca.setPrimeiroTitular(pc.findPessoaFisica(rs.getInt("id_primeiro_titular")));
				contaPoupanca.setSegundoTitular(pc.findPessoaFisica(rs.getInt("id_segundo_titular")));
				contaPoupanca.setDataAbertura(rs.getDate("data_abertura"));
				contaPoupanca.setSaldoAtual(rs.getDouble("saldo_atual"));
				contaPoupanca.setSenha(rs.getString("senha"));
				contaPoupanca.setBandeiraCartao(rs.getString("bandeira_cartao"));
				contaPoupanca.setNumeroCartao(rs.getInt("numero_cartao"));
				contaPoupanca.setExpiraCartao(rs.getDate("expira_cartao"));
				contaPoupanca.setCvv(rs.getInt("cvv"));
				contaPoupanca.setSituacaoConta(SituacaoContaBancaria.fromDescricao(rs.getString("situacao_conta")));

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return contaPoupanca;
	}

	@Override
	public ContaSalario findContaSalario(int id) {
		Connection conexao = MySQL.conectar();
		String select = "select * from conta_corrente JOIN conta_salario ON conta_corrente.id_conta_Bancaria = conta_salario.id_conta_corrente where conta_salario.id_conta_corrente = ?";
		ContaSalario contaSalario = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				contaSalario = new ContaSalario();
				EnderecamentoController ec = new EnderecamentoController();
				AgenciaController ac = new AgenciaController();
				PessoaController pc = new PessoaController();
				ContaBancariaController cb = new ContaBancariaController();

				contaSalario.setCnpj(pc.findPessoaJuridica(rs.getInt("id_conta_juridica")));
				contaSalario.setPortabilidade(cb.findContaCorrente(rs.getInt("id_conta_corrente")));
				contaSalario.setLimite(rs.getDouble("limite"));

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return contaSalario;
	}

	@Override
	public ContaEspecial findContaEspecial(int id) {
		Connection conexao = MySQL.conectar();
		String select = "select * from conta_bancaria JOIN conta_especial ON conta_especial.id_conta_Bancaria = conta_bancaria.id where conta_bancaria.id = ?;";
		ContaEspecial contaEspecial = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				contaEspecial = new ContaEspecial();
				EnderecamentoController ec = new EnderecamentoController();
				AgenciaController ac = new AgenciaController();
				PessoaController pc = new PessoaController();
				ContaBancariaController cb = new ContaBancariaController();

				contaEspecial.setId(rs.getInt("id"));
				contaEspecial.setCodigoAgencia(ac.findAgencia(rs.getInt("id_agencia")));
				contaEspecial.setPrimeiroTitular(pc.findPessoaFisica(rs.getInt("id_primeiro_titular")));
				contaEspecial.setSegundoTitular(pc.findPessoaFisica(rs.getInt("id_segundo_titular")));
				contaEspecial.setDataAbertura(rs.getDate("data_abertura"));
				contaEspecial.setSaldoAtual(rs.getDouble("saldo_atual"));
				contaEspecial.setSenha(rs.getString("senha"));
				contaEspecial.setBandeiraCartao(rs.getString("bandeira_cartao"));
				contaEspecial.setNumeroCartao(rs.getInt("numero_cartao"));
				contaEspecial.setExpiraCartao(rs.getDate("expira_cartao"));
				contaEspecial.setCvv(rs.getInt("cvv"));
				contaEspecial.setSituacaoConta(SituacaoContaBancaria.fromDescricao(rs.getString("situacao_conta")));
				contaEspecial.setLimite(rs.getDouble("limite"));
				contaEspecial.setVencimento(rs.getDate("vencimento"));

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return contaEspecial;
	}

	@Override
	public List<ContaBancaria> findAllContaBancaria() {
		Connection conexao = MySQL.conectar();
		String select = "SELECT * FROM conta_bancaria";
		AgenciaController ac = new AgenciaController();
		PessoaController pc = new PessoaController();
		List<ContaBancaria> list = new ArrayList<>();
		ContaBancaria cb = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				cb = new ContaCorrente();
				cb.setCodigoAgencia(ac.findAgencia(rs.getInt("id_agencia")));
				cb.setPrimeiroTitular(pc.findPessoaFisica(rs.getInt("id_primeiro_titular")));
				cb.setSegundoTitular(pc.findPessoaFisica(rs.getInt("id_segundo_titular")));
				cb.setDataAbertura(rs.getDate("data_abertura"));
				cb.setSaldoAtual(rs.getDouble("saldo_atual"));
				cb.setSenha(rs.getString("senha"));
				cb.setBandeiraCartao(rs.getString("bandeira_cartao"));
				cb.setNumeroCartao(rs.getLong("numero_cartao"));
				cb.setExpiraCartao(rs.getDate("expira_cartao"));
				cb.setSituacaoConta(SituacaoContaBancaria.fromDescricao(rs.getString("situacao_conta")));
				list.add(cb);

			}
		} catch (SQLException e) {
			throw new RuntimeException("ERRO ao executar query " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return list;
	}

	@Override
	public List<ContaCorrente> findAllContaCorrente() {
		Connection conexao = MySQL.conectar();
		String select = "SELECT * FROM conta_corrente";
		AgenciaController ac = new AgenciaController();
		PessoaController pc = new PessoaController();
		List<ContaCorrente> list = new ArrayList<>();
		ContaCorrente cb = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				cb = new ContaCorrente();
				list.add(cb);

			}
		} catch (SQLException e) {
			throw new RuntimeException("ERRO ao executar query " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return list;
	}

	@Override
	public List<ContaPoupanca> findAllContaPoupanca() {
		Connection conexao = MySQL.conectar();
		String select = "SELECT * FROM conta_poupanca";
		AgenciaController ac = new AgenciaController();
		PessoaController pc = new PessoaController();
		List<ContaPoupanca> list = new ArrayList<>();
		ContaPoupanca cb = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				cb = new ContaPoupanca();
				list.add(cb);

			}
		} catch (SQLException e) {
			throw new RuntimeException("ERRO ao executar query " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return list;
	}

	@Override
	public List<ContaSalario> findAllContaSalario() {
		Connection conexao = MySQL.conectar();
		String select = "SELECT * FROM conta_salario";
		AgenciaController ac = new AgenciaController();
		PessoaController pc = new PessoaController();
		ContaBancariaController cbc = new ContaBancariaController();
		List<ContaSalario> list = new ArrayList<>();
		ContaSalario cb = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				cb = new ContaSalario();

				cb.setCnpj(pc.findPessoaJuridica(rs.getInt("id_conta_juridica")));
				cb.setPortabilidade(cbc.findContaCorrente(rs.getInt("id_conta_corrente")));
				cb.setLimite(rs.getDouble("limite"));
				list.add(cb);

			}
		} catch (SQLException e) {
			throw new RuntimeException("ERRO ao executar query " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return list;
	}

	@Override
	public List<ContaEspecial> findAllContaEspecial() {
		Connection conexao = MySQL.conectar();
		String select = "SELECT * FROM conta_especial";
		AgenciaController ac = new AgenciaController();
		PessoaController pc = new PessoaController();
		ContaBancariaController cbc = new ContaBancariaController();
		List<ContaEspecial> list = new ArrayList<>();
		ContaEspecial cb = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				cb = new ContaEspecial();

				list.add(cb);

			}
		} catch (SQLException e) {
			throw new RuntimeException("ERRO ao executar query " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return list;
	}

	@Override
	public void insertContaCorrente(ContaBancaria contaCorrente) {
		Connection conexao = MySQL.conectar();

		ContaCorrente cc = (ContaCorrente) contaCorrente;
		final String insertContaBancaria = "INSERT INTO conta_bancaria(id_agencia, id_primeiro_titular, id_segundo_titular, data_abertura, saldo_atual, senha, bandeira_cartao, numero_cartao, expira_cartao, cvv, situacao_conta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		final String insertContaCorrente = "INSERT INTO conta_corrente(id_conta_Bancaria) VALUES (?)";

		try (PreparedStatement comandoContaBancaria = conexao.prepareStatement(insertContaBancaria,
				PreparedStatement.RETURN_GENERATED_KEYS)) {

			comandoContaBancaria.setLong(1, contaCorrente.getCodigoAgencia().getId());
			comandoContaBancaria.setInt(2, contaCorrente.getPrimeiroTitular().getId());
			if (contaCorrente.getSegundoTitular() == null) {
				comandoContaBancaria.setNull(3, java.sql.Types.INTEGER);
			} else {
				comandoContaBancaria.setInt(3, contaCorrente.getSegundoTitular().getId());
			}

			comandoContaBancaria.setDate(4, contaCorrente.getDataAbertura());
			comandoContaBancaria.setDouble(5, contaCorrente.getSaldoAtual());
			comandoContaBancaria.setString(6, contaCorrente.getSenha());
			comandoContaBancaria.setString(7, contaCorrente.getBandeiraCartao());
			comandoContaBancaria.setLong(8, contaCorrente.getNumeroCartao());
			comandoContaBancaria.setDate(9, contaCorrente.getExpiraCartao());
			comandoContaBancaria.setInt(10, contaCorrente.getCvv());
			comandoContaBancaria.setString(11, contaCorrente.getSituacaoConta().toString());

			comandoContaBancaria.executeUpdate();

			// Obter ID gerado
			ResultSet rs = comandoContaBancaria.getGeneratedKeys();
			if (rs.next()) {
				int idContaBancariaGerada = rs.getInt(1);

				try (PreparedStatement comandoCc = conexao.prepareStatement(insertContaCorrente)) {
					comandoCc.setInt(1, idContaBancariaGerada);
					comandoCc.executeUpdate();
				}
			} else {
				throw new SQLException("Erro ao obter ID gerado para Pessoa.");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir PessoaFisica: " + e.getMessage(), e);
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void insertContaPoupanca(ContaBancaria contaPoupanca) {
		Connection conexao = MySQL.conectar();

		ContaPoupanca cc = (ContaPoupanca) contaPoupanca;
		final String insertContaBancaria = "INSERT INTO conta_bancaria(id_agencia, id_primeiro_titular, id_segundo_titular, data_abertura, saldo_atual, senha, bandeira_cartao, numero_cartao, expira_cartao, cvv, situacao_conta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		final String insertContaCorrente = "INSERT INTO conta_poupanca(id_conta_Bancaria)values(?)";

		try (PreparedStatement comandoContaBancaria = conexao.prepareStatement(insertContaBancaria,
				PreparedStatement.RETURN_GENERATED_KEYS)) {

			comandoContaBancaria.setLong(1, contaPoupanca.getCodigoAgencia().getId());
			comandoContaBancaria.setInt(2, contaPoupanca.getPrimeiroTitular().getId());
			if (contaPoupanca.getSegundoTitular() == null) {
				comandoContaBancaria.setNull(3, java.sql.Types.INTEGER);
			} else {
				comandoContaBancaria.setInt(3, contaPoupanca.getSegundoTitular().getId());
			}

			comandoContaBancaria.setDate(4, contaPoupanca.getDataAbertura());
			comandoContaBancaria.setDouble(5, contaPoupanca.getSaldoAtual());
			comandoContaBancaria.setString(6, contaPoupanca.getSenha());
			comandoContaBancaria.setString(7, contaPoupanca.getBandeiraCartao());
			comandoContaBancaria.setLong(8, contaPoupanca.getNumeroCartao());
			comandoContaBancaria.setDate(9, contaPoupanca.getExpiraCartao());
			comandoContaBancaria.setInt(10, contaPoupanca.getCvv());
			comandoContaBancaria.setString(11, contaPoupanca.getSituacaoConta().toString());

			comandoContaBancaria.executeUpdate();

			// Obter ID gerado
			ResultSet rs = comandoContaBancaria.getGeneratedKeys();
			if (rs.next()) {
				int idContaBancariaGerada = rs.getInt(1);

				try (PreparedStatement comandoCc = conexao.prepareStatement(insertContaCorrente)) {
					comandoCc.setInt(1, idContaBancariaGerada);
					comandoCc.executeUpdate();
				}
			} else {
				throw new SQLException("Erro ao obter ID gerado para Pessoa.");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir PessoaFisica: " + e.getMessage(), e);
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	public void insertContaSalario(ContaBancaria contaSalario) {
		Connection conexao = MySQL.conectar();
		PessoaController pessoa = new PessoaController();
		ContaSalario cc = (ContaSalario) contaSalario;

		final String insertContaBancaria = "INSERT INTO conta_bancaria(id_agencia, id_primeiro_titular, id_segundo_titular, data_abertura, saldo_atual, senha, bandeira_cartao, numero_cartao, expira_cartao, cvv, situacao_conta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		final String insertContaSalario = "INSERT INTO conta_salario(id_pessoa_juridica, id_conta_corrente, limite) VALUES (?, ?, ?)";

		try (PreparedStatement comandoContaBancaria = conexao.prepareStatement(insertContaBancaria,
				PreparedStatement.RETURN_GENERATED_KEYS)) {

			comandoContaBancaria.setLong(1, contaSalario.getCodigoAgencia().getId());

			comandoContaBancaria.setInt(2, contaSalario.getPrimeiroTitular().getId());

			if (contaSalario.getSegundoTitular() == null) {
				comandoContaBancaria.setNull(3, java.sql.Types.INTEGER);
			} else {
				comandoContaBancaria.setInt(3, contaSalario.getSegundoTitular().getId());
			}

			comandoContaBancaria.setDate(4, contaSalario.getDataAbertura());
			comandoContaBancaria.setDouble(5, contaSalario.getSaldoAtual());
			comandoContaBancaria.setString(6, contaSalario.getSenha());
			comandoContaBancaria.setString(7, contaSalario.getBandeiraCartao());
			comandoContaBancaria.setLong(8, contaSalario.getNumeroCartao());
			comandoContaBancaria.setDate(9, contaSalario.getExpiraCartao());
			comandoContaBancaria.setInt(10, contaSalario.getCvv());
			comandoContaBancaria.setString(11, contaSalario.getSituacaoConta().toString());

			comandoContaBancaria.executeUpdate();

			// Obter ID gerado para a nova conta_bancaria
			ResultSet rs = comandoContaBancaria.getGeneratedKeys();
			if (rs.next()) {
				int idContaBancariaGerada = rs.getInt(1);

				try (PreparedStatement comandoCc = conexao.prepareStatement(insertContaSalario)) {
					comandoCc.setInt(1, cc.getCnpj().getId());

					// Aqui está a correção: passar o id da conta corrente para portabilidade
					comandoCc.setInt(2, cc.getPortabilidade().getId());

					comandoCc.setDouble(3, cc.getLimite());

					comandoCc.executeUpdate();
				}
			} else {
				throw new SQLException("Erro ao obter ID gerado para ContaBancaria.");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir ContaSalario: " + e.getMessage(), e);
		} finally {
			MySQL.desconectar(conexao);
		}
	}

	@Override
	public void insertContaEspecial(ContaBancaria contaEspecial) {
		Connection conexao = MySQL.conectar();
		PessoaController pessoa = new PessoaController();
		ContaEspecial cc = (ContaEspecial) contaEspecial;

		final String insertContaBancaria = "INSERT INTO conta_bancaria(id_agencia, id_primeiro_titular, id_segundo_titular, data_abertura, saldo_atual, senha, bandeira_cartao, numero_cartao, expira_cartao, cvv, situacao_conta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		final String insertContaEspecial = "INSERT INTO conta_especial(id_conta_Bancaria, limite, vencimento) VALUES (?, ?, ?)";
		;

		try (PreparedStatement comandoContaBancaria = conexao.prepareStatement(insertContaBancaria,
				PreparedStatement.RETURN_GENERATED_KEYS)) {

			comandoContaBancaria.setLong(1, contaEspecial.getCodigoAgencia().getId());

			comandoContaBancaria.setInt(2, contaEspecial.getPrimeiroTitular().getId());

			if (contaEspecial.getSegundoTitular() == null) {
				comandoContaBancaria.setNull(3, java.sql.Types.INTEGER);
			} else {
				comandoContaBancaria.setInt(3, contaEspecial.getSegundoTitular().getId());
			}

			comandoContaBancaria.setDate(4, contaEspecial.getDataAbertura());
			comandoContaBancaria.setDouble(5, contaEspecial.getSaldoAtual());
			comandoContaBancaria.setString(6, contaEspecial.getSenha());
			comandoContaBancaria.setString(7, contaEspecial.getBandeiraCartao());
			comandoContaBancaria.setLong(8, contaEspecial.getNumeroCartao());
			comandoContaBancaria.setDate(9, contaEspecial.getExpiraCartao());
			comandoContaBancaria.setInt(10, contaEspecial.getCvv());
			comandoContaBancaria.setString(11, contaEspecial.getSituacaoConta().toString());

			comandoContaBancaria.executeUpdate();

			// Obter ID gerado para a nova conta_bancaria
			ResultSet rs = comandoContaBancaria.getGeneratedKeys();
			if (rs.next()) {
				int idContaBancariaGerada = rs.getInt(1);

				try (PreparedStatement comandoCc = conexao.prepareStatement(insertContaEspecial)) {

					comandoCc.setInt(1, idContaBancariaGerada);
					comandoCc.setDouble(2, cc.getLimite());
					comandoCc.setDate(3, cc.getVencimento());
					comandoCc.executeUpdate();

				}
			} else {
				throw new SQLException("Erro ao obter ID gerado para ContaBancaria.");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir ContaSalario: " + e.getMessage(), e);
		} finally {
			MySQL.desconectar(conexao);
		}
	}

	@Override
	public void updateContaBancaria(ContaBancaria pessoa) {
		Connection conexao = MySQL.conectar();
		/*
		 * Columns: id int(11) AI PK id_agencia int(11) id_primeiro_titular int(11)
		 * id_segundo_titular int(11) data_abertura date saldo_atual decimal(10,2) senha
		 * varchar(30) bandeira_cartao varchar(35) numero_cartao bigint(20)
		 * expira_cartao date cvv int(11) situacao_conta varchar(30)
		 */
		final String update = "UPDATE conta_bancaria SET id_agencia = ?,id_primeiro_titular = ?,id_segundo_titular = ?,"
				+ "data_abertura = ?, saldo_atual = ?, senha = ?, bandeira_cartao = ?, numero_cartao = ?, expira_cartao = ?,"
				+ "cvv = ?, situacao_conta = ? where id = ?";
		try (PreparedStatement ps = conexao.prepareStatement(update)) {
			ps.setLong(1, pessoa.getCodigoAgencia().getId());
			ps.setInt(2, pessoa.getPrimeiroTitular().getId());
			ps.setInt(3, pessoa.getSegundoTitular().getId());
			ps.setDate(4, pessoa.getDataAbertura());
			ps.setDouble(5, pessoa.getSaldoAtual());
			ps.setString(6, pessoa.getSenha());
			ps.setString(7, pessoa.getBandeiraCartao());
			ps.setLong(8, pessoa.getNumeroCartao());
			ps.setDate(9, pessoa.getExpiraCartao());
			ps.setInt(10, pessoa.getCvv());
			ps.setString(11, pessoa.getSituacaoConta().getDescricao());
			ps.setInt(12, pessoa.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao executar o update " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
	}

	@Override
	public void updateContaSalario(ContaSalario contaSalario) {
		Connection conexao = MySQL.conectar();
		final String update = "UPDATE conta_salario set id_conta_corrente = ?,limite = ? where id_conta_Bancaria = ?";
		try (PreparedStatement ps = conexao.prepareStatement(update)) {
			ps.setInt(1, contaSalario.getPortabilidade().getId());
			ps.setDouble(2, contaSalario.getLimite());
			ps.setInt(3, contaSalario.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("ERRO AO EXECUTAR UPDATE " + e.getCause());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void updateContaEspecial(ContaEspecial contaEspecial) {
		Connection conexao = MySQL.conectar();
		final String update = "UPDATE conta_especial set limite = ?,vencimento = ? where id_conta_Bancaria = ?";
		try (PreparedStatement ps = conexao.prepareStatement(update)) {
			ps.setDouble(1, contaEspecial.getLimite());
			ps.setDate(2, contaEspecial.getVencimento());
			ps.setInt(3, contaEspecial.getId()); // ID da conta a ser atualizada

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao executar o update " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void save(ContaBancaria contaBancaria) {
		if (contaBancaria.getId() == 0) {
			// Novo registro
			if (contaBancaria instanceof ContaCorrente) {
				insertContaCorrente(contaBancaria);
			} else if (contaBancaria instanceof ContaPoupanca) {
				insertContaPoupanca(contaBancaria);
			} else if (contaBancaria instanceof ContaEspecial) {
				insertContaEspecial(contaBancaria);
			} else if (contaBancaria instanceof ContaSalario) {
				insertContaSalario(contaBancaria);
			} else {
				throw new IllegalArgumentException("Tipo de conta desconhecido.");
			}
		} else {
			// Registro já existe, atualizar dados genéricos
			updateContaBancaria(contaBancaria);

			// Atualizar dados específicos
			if (contaBancaria instanceof ContaEspecial) {
				updateContaEspecial((ContaEspecial) contaBancaria);
			} else if (contaBancaria instanceof ContaSalario) {
				updateContaSalario((ContaSalario) contaBancaria);
			}
			// Contas Corrente e Poupança só têm dados em conta_bancaria
		}
	}

	@Override
	public void deleteContaBancaria(int id) {
		Connection conexao = MySQL.conectar();
		final String delete = "DELETE FROM conta_bancaria where id = ?";

		try (PreparedStatement ps = conexao.prepareStatement(delete)) {
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("ERRO ao executar o delete" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

}
