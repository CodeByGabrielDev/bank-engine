package Entities;

import java.sql.Date;

import Enum.SituacaoContaBancaria;
import Enum.TipoDeConta;

public abstract class ContaCorrente extends ContaBancaria {

	private TipoDeConta corrente;
	
	public ContaCorrente(Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular, Date dataAbertura,
			double saldoAtual, String senha, String bandeiraCartao, int numeroCartao, Date expiraCartao, int cvv,
			SituacaoContaBancaria situacaoConta, TipoDeConta corrente) {
		super(codigoAgencia, primeiroTitular, segundoTitular, dataAbertura, saldoAtual, senha, bandeiraCartao,
				numeroCartao, expiraCartao, cvv, situacaoConta);
		this.corrente = TipoDeConta.CORRENTE;
	}
	/*
	 * public boolean podeSacar(double valor)	Verifica se tem saldo ou limite para saque.
public boolean verificarLimiteCredito()	Verifica se há limite de crédito disponível.
	 */
	
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
	
	
	

}
