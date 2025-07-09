package Entities;

import java.sql.Date;

import Enum.SituacaoMovimentacao;

public class Movimentacao {
	/*
	 * lasse Movimentacao A classe Movimentacao representa cada uma das operações
	 * (eventos) financeiras, ou não, que foram realizadas sobre as contas
	 * bancárias. Sobre a classe Movimentacao: Possui obrigatoriamente os seguintes
	 * atributos: Identificador único. Data e hora em que ocorreu a operação
	 * (evento). Número da conta bancária na qual ocorreu a operação (evento).
	 * Deverá referenciar a uma ContaBancaria existente. Tipo de operação (evento)
	 * realizada. Deverá referenciar a um Evento existente. Valor envolvido na
	 * operação (evento). Situação. Conciliado Estornado LISTA DE METODOS
	 * 
	 */
	private int id;
	private Evento dataEvento;
	private ContaBancaria numeroDaConta;
	private Evento evento;
	private double valor;
	private SituacaoMovimentacao situacao;

	public Movimentacao() {

	}

	public Movimentacao(Evento dataEvento, ContaBancaria numeroDaConta, Evento evento, double valor,
			SituacaoMovimentacao situacao) {
		this.dataEvento = dataEvento;
		this.numeroDaConta = numeroDaConta;
		this.evento = evento;
		this.valor = valor;
		this.situacao = situacao;

	}

	public Evento getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Evento dataEvento) {
		this.dataEvento = dataEvento;
	}

	public ContaBancaria getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(ContaBancaria numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public SituacaoMovimentacao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoMovimentacao situacao) {
		this.situacao = situacao;
	}

	public int getId() {
		return id;
	}
	
	

	
	
}
