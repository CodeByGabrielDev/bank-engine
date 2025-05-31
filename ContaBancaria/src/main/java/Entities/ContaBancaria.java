package Entities;

import java.sql.Date;

import Enum.SituacaoContaBancaria;

public abstract class ContaBancaria {
	
	private int id;
	private Agencia codigoAgencia;
	private Pessoa primeiroTitular;
	private Pessoa segundoTitular;
	private Date dataAbertura;
	private double saldoAtual;
	private String senha;
	private String bandeiraCartao;
	private int numeroCartao;
	private Date expiraCartao;
	private int cvv;
	private SituacaoContaBancaria situacaoConta;

	public ContaBancaria() {
		
	}

	public ContaBancaria(int id,Agencia codigoAgencia, Pessoa primeiroTitular, Pessoa segundoTitular, Date dataAbertura,
			double saldoAtual, String senha, String bandeiraCartao, int numeroCartao, Date expiraCartao, int cvv,
			SituacaoContaBancaria situacaoConta) {
		this.id = id;
		this.codigoAgencia = codigoAgencia;
		this.primeiroTitular = primeiroTitular;
		this.segundoTitular = segundoTitular;
		this.dataAbertura = dataAbertura;
		this.saldoAtual = saldoAtual;
		this.senha = senha;
		this.bandeiraCartao = bandeiraCartao;
		this.numeroCartao = numeroCartao;
		this.expiraCartao = expiraCartao;
		this.cvv = cvv;
		this.situacaoConta = SituacaoContaBancaria.ATIVO;

	}

	public Agencia getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(Agencia codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public Pessoa getPrimeiroTitular() {
		return primeiroTitular;
	}

	public void setPrimeiroTitular(Pessoa primeiroTitular) {
		this.primeiroTitular = primeiroTitular;
	}

	public Pessoa getSegundoTitular() {
		return segundoTitular;
	}

	public void setSegundoTitular(Pessoa segundoTitular) {
		this.segundoTitular = segundoTitular;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getBandeiraCartao() {
		return bandeiraCartao;
	}

	public void setBandeiraCartao(String bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	public int getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(int numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Date getExpiraCartao() {
		return expiraCartao;
	}

	public void setExpiraCartao(Date expiraCartao) {
		this.expiraCartao = expiraCartao;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public SituacaoContaBancaria getSituacaoConta() {
		return situacaoConta;
	}

	public void setSituacaoConta(SituacaoContaBancaria situacaoConta) {
		this.situacaoConta = situacaoConta;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void vincularPrimeiraPessoa(Pessoa name) {
		if(name != this.primeiroTitular) {
			this.primeiroTitular = name;
		}
		
	}
	
	public void vincularSegundaPessoa(Pessoa name) {
		if(name != this.segundoTitular){
			this.segundoTitular = name;
		}
	}
	/*
	 * void creditar(double valor) Só credita se valor > 0. void debitar(double
	 * valor) 
	 * Só debita se saldo suficiente ou política da conta permitir.
	 * 
	 */
	

}
