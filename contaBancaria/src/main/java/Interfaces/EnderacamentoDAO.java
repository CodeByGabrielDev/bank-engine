package Interfaces;

import java.util.List;

import Entities.Enderecamento;


public interface EnderacamentoDAO {
	
	/*
	 * IMPLEMENT PARA CRUD
	 * VEJA QUE TODOS OS METODOS FAZEM PARTE DO CRUD, SENDO READ O FIND, O CREATE SENDO INSERT,SAVE,UPDATE, O DELETE SENDO DELETE
	 */

	void findEnderecamento(String column1,String column2,String where,String valorWhere);
	List<Enderecamento> findAll();
	void insert(Enderecamento enderecamento);
	void update(String campo, String valor, String whereCampo, String whereValor);
	void save(Enderecamento enderecamento);
	void delete(String where,String whereValue);
	void Delete(String sigla);
	
}
