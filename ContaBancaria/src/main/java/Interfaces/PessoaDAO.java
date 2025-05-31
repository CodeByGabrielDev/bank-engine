package Interfaces;

import java.util.List;

import Entities.Banco;
import Entities.Pessoa;

public interface PessoaDAO {
	Pessoa findPessoa(int id);
	List<Pessoa>  findAll();
	void insertPessoaFisica(Pessoa pessoa);
	void insertPessoaJuridica(Pessoa pessoa);
	void updatePessoa(Pessoa pessoa);
	void updatePessoaFisica(Pessoa  pessoa);
	void updatePessoaJuridica(Pessoa pessoa);
	void save(Pessoa pessoa);
	void deletePessoa(int id);
}
