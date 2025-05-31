package Controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Connection.MySQL;
import Entities.Agencia;
import Entities.ContaCorrente;
import Entities.Pessoa;
import Enum.SituacaoContaBancaria;
import Interfaces.ContaBancariaDAO;

public class ContaBancaria implements ContaBancariaDAO{

	@Override
	public Entities.ContaBancaria findConta(int id) {
		Connection conexao = MySQL.conectar();
		String select = "SELECT * FROM conta_bancaria where id = ?";
		ContaCorrente cb = null;
		Agencia ag = new Agencia();
		try (PreparedStatement ps = conexao.prepareStatement(select)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				/*
				 * private int id;
	private Agencia codigoAgencia;
	private Pessoa primeiroTitular;
	private Pessoa segundoTitular;
	private Date dataAbertura;
	private double saldoAtual;
	private String senha;
	private String bandeiraCartao;
	private int numeroCartao;
	private Date expiraCartao;
	private int cvv;
	private SituacaoContaBancaria situacaoConta;
				 */
				
				AgenciaController agc = new AgenciaController();
				cb = new ContaCorrente();
				cb.setId(rs.getInt("id"));
				cb.setCodigoAgencia(agc.findAgencia(rs.getInt("id_agencia")));
				
				
				/*
				 * Columns:
		id int(11) AI PK 
		id_agencia int(11) 
		id_primeiro_titular int(11) 
		id_segundo_titular int(11) 
		data_abertura date 
		saldo_atual decimal(10,2) 
		senha varchar(30) 
		bandeira_cartao varchar(35) 
		numero_cartao bigint(20) 
		expira_cartao date 
		cvv int(11) 
situacao_conta varchar(30)
				 */
			
				
			}
		}catch(SQLException e) {
			throw new RuntimeException("Erro" +e.getMessage());
		}finally {
			
		}
		return null;
	}

	@Override
	public List<Entities.ContaBancaria> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Entities.ContaBancaria conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Entities.ContaBancaria conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Entities.ContaBancaria conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
