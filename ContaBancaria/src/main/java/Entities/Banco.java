package Entities;

public class Banco {

	/*
	 * a) Possui obrigatoriamente os seguintes atributos: i. Identificador único.
	 * ii. Código da instituição financeira na FEBRABAN. iii. Nome da instituição
	 * financeira. iv. Máscara para uso do número da conta bancária. b) LISTA DE
	 * METODOS
	 */

	private int id;
	private int codigoFebraban;
	private String nome;
	private int mascaraDeUso;

	public Banco() {
		
	}

	public Banco(int codigoFebraban, String nome, int mascaraDeUso,int id) {
		this.codigoFebraban = codigoFebraban;
		this.id = id;
		this.nome = nome;
		this.mascaraDeUso = mascaraDeUso;
	}

	public int getId() {
		return id;
	}

	public int getCodigoFebraban() {
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
	
	/*
	 * boolean validarCodigoFebraban()	Verifica se o código tem entre 3.

	 */
	
	
	
	
}
