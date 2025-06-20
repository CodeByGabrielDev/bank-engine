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
import Entities.Enderecamento;
import Entities.Pessoa;
import Entities.PessoaFisica;
import Entities.PessoaJuridica;
import Enum.Sexo;
import Enum.SituacaoCliente;
import Interfaces.PessoaDAO;

public class PessoaController implements PessoaDAO {

	@Override
	public Pessoa findPessoaFisica(int id) {// select * from pessoa join enderecamento on pessoa.id_enderecamento_cep =
		// enderecamento.id where pessoa.id = 1 ;
		Connection conexao = MySQL.conectar();
		String select = "SELECT * FROM PESSOA_FISICA JOIN PESSOA ON PESSOA.ID = PESSOA_FISICA.ID_PESSOA WHERE PESSOA_FISICA.ID_PESSOA = ?";
		PessoaFisica pessoa = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pessoa = new PessoaFisica();
				EnderecamentoController ec = new EnderecamentoController();
				pessoa.setId(rs.getInt("id"));
				pessoa.setSituacao(SituacaoCliente.fromDescricao(rs.getString("situacao")));
				pessoa.setCep(ec.findEnderecamento(rs.getInt("id_enderecamento_cep")));
				pessoa.setNumeroEndereco(rs.getInt("numero_endereco"));
				pessoa.setCompleEndereco(rs.getString("comple_endereco"));
				pessoa.setTelefone(rs.getString("telefone"));
				pessoa.setClienteDesde(rs.getDate("cliente_desde"));

				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setNomeDeRegistro(rs.getString("nome_registro"));
				pessoa.setNomeSocial(rs.getString("nome_social"));
				pessoa.setDataDeNascimento(rs.getDate("data_nascimento"));
				pessoa.setSexo(Sexo.fromDescricao(rs.getString("sexo")));
				pessoa.setRendaMensal(rs.getDouble("renda_mensal"));

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return pessoa;

	}

	@Override
	public PessoaJuridica findPessoaJuridica(int id) {
		Connection conexao = MySQL.conectar();
		String select = "select * from PESSOA_JURIDICA JOIN PESSOA ON PESSOA_JURIDICA.ID_PESSOA = PESSOA.ID WHERE PESSOA_JURIDICA.ID_PESSOA = ?";
		PessoaJuridica pessoa = null;
		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pessoa = new PessoaJuridica();
				EnderecamentoController ec = new EnderecamentoController();
				PessoaController pc = new PessoaController();
				pessoa.setId(rs.getInt("id"));
				pessoa.setSituacao(SituacaoCliente.fromDescricao(rs.getString("situacao")));
				pessoa.setCep(ec.findEnderecamento(rs.getInt("id_enderecamento_cep")));
				pessoa.setNumeroEndereco(rs.getInt("numero_endereco"));
				pessoa.setCompleEndereco(rs.getString("comple_endereco"));
				pessoa.setTelefone(rs.getString("telefone"));
				pessoa.setClienteDesde(rs.getDate("cliente_desde"));

				pessoa.setDono(pc.findPessoaFisica(rs.getInt("id_pessoa_fisica")));
				pessoa.setCnpj(rs.getString("cnpj"));
				pessoa.setRazaoSocial(rs.getString("razao_social"));
				pessoa.setNomeFantasia(rs.getString("nome_fantasia"));
				pessoa.setAbertura(rs.getDate("abertura"));
				pessoa.setCapitalSocial(rs.getDouble("capital_social"));

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return pessoa;
	}

	@Override
	public List<Pessoa> findAllPessoa() {
		Connection conexao = MySQL.conectar();
		String instrucao = "SELECT * FROM pessoa";
		List<Pessoa> lista = new ArrayList<>();
		Pessoa pessoa = null;
		try (PreparedStatement ps = conexao.prepareStatement(instrucao)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//
				pessoa = new PessoaFisica();
				EnderecamentoController ec = new EnderecamentoController();

				pessoa.setId(rs.getInt("id"));
				pessoa.setCep(ec.findEnderecamento(rs.getInt("id_enderecamento_cep")));
				pessoa.setNumeroEndereco(rs.getInt("numero_endereco"));
				pessoa.setCompleEndereco(rs.getString("comple_endereco"));
				pessoa.setTelefone(rs.getString("telefone"));
				pessoa.setClienteDesde(rs.getDate("cliente_desde"));
				pessoa.setSituacao(SituacaoCliente.fromDescricao(rs.getString("situacao")));
				lista.add(pessoa);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao executar a query" + e.getMessage());

		} finally {
			MySQL.desconectar(conexao);
		}
		return lista;
	}

