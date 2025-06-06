package Entities;

import java.sql.Date;

import Enum.SituacaoContaBancaria;
import Enum.TipoDeConta;

public  class ContaCorrente extends ContaBancaria {

	private int id;
	private TipoDeConta corrente;
	
	public ContaCorrente() {
		
	}
	
	
	
	public ContaCorrente(int id, Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular,
			Date dataAbertura, double saldoAtual, String senha, String bandeiraCartao, int numeroCartao,
			Date expiraCartao, int cvv, SituacaoContaBancaria situacaoConta, TipoDeConta corrente) {
		super(id, codigoAgencia, primeiroTitular, segundoTitular, dataAbertura, saldoAtual, senha, bandeiraCartao,
				numeroCartao, expiraCartao, cvv, situacaoConta);
		this.id = id;
		this.corrente = TipoDeConta.CORRENTE;
	}
	
	public ContaCorrente(Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular,
		    Date dataAbertura, double saldoAtual, String senha, String bandeiraCartao, int numeroCartao,
		    Date expiraCartao, int cvv, SituacaoContaBancaria situacaoConta) {

		    super(0, codigoAgencia, primeiroTitular, segundoTitular, dataAbertura, saldoAtual, senha, bandeiraCartao,
		          numeroCartao, expiraCartao, cvv, situacaoConta);
		    this.corrente = TipoDeConta.CORRENTE;
		}

	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public boolean podeSacar(double saque) {
		if(saque > super.getSaldoAtual()) {
			return false;
		}else {
			return true;
		}
	}
	public TipoDeConta getCorrente() {
		return corrente;
	}

	public void verificarLimiteCredito() {
		if(super.getSaldoAtual() < 1000) {
			System.out.println("Limite de R$600,00");
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	

}
