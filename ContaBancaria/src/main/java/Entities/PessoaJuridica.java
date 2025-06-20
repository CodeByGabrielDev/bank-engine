package Entities;

import java.sql.Date;


import Enum.SituacaoCliente;

public class PessoaJuridica extends Pessoa{
	
	/*
	 * a)	Possui obrigatoriamente os seguintes atributos:
i.	Número do CNPJ.
ii.	Razão social.
iii.	Nome fantasia.
iv.	Data de abertura.
v.	Quadro societário
vi.	Capital social.
b)	LISTA DE METODOS
	 */
	private String cnpj;
	private String razaoSocial;
	private String nomeFantansia;
	private Date abertura;
	private Pessoa dono;
	private double capitalSocial;
	
	
	public PessoaJuridica() {
		
	}
	public PessoaJuridica( Enderecamento cep, int numeroEndereco, String compleEndereco, String telefone,
			java.sql.Date clienteDesde, SituacaoCliente situacao, String cnpj, String razaoSocial, String nomeFantansia,
			Date abertura, Pessoa dono, double capitalSocial,int id) {
		super(0, cep, numeroEndereco, compleEndereco, telefone, clienteDesde, situacao);
		this.cnpj = cnpj;
		this.dono = dono;
		this.razaoSocial = razaoSocial;
		this.nomeFantansia = nomeFantansia;
		this.abertura = abertura;
		this.id = id;

		this.capitalSocial = capitalSocial;
	}
	public PessoaJuridica( Enderecamento cep, int numeroEndereco, String compleEndereco, String telefone,
			java.sql.Date clienteDesde, SituacaoCliente situacao, String cnpj, String razaoSocial, String nomeFantansia,
			Date abertura, Pessoa dono, double capitalSocial) {
		super(0, cep, numeroEndereco, compleEndereco, telefone, clienteDesde, situacao);
		this.cnpj = cnpj;
		this.dono = dono;
		this.razaoSocial = razaoSocial;
		this.nomeFantansia = nomeFantansia;
		this.abertura = abertura;

		this.capitalSocial = capitalSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantansia;
	}
	public void setNomeFantasia(String nomeFantansia) {
		this.nomeFantansia = nomeFantansia;
	}
	public Date getAbertura() {
		return abertura;
	}
	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}
	public Pessoa getDono() {
		return dono;
	}
	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	public void setNome(Pessoa dono) {
		this.dono = dono;
	}
	public double getCapitalSocial() {
		return capitalSocial;
	}
	public void setCapitalSocial(double capitalSocial) {
		this.capitalSocial = capitalSocial;
	}
	/*
	 * boolean validarCnpj()	Aplica a regra dos dígitos verificadores do CNPJ. 
int calcularTempoAbertura()	Calcula a diferença de anos entre data atual e data de abertura.
boolean capitalSocialValido()	Verifica se capital é positivo.
	 */
	
	public boolean validarCnpj() {
		String formatador = this.cnpj.replace(".", "").replace("/", "").replace("-", "");
		if(formatador.length() == 14) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + "/n, razaoSocial=" + razaoSocial + "/n, nomeFantansia=" + nomeFantansia
				+ "/n, abertura=" + abertura + "/n, dono=" + dono + "/n, capitalSocial=" + capitalSocial + "/n " +super.toString();
	}
	
	
	

}
