package Interfaces;

import java.util.List;

import Entities.ContaBancaria;
import Entities.ContaCorrente;

public interface ContaBancariaDAO {
	
	ContaBancaria findConta(int id);
	List<ContaBancaria>  findAll();
	void insert(ContaBancaria  conta);
	void update(ContaBancaria  conta);
	void save(ContaBancaria conta);
	void delete(int id);
}
