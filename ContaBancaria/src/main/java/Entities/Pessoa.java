package Entities;

import java.sql.Date;

import Enum.SituacaoCliente;

public abstract class Pessoa {

	/*
	 * i. Identificador único. ii. Número do CEP. • Deverá referenciar a um
	 * Enderacamento existente. iii. Número do endereço. iv. Complemento de
	 * endereço. v. Número do telefone. vi. Cliente desde. vii. Situação. • Ativo.
	 * c) Permitir a alteração de seus dados, exceto do identificador único e da
	 * situação. i. Somente devem ser acatadas alterações enquanto o status estiver
	 * contendo o valor “Ativo”. d) LISTA DE METODOS
	 * 
	 */

		private static int ultimoId;
		private int id;
		private Enderecamento cep;
		private int numeroEndereco;
		private String compleEndereco;
		private String telefone;
		private Date clienteDesde;
		private SituacaoCliente situacao;

	public Pessoa() {
		this.id = novoId();
		this.situacao = SituacaoCliente.ativo;
	}

	public Pessoa(Enderecamento cep, int numeroEndereco, String compleEndereco, String telefone, Date clienteDesde,
			SituacaoCliente situacao) {
		this.cep = cep;
		this.numeroEndereco = numeroEndereco;
		this.compleEndereco = compleEndereco;
		this.telefone = telefone;
		this.clienteDesde = clienteDesde;
		this.situacao = SituacaoCliente.ativo;
		this.id = novoId();
	}

	public int getId() {
		return id;
	}

	public Enderecamento getCep() {
		return cep;
	}

	public void setCep(Enderecamento cep) {
		if (this.situacao == SituacaoCliente.ativo) {
			this.cep = cep;
		}
		throw new IllegalArgumentException("Usuario nao ativo.");
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {

		if (this.situacao == SituacaoCliente.ativo) {
			this.numeroEndereco = numeroEndereco;
		}
		throw new IllegalArgumentException("Usuario nao ativo");
	}

	public String getCompleEndereco() {
		return compleEndereco;
	}

	public void setCompleEndereco(String compleEndereco) {
		if (this.situacao == SituacaoCliente.ativo) {
			this.compleEndereco = compleEndereco;
		}
		throw new IllegalArgumentException("Usuario nao ativo");
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (this.situacao == SituacaoCliente.ativo) {
			this.telefone = telefone;
		}
		throw new IllegalArgumentException("Usuario nao ativo");
	}

	public Date getClienteDesde() {
		return clienteDesde;
	}

	public void setClienteDesde(Date clienteDesde) {
		if (this.situacao == SituacaoCliente.ativo) {
			this.clienteDesde = clienteDesde;
		}
		throw new IllegalArgumentException("Usuario nao ativo");
	}

	public SituacaoCliente getSituacao() {
		return situacao;
	}

	public void alterarEndereco(Enderecamento novoCep) {
		if (this.situacao == SituacaoCliente.ativo) {
			this.cep = novoCep;
		}
	}

	public int novoId() {
		return ++ultimoId;
	}

}
