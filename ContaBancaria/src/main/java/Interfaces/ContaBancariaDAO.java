package Interfaces;

import java.util.List;

import Entities.ContaBancaria;
import Entities.ContaCorrente;
import Entities.ContaEspecial;
import Entities.ContaPoupanca;
import Entities.ContaSalario;
import Entities.Pessoa;
import Entities.PessoaFisica;
import Entities.PessoaJuridica;

public interface ContaBancariaDAO {
	
	ContaCorrente findContaCorrente(int id);
	ContaPoupanca findContaPoupanca(int id);
	ContaSalario findContaSalario(int id);
	ContaEspecial findContaEspecial(int id);
	List<ContaBancaria>  findAllContaBancaria();
	List<ContaCorrente> findAllContaCorrente();
	List<ContaPoupanca> findAllContaPoupanca();
	List<ContaSalario> findAllContaSalario();
	List<ContaEspecial> findAllContaEspecial();
	void insertContaCorrente(ContaBancaria contaCorrente);
	void insertContaPoupanca(ContaBancaria contaPoupanca);
	void insertContaSalario(ContaBancaria contaSalario);
	void insertContaEspecial(ContaBancaria contaEspecial);
	void updateContaBancaria(ContaBancaria pessoa);
	void updateContaCorrente(ContaCorrente  contaCorrente);
	void updateContaPoupanca(ContaPoupanca contaPoupanca);
	void updateContaSalario(ContaSalario contaSalario);
	void updateContaEspecial(ContaEspecial contaEspecial);
	void save(ContaBancaria contaBancaria);
	void deleteContaBancaria(int id);
}
