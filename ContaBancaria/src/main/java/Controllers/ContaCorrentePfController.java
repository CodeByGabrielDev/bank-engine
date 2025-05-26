package Controllers;

import java.sql.Connection;
import java.util.List;

import Connection.MySQL;
import Entities.ContaCorrentePf;
import Interfaces.ContaCorrentePfDAO;

public class ContaCorrentePfController implements ContaCorrentePfDAO {

	@Override
	public ContaCorrentePf findContaCorrente(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaCorrentePf> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ContaCorrentePf contaCorrentePf) {
		Connection conexao = MySQL.conectar();
		final String instrucao = "INSERT INTO conta_corrente_pf values()";
		
	}

	@Override
	public void update(ContaCorrentePf contaCorrentePf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(ContaCorrentePf contaCorrentePf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ContaCorrentePf contaCorrentePf) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}	
