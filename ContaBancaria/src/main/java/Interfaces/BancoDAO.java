package Interfaces;

import java.util.List;

import Entities.Banco;

public interface BancoDAO {
	
	Banco findBanco(int id);
	List<Banco>  findAll();
	void insert(Banco  agencia);
	void update(Banco  agencia);
	void save(Banco agencia);
	void delete(int id);
	
	
}
