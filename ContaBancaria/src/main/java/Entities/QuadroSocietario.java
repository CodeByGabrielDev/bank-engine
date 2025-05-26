package Entities;

import java.sql.Date;

public class QuadroSocietario {
	
	
	private int id;
	private PessoaJuridica empresa;
	private Pessoa socio;
	private Date dataNascimento;
	private double percentual;
	
	
	public QuadroSocietario() {
		
	}
	
	
	public QuadroSocietario( PessoaJuridica empresa, Pessoa socio, Date dataNascimento, double percentual) {
		this.empresa = empresa;
		this.socio = socio;
		this.dataNascimento = dataNascimento;
		this.percentual = percentual;
	}

	
	public int getId() {
		return id;
	}
	public PessoaJuridica getEmpresa() {
		return empresa;
	}


	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}


	public Pessoa getSocio() {
		return socio;
	}


	public void setSocio(Pessoa socio) {
		this.socio = socio;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public double getPercentual() {
		return percentual;
	}


	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}


	
}
