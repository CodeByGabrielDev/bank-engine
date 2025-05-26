package Interfaces;

import java.util.List;

import Entities.Enderecamento;


public interface EnderacamentoDAO {
	
	/*
	 * IMPLEMENT PARA CRUD
	 * VEJA QUE TODOS OS METODOS FAZEM PARTE DO CRUD, SENDO READ O FIND, O CREATE SENDO INSERT,SAVE,UPDATE, O DELETE SENDO DELETE
	 */

	Enderecamento findEnderecamento(int id);
	List<Enderecamento> findAll();
	void insert(Enderecamento enderecamento);
	void update(Enderecamento enderecamento);
	void save(Enderecamento enderecamento);
	void delete(Enderecamento enderecamento);
	
}
