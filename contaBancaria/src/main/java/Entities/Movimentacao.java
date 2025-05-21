package Entities;

import java.sql.Date;

import Enum.SituacaoMovimentacao;

public class Movimentacao {

	private static int ultimoId;
	private int id;
	private Date dataEvento;
	private int numeroDaConta;
	private String evento;
	private double valor;
	private SituacaoMovimentacao situacao;

	public Movimentacao() {
		this.id = novoId();
	}

	public Movimentacao(Date dataEvento, int numeroDaConta, String evento, double valor,
			SituacaoMovimentacao situacao) {
		this.dataEvento = dataEvento;
		this.numeroDaConta = numeroDaConta;
		this.evento = evento;
		this.valor = valor;
		this.situacao = SituacaoMovimentacao.CONCILIADO;
		this.id = novoId();
		
	}

	public int novoId() {
		return ++ultimoId;
	}

}
