package Entities;

import Enum.SituacaoEmpresa;

public class Agencia {

	/*
	 * a) Possui obrigatoriamente os seguintes atributos: i. Identificador único.
	 * ii. Código FEBRABAN da instituição a qual está vinculada. • Deverá
	 * referenciar a um Banco existente. iii. Número do CEP. • Deverá referenciar a
	 * um Enderecamento existente. iv. Número do endereço. v. Complemento de
	 * endereço. vi. Número do telefone. vii. Situação. • Ativo. • Inativo. ID_BANCO
	 * FK ID_ENDERECAMENTO
	 */

	private int id;
	private Banco codigoFebraban;
	private Enderecamento cep; // REFERENCIAR UM ENDERECAMENTO COM BASE NO CEP(CRIAR METODOS PARA REFERENCIAR)
	private int numeroEndereco;
	private String complementoEndereco;
	private String telefone;
	private SituacaoEmpresa situacao;

	public Agencia() {

	}

	public Agencia(int id, Banco codigoFebraban, Enderecamento cep, int numeroEndereco, String complementoEndereco,
			String telefone) {
		this.codigoFebraban = codigoFebraban;
		this.cep = cep;
		this.numeroEndereco = numeroEndereco;
		this.complementoEndereco = complementoEndereco;
		this.telefone = telefone;
		this.situacao = SituacaoEmpresa.ativo;

	}
	

	public Agencia(Banco codigoFebraban, Enderecamento cep, int numeroEndereco, String complementoEndereco,
			String telefone, SituacaoEmpresa situacao,int id) {
		this.id = id;
		this.codigoFebraban = codigoFebraban;
		this.cep = cep;
		this.numeroEndereco = numeroEndereco;
		this.complementoEndereco = complementoEndereco;
		this.telefone = telefone;
		this.situacao = situacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Banco getCodigoFebraban() {
		return codigoFebraban;
	}

	public void setCodigoFebraban(Banco codigoFebraban) {
		this.codigoFebraban = codigoFebraban;
	}

	public Enderecamento getCep() {
		return cep;
	}

	public void setCep(Enderecamento cep) {
		this.cep = cep;
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public SituacaoEmpresa getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEmpresa situacao) {
		this.situacao = situacao;
	}

	public void desativar() {
		if (this.situacao == SituacaoEmpresa.ativo) {
			this.situacao = SituacaoEmpresa.inativo;
		}

	}

	public void alterarTelefone(String telefoneNovo) {
		if (this.situacao == SituacaoEmpresa.ativo) {
			this.telefone = telefoneNovo;
		}
	}

	public void ativar() {
		if (this.situacao == SituacaoEmpresa.inativo) {
			this.situacao = SituacaoEmpresa.ativo;
		}
	}

	@Override
	public String toString() {
		return "Agencia [id=" + id + ", codigoFebraban=" + codigoFebraban + ", numeroEndereco="
				+ numeroEndereco + ", complementoEndereco=" + complementoEndereco + ", telefone=" + telefone
				+ ", situacao=" + situacao + "]";
	}

}
