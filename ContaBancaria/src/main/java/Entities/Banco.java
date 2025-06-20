package Entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	/*
	 * a) Possui obrigatoriamente os seguintes atributos: i. Identificador único.
	 * ii. Código da instituição financeira na FEBRABAN. iii. Nome da instituição
	 * financeira. iv. Máscara para uso do número da conta bancária. b) LISTA DE
	 * METODOS
	 */

	private long id;
	private long codigoFebraban;
	private String nome;
	private int mascaraDeUso;


	public Banco() {
		
	}

	public Banco(int codigoFebraban, String nome, int mascaraDeUso) {
		this.codigoFebraban = codigoFebraban;
		this.nome = nome;
		this.mascaraDeUso = mascaraDeUso;
	}
	public Banco(int codigoFebraban, String nome, int mascaraDeUso,int id) {
		this.codigoFebraban = codigoFebraban;
		this.nome = nome;
		this.mascaraDeUso = mascaraDeUso;
		this.id = id;
	}
	

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public long getCodigoFebraban() {
		return codigoFebraban;
	}

	public void setCodigoFebraban(int codigoFebraban) {
		if(this.codigoFebraban >=1000 || this.codigoFebraban <0) {
			throw new IllegalArgumentException("Codigo invalidado" );
		}else {
			this.codigoFebraban = codigoFebraban;
		}
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMascaraDeUso() {
		return mascaraDeUso;
	}

	public void setMascaraDeUso(int mascaraDeUso) {
		this.mascaraDeUso = mascaraDeUso;
	}

	@Override
	public String toString() {
		return "Banco [id=" + id + "\n, codigoFebraban=" + codigoFebraban + "\n, nome=" + nome + "\n, mascaraDeUso="
				+ mascaraDeUso + "]";
	}
	
	/*
	 * boolean validarCodigoFebraban()	Verifica se o código tem entre 3.

	 */
	
	
	
	
}
