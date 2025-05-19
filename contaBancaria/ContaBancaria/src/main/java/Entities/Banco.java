package Entities;

public class Banco {

	/*
	 * a) Possui obrigatoriamente os seguintes atributos: i. Identificador único.
	 * ii. Código da instituição financeira na FEBRABAN. iii. Nome da instituição
	 * financeira. iv. Máscara para uso do número da conta bancária. b) LISTA DE
	 * METODOS
	 */

	private static int ultimoId;
	private int id;
	private int codigoFebraban;
	private String nome;
	private int mascaraDeUso;

	public Banco() {
		this.id = novoId();
	}

	public Banco(int codigoFebraban, String nome, int mascaraDeUso) {
		this.codigoFebraban = codigoFebraban;
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
		this.codigoFebraban = codigoFebraban;
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

	public int novoId() {
		return ++ultimoId;
	}
}
