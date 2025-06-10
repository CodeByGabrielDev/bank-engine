package Interfaces;

import java.util.List;

import Entities.ContaCorrentePf;
import Entities.Enderecamento;

public interface ContaCorrentePfDAO {

	ContaCorrentePf findContaCorrente(int id);

	List<ContaCorrentePf> findAll();

	void insert(ContaCorrentePf contaCorrentePf);

	void update(ContaCorrentePf contaCorrentePf);

	void save(ContaCorrentePf contaCorrentePf);

	void delete(ContaCorrentePf contaCorrentePf);

}