	@Override
	public List<PessoaFisica> findAllPessoaFisicas() {
		Connection conexao = MySQL.conectar();
		String instrucao = "SELECT * FROM pessoa_fisica";
		List<PessoaFisica> lista = new ArrayList<>();
		PessoaFisica pessoa = null;
		try (PreparedStatement ps = conexao.prepareStatement(instrucao)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//
				pessoa = new PessoaFisica();
				EnderecamentoController ec = new EnderecamentoController();

				pessoa.setId(rs.getInt("id_pessoa"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setNomeDeRegistro(rs.getString("nome_registro"));
				pessoa.setNomeSocial(rs.getString("nome_social"));
				pessoa.setDataDeNascimento(rs.getDate("data_nascimento"));
				pessoa.setSexo(Sexo.fromDescricao(rs.getString("sexo")));
				pessoa.setRendaMensal(rs.getDouble("renda_mensal"));
				lista.add(pessoa);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao executar a query" + e.getMessage());

		} finally {
			MySQL.desconectar(conexao);
		}
		return lista;
	}

	@Override
	public List<PessoaJuridica> findAllJuridicas() {
		Connection conexao = MySQL.conectar();
		String select = "SELECT * FROM pessoa_juridica";
		List<PessoaJuridica> lista = new ArrayList<>();
		PessoaJuridica pessoaJuridica = null;

		try (PreparedStatement ps = conexao.prepareStatement(select)) {
			ResultSet rs = ps.executeQuery();

			PessoaController pc = new PessoaController();
			while (rs.next()) {

				pessoaJuridica = new PessoaJuridica();
				pessoaJuridica.setDono(pc.findPessoaFisica(rs.getInt("id_pessoa_fisica")));
				pessoaJuridica.setCnpj(rs.getString("cnpj"));
				pessoaJuridica.setRazaoSocial(rs.getString("razao_social"));
				pessoaJuridica.setNomeFantasia(rs.getString("nome_fantasia"));
				pessoaJuridica.setAbertura(rs.getDate("abertura"));
				pessoaJuridica.setCapitalSocial(rs.getDouble("capital_social"));
				lista.add(pessoaJuridica);

			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return lista;
	}

	@Override
	public void insertPessoaFisica(Pessoa pessoa) {
		Connection conexao = MySQL.conectar();
		PessoaFisica psPessoa = (PessoaFisica) pessoa;

		final String insertPessoa = "INSERT INTO pessoa(id_enderecamento_cep, numero_endereco, comple_endereco, telefone, cliente_desde, situacao) VALUES (?, ?, ?, ?, ?, ?)";
		final String insertPessoaFisica = "INSERT INTO pessoa_fisica(id_pessoa, cpf, nome_registro, nome_social, data_nascimento, sexo, renda_mensal) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement comandoPessoa = conexao.prepareStatement(insertPessoa,
				PreparedStatement.RETURN_GENERATED_KEYS)) {

			comandoPessoa.setInt(1, pessoa.getCep().getId());
			comandoPessoa.setInt(2, pessoa.getNumeroEndereco());
			comandoPessoa.setString(3, pessoa.getCompleEndereco()); // Correção aqui
			comandoPessoa.setString(4, pessoa.getTelefone());
			comandoPessoa.setDate(5, pessoa.getClienteDesde());
			comandoPessoa.setString(6, pessoa.getSituacao().getDescricao());

			comandoPessoa.executeUpdate();

			// Obter ID gerado
			ResultSet rs = comandoPessoa.getGeneratedKeys();
			if (rs.next()) {
				int idPessoaGerado = rs.getInt(1);

				try (PreparedStatement comandoPf = conexao.prepareStatement(insertPessoaFisica)) {
					comandoPf.setInt(1, idPessoaGerado);
					comandoPf.setString(2, psPessoa.getCpf());
					comandoPf.setString(3, psPessoa.getNomeDeRegistro());
					comandoPf.setString(4, psPessoa.getNomeSocial());
					comandoPf.setDate(5, psPessoa.getDataDeNascimento());
					comandoPf.setString(6, psPessoa.getSexo().getDescricao());
					comandoPf.setDouble(7, psPessoa.getRendaMensal());

					comandoPf.executeUpdate();
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
	public void updatePessoaFisica(Pessoa pessoa) {
		Connection conexao = MySQL.conectar();
		PessoaFisica psF = (PessoaFisica) pessoa;
		final String update = "UPDATE pessoa_fisica set cpf = ?,nome_registro = ?,nome_social = ?,data_nascimento = ?,sexo = ?,renda_mensal = ? where id_pessoa = ? ";
		try (PreparedStatement ps = conexao.prepareStatement(update)) {

			ps.setString(1, psF.getCpf());
			ps.setString(2, psF.getNomeDeRegistro());
			ps.setString(3, psF.getNomeSocial());
			ps.setDate(4, psF.getDataDeNascimento());
			ps.setString(5, psF.getSexo().getDescricao());
			ps.setDouble(6, psF.getRendaMensal());
			ps.setInt(7, psF.getId());

			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao executar o Update" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void save(Pessoa pessoa) {
	    if (pessoa.getId() == 0) { 
	        if (pessoa instanceof PessoaFisica) {
	            insertPessoaFisica(pessoa);
	        } else if (pessoa instanceof PessoaJuridica) {
	            insertPessoaJuridica(pessoa);
	        } else {
	            throw new IllegalArgumentException("Tipo de Pessoa desconhecido para inserção");
	        }
	    } else {
	        if (pessoa instanceof PessoaFisica) {
	            updatePessoa(pessoa);
	            updatePessoaFisica(pessoa);
	        } else if (pessoa instanceof PessoaJuridica) {
	            updatePessoa(pessoa);
	            updatePessoaJuridica(pessoa);
	        } else {
	            throw new IllegalArgumentException("Tipo de Pessoa desconhecido para atualização");
	        }
	    }
	}


	@Override
	public void deletePessoa(int id) {
		Connection conexao = MySQL.conectar();
		final String instrucao = "DELETE FROM pessoa where id = ?";
		try (PreparedStatement ps = conexao.prepareStatement(instrucao)) {
			ps.setInt(1, id);
			ps.execute();

		} catch (SQLException e) {
			throw new RuntimeException("ERRO AO EXECUTAR O DELETE" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void updatePessoa(Pessoa pessoa) {
		Connection conexao = MySQL.conectar();

		final String update = "UPDATE pessoa SET id_enderecamento_cep =?, numero_endereco = ?, comple_endereco = ?,"
				+ "telefone = ?, cliente_desde = ?, situacao = ? WHERE id = ?";
		try (PreparedStatement loco = conexao.prepareStatement(update)) {
			loco.setInt(1, pessoa.getCep().getId());
			loco.setInt(2, pessoa.getNumeroEndereco());
			loco.setString(3, pessoa.getCompleEndereco());
			loco.setString(4, pessoa.getTelefone());
			loco.setDate(5, pessoa.getClienteDesde());
			loco.setString(6, pessoa.getSituacao().getDescricao());
			loco.setInt(7, pessoa.getId());

			loco.execute();

		} catch (SQLException e) {
			throw new RuntimeException("erro ao executar o update " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void updatePessoaJuridica(Pessoa pessoa) {
		Connection conexao = MySQL.conectar();
		PessoaJuridica psF = (PessoaJuridica) pessoa;
		final String update = "UPDATE pessoa_juridica set cnpj = ?,razao_social = ?,nome_fantasia= ?,abertura = ?,capital_social= ? where id_pessoa = ? ";
		try (PreparedStatement ps = conexao.prepareStatement(update)) {

			ps.setString(1, psF.getCnpj());
			ps.setString(2, psF.getRazaoSocial());
			ps.setString(3, psF.getNomeFantasia());
			ps.setDate(4, psF.getAbertura());
			ps.setDouble(5, psF.getCapitalSocial());
			ps.setInt(6, psF.getId());

			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao executar o Update" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void insertPessoaJuridica(Pessoa pessoa) {
	    Connection conexao = MySQL.conectar();
	    PessoaJuridica psPessoa = (PessoaJuridica) pessoa;

	    final String insertPessoa = "INSERT INTO pessoa(id_enderecamento_cep, numero_endereco, comple_endereco, telefone, cliente_desde, situacao) VALUES (?, ?, ?, ?, ?, ?)";
	    final String insertPessoaJuridica = "INSERT INTO pessoa_juridica(id_pessoa, id_pessoa_fisica, cnpj, razao_social, nome_fantasia, abertura, capital_social) VALUES (?, ?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement comandoPessoa = conexao.prepareStatement(insertPessoa,
	            PreparedStatement.RETURN_GENERATED_KEYS)) {

	        comandoPessoa.setInt(1, pessoa.getCep().getId());
	        comandoPessoa.setInt(2, pessoa.getNumeroEndereco());
	        comandoPessoa.setString(3, pessoa.getCompleEndereco());
	        comandoPessoa.setString(4, pessoa.getTelefone());
	        comandoPessoa.setDate(5, pessoa.getClienteDesde());
	        comandoPessoa.setString(6, pessoa.getSituacao().getDescricao());
	        comandoPessoa.executeUpdate();

	        // Obter ID gerado
	        ResultSet rs = comandoPessoa.getGeneratedKeys();
	        if (rs.next()) {
	            int idPessoaGerado = rs.getInt(1);
	            try (PreparedStatement comandoPj = conexao.prepareStatement(insertPessoaJuridica)) {

	                comandoPj.setInt(1, idPessoaGerado);
	                comandoPj.setInt(2, psPessoa.getDono().getId());
	                comandoPj.setString(3, psPessoa.getCnpj());
	                comandoPj.setString(4, psPessoa.getRazaoSocial());
	                comandoPj.setString(5, psPessoa.getNomeFantasia());
	                comandoPj.setDate(6, psPessoa.getAbertura());
	                comandoPj.setDouble(7, psPessoa.getCapitalSocial());

	                comandoPj.executeUpdate();
	            }
	        } else {
	            throw new SQLException("Erro ao obter ID gerado para Pessoa.");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao inserir PessoaJuridica: " + e.getMessage(), e);
	    } finally {
	        MySQL.desconectar(conexao);
	    }
	}


}
