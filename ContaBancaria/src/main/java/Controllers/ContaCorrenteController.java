package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import Connection.MySQL;
import Entities.ContaCorrente;
import Enum.SituacaoEmpresa;
import Interfaces.ContaCorrenteDAO;

public class ContaCorrenteController implements ContaCorrenteDAO {

	@Override
	public ContaCorrente findConta(int id) {
		Connection conexao = MySQL.conectar();
		String script = "select * from conta_corrente join conta_bancaria on conta_corrente.id_conta_Bancaria = conta_bancaria.id where id_conta_bancaria = ?"; //USAR INNER JOIN
		ContaCorrente cc = null;
		try (PreparedStatement ps = conexao.prepareStatement(script)) {
			ps.setInt(1, id);
			ResultSet select = ps.executeQuery();
			if (select.next()) {
				cc = new ContaCorrente();
				
				
				
			}
		} catch (SQLException e) {
			throw new RuntimeException("ERRO AO EXECUTAR QUERY " + e.getMessage());
		} finally {
			MySQL.desconectar(conexao);
		}
		return null;
	}

	@Override
	public List<ContaCorrente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ContaCorrente conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ContaCorrente conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(ContaCorrente conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
