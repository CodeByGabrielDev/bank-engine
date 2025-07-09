package Entities;

import Enum.SituacaoEvento;
import Enum.TiposDeMovimentacao;

public class Evento {
	/*
	 * i. Identificador único. ii. Descrição do evento. iii. Tipo de movimentação.
	 * iv. Requer uso de senha v. Situação. • Ativo • Inativo b) LISTA DE METODOS
	 */
	private int id;
	private String desc;
	private TiposDeMovimentacao tipoDeMovimentacao;
	private boolean requerSenha;
	private SituacaoEvento situacao;

	public Evento() {
	}

	public Evento(String desc, TiposDeMovimentacao tipoDeMovimentacao, boolean requerSenha, SituacaoEvento situacao) {
		this.desc = desc;
		this.tipoDeMovimentacao = tipoDeMovimentacao;
		this.requerSenha = requerSenha;
		this.situacao = SituacaoEvento.ATIVO;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public TiposDeMovimentacao getTipoDeMovimentacao() {
		return tipoDeMovimentacao;
	}

	public void setTipoDeMovimentacao(TiposDeMovimentacao tipoDeMovimentacao) {
		this.tipoDeMovimentacao = tipoDeMovimentacao;
	}

	public boolean isRequerSenha() {
		if(this.requerSenha == true) {
			return true;
		}else {
			return false;
		}
	}

	public void setRequerSenha(boolean requerSenha) {
		this.requerSenha = requerSenha;
	}

	public SituacaoEvento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEvento situacao) {
		this.situacao = situacao;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Evento /n"
				+ "desc=" + 
				desc + 
				", situacao=" 
				+ situacao + "]";
	}
	
	
	/*
	 * public boolean estaAtivo()	Verifica se o evento está ativo.
public boolean tipoValido()	Verifica se o tipo do evento é permitido pelo sistema.
public String descricaoCompleta()	Retorna a descrição + tipo do evento como string única.
	 */
	
	

}
