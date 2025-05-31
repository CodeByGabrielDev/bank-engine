package Entities;

import java.sql.Date;

import Enum.SituacaoContaBancaria;
import Enum.TipoDeConta;

public class ContaSalario extends ContaBancaria {

	private PessoaJuridica cnpj;
	private double limite;
	private ContaBancaria portabilidade;
	private TipoDeConta salario;

	public ContaSalario() {

	}

	public ContaSalario(int id, Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular, Date dataAbertura,
			double saldoAtual, String senha, String bandeiraCartao, int numeroCartao, Date expiraCartao, int cvv,
			SituacaoContaBancaria situacaoConta, PessoaJuridica cnpj, double limite, ContaBancaria portabilidade,
			TipoDeConta salario) {
		super(id, codigoAgencia, primeiroTitular, segundoTitular, dataAbertura, saldoAtual, senha, bandeiraCartao,
				numeroCartao, expiraCartao, cvv, situacaoConta);
		this.cnpj = cnpj;
		this.limite = limite;
		this.portabilidade = portabilidade;
		this.salario = TipoDeConta.SALARIO;
	}

	public PessoaJuridica getCnpj() {
		return cnpj;
	}

	public void setCnpj(PessoaJuridica cnpj) {
		this.cnpj = cnpj;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public ContaBancaria getPortabilidade() {
		return portabilidade;
	}
	/*
	 * CNPJ da empresa a qual a conta está associada. • Deverá referenciar a uma
	 * PessoaJuridica existente. ii. iii. Limite para realização de adiantamento
	 * consignado. Conta para a qual será realizada a portabilidade. • Deverá
	 * referenciar a uma ContaBancaria existente, que não seja outra ContaSalario.
	 */

	public TipoDeConta getSalario() {
		return salario;
	}

	public void setPortabilidade(ContaBancaria portabilidade) {
		this.portabilidade = portabilidade;
	}

}
