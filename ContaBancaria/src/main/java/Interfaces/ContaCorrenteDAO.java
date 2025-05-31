package Interfaces;

import java.util.List;

import Entities.Banco;
import Entities.ContaCorrente;

public interface ContaCorrenteDAO {
	
	ContaCorrente findConta(int id);
	List<ContaCorrente>  findAll();
	void insert(ContaCorrente  conta);
	void update(ContaCorrente  conta);
	void save(ContaCorrente conta);
	void delete(int id);
}
