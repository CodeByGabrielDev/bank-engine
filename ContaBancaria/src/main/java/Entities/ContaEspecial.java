package Entities;

import java.sql.Date;

import Enum.SituacaoContaBancaria;
import Enum.TipoDeConta;

public class ContaEspecial extends ContaBancaria{
	
	private double limite;
	private Date vencimento;
	private TipoDeConta especial;
	
	
	public ContaEspecial() {
		
	}


	public ContaEspecial(Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular, Date dataAbertura,
			double saldoAtual, String senha, String bandeiraCartao, int numeroCartao, Date expiraCartao, int cvv,
			SituacaoContaBancaria situacaoConta, double limite, Date vencimento, TipoDeConta especial) {
		super(codigoAgencia, primeiroTitular, segundoTitular, dataAbertura, saldoAtual, senha, bandeiraCartao,
				numeroCartao, expiraCartao, cvv, situacaoConta);
		this.limite = limite;
		this.vencimento = vencimento;
		this.especial = TipoDeConta.ESPECIAL;
	}
	

	
	
	
	
	
	
}
