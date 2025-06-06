package Entities;

import java.sql.Date;

import Enum.SituacaoContaBancaria;
import Enum.TipoDeConta;

public class ContaEspecial extends ContaBancaria {

	private double limite;
	private Date vencimento;
	private TipoDeConta especial;

	public ContaEspecial() {

	}

	public ContaEspecial(int id, Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular,
			Date dataAbertura, double saldoAtual, String senha, String bandeiraCartao, int numeroCartao,
			Date expiraCartao, int cvv, SituacaoContaBancaria situacaoConta, double limite, Date vencimento,
			TipoDeConta especial) {
		super(id, codigoAgencia, primeiroTitular, segundoTitular, dataAbertura, saldoAtual, senha, bandeiraCartao,
				numeroCartao, expiraCartao, cvv, situacaoConta);
		this.limite = limite;
		this.vencimento = vencimento;
		this.especial = especial;
	}
	

	public ContaEspecial( Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular,
			Date dataAbertura, double saldoAtual, String senha, String bandeiraCartao, int numeroCartao,
			Date expiraCartao, int cvv, SituacaoContaBancaria situacaoConta, double limite, Date vencimento) {
		super(0, codigoAgencia, primeiroTitular, segundoTitular, dataAbertura, saldoAtual, senha, bandeiraCartao,
				numeroCartao, expiraCartao, cvv, situacaoConta);
		this.limite = limite;
		this.vencimento = vencimento;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	

}
