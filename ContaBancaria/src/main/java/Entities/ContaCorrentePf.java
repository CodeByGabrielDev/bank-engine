package Entities;

import java.sql.Date;

import Enum.SituacaoContaBancaria;
import Enum.TipoDeConta;

public class ContaCorrentePf extends ContaCorrente{

	public ContaCorrentePf(Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular, Date dataAbertura,
			double saldoAtual, String senha, String bandeiraCartao, int numeroCartao, Date expiraCartao, int cvv,
			SituacaoContaBancaria situacaoConta, TipoDeConta corrente) {
		super(codigoAgencia, primeiroTitular, segundoTitular, dataAbertura, saldoAtual, senha, bandeiraCartao,
				numeroCartao, expiraCartao, cvv, situacaoConta, corrente);
	}
	
	
	
	
}
