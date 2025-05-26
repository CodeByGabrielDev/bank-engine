package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Connection.MySQL;
import Entities.Agencia;
import Entities.Banco;
import Entities.Enderecamento;
import Enum.SituacaoEmpresa;
import Interfaces.AgenciaDAO;

public class AgenciaController implements AgenciaDAO {

	@Override
	public Agencia findAgencia(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agencia> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Agencia agencia) {
		Connection conexao = MySQL.conectar();
		/*
		 * private int id; private Banco codigoFebraban; private Enderecamento cep; //
		 * REFERENCIAR UM ENDERECAMENTO COM BASE NO CEP(CRIAR METODOS PARA REFERENCIAR)
		 * private int numeroEndereco; private String complementoEndereco; private
		 * String telefone; private SituacaoEmpresa situacao;
		 */
		final String instrucao = "INSERT INTO agencia(id_banco,id_enderecamento,numero_endereco,complemento_endereco,telefone,situacao_empresa)VALUES(?,?,?,?,?,?)";
		PreparedStatement comando;

		try {
			comando = conexao.prepareStatement(instrucao);
			comando.setLong(1, agencia.getCodigoFebraban().getId());
			comando.setLong(2, agencia.getCep().getId());
			comando.setLong(3, agencia.getNumeroEndereco());
			comando.setString(4, agencia.getComplementoEndereco());
			comando.setString(5, agencia.getTelefone());
			comando.setString(6, agencia.getSituacao().toString());

		} catch (SQLException e) {
			throw new RuntimeException("erro ao executar o insert, por gentileza revise os commands:" + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}

	}

	@Override
	public void update(Agencia agencia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Agencia agencia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Agencia agencia) {
		// TODO Auto-generated method stub

	}

}
