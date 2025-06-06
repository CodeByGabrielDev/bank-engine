package Entities;

import java.sql.Date;

import Enum.SituacaoContaBancaria;
import Enum.TipoDeConta;

public class ContaPoupanca extends ContaBancaria {

	private TipoDeConta poupanca;

	public ContaPoupanca() {
		
	}

	public ContaPoupanca( Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular,
			Date dataAbertura, double saldoAtual, String senha, String bandeiraCartao, int numeroCartao,
			Date expiraCartao, int cvv, SituacaoContaBancaria situacaoConta) {
		super(0, codigoAgencia, primeiroTitular, segundoTitular, dataAbertura, saldoAtual, senha, bandeiraCartao,
				numeroCartao, expiraCartao, cvv, situacaoConta);
		this.poupanca = TipoDeConta.POUPANCA;
	}



	public TipoDeConta getPoupanca() {
		return poupanca;
	}
	
	

	

}
