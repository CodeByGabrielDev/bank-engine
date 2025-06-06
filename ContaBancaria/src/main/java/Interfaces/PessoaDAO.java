package Interfaces;

import java.util.List;

import Entities.Banco;
import Entities.Pessoa;
import Entities.PessoaFisica;
import Entities.PessoaJuridica;

public interface PessoaDAO {
	Pessoa findPessoaFisica(int id);
	PessoaJuridica findPessoaJuridica(int id);
	List<Pessoa>  findAllPessoa();
	List<PessoaFisica> findAllPessoaFisicas();
	List<PessoaJuridica> findAllJuridicas();
	void insertPessoaFisica(Pessoa pessoa);
	void insertPessoaJuridica(Pessoa pessoa);
	void updatePessoa(Pessoa pessoa);
	void updatePessoaFisica(Pessoa  pessoa);
	void updatePessoaJuridica(Pessoa pessoa);
	void save(Pessoa pessoa);
	void deletePessoa(int id);
}
