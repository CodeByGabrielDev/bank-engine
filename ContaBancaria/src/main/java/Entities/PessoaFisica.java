package Entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import Enum.*;

public class PessoaFisica extends Pessoa {
	/*
	 * i. Número do CPF. ii. Nome de registro. iii. Nome social. iv. Data de
	 * nascimento. • Não pode ser uma data futura. v. Sexo. • Utilizar o sexo
	 * biológico acrescido dos termos Cisgênero ou Transgênero. • Pode-se utilizar
	 * um termo neutro para o caso de o cliente não desejar informar. • Não
	 * confundir com orientação sexual. vi. Renda mensal.
	 */
	private String cpf;
	private String nomeDeRegistro;
	private String nomeSocial;
	private Date dataDeNascimento;
	private Sexo sexo;
	private double rendaMensal;

	public PessoaFisica() {

	}
	public PessoaFisica(String cpf,String nomeDeRegistro,String nomeSocial,Date data_nascimento,Sexo sexo,double rendaMensal) {
		this.cpf = cpf;
		this.nomeDeRegistro = nomeDeRegistro;
		this.nomeSocial = nomeSocial;
		this.dataDeNascimento = data_nascimento;
		this.sexo = sexo;
		this.rendaMensal = rendaMensal;
	}
	public PessoaFisica(int id, Enderecamento cep, int numeroEndereco, String compleEndereco, String telefone,
			Date clienteDesde, SituacaoCliente situacao, String cpf, String nomeDeRegistro, String nomeSocial,
			Date dataDeNascimento, Sexo sexo, double rendaMensal) {
		super(id, cep, numeroEndereco, compleEndereco, telefone, clienteDesde, situacao);
		this.cpf = cpf;
		this.nomeDeRegistro = nomeDeRegistro;
		this.nomeSocial = nomeSocial;
		this.dataDeNascimento = dataDeNascimento;
		this.sexo = sexo;
		this.rendaMensal = rendaMensal;
	}

	public PessoaFisica(Enderecamento cep, Sexo sexo, int numeroEndereco, String compleEndereco, String telefone,
			Date clienteDesde, SituacaoCliente situacao, String cpf, String nomeDeRegistro, String nomeSocial,
			Date dataDeNascimento, double rendaMensal,int id) {
		super(0, cep, numeroEndereco, compleEndereco, telefone, clienteDesde, situacao);
		this.cpf = cpf;
		this.nomeDeRegistro = nomeDeRegistro;
		this.nomeSocial = nomeSocial;
		this.dataDeNascimento = dataDeNascimento;
		this.rendaMensal = rendaMensal;
		this.sexo = sexo;
		this.id = id;// 👈 ESSA LINHA é essencial!
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeDeRegistro() {
		return nomeDeRegistro;
	}

	public void setNomeDeRegistro(String nomeDeRegistro) {
		this.nomeDeRegistro = nomeDeRegistro;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public SituacaoCliente validarUsuario(String name) {
		if (name.equalsIgnoreCase(getNomeSocial()) || name.equalsIgnoreCase(getNomeDeRegistro())) {
			return getSituacao();
		}
		return SituacaoCliente.INATIVO;

	}

	public int calcularIdade(String name) {
		if (name.equalsIgnoreCase(getNomeDeRegistro()) || name.equalsIgnoreCase(getNomeSocial())) {
			LocalDate nascimento = dataDeNascimento.toLocalDate();
			LocalDate hoje = LocalDate.now();

			if (nascimento.isAfter(hoje)) {
				throw new IllegalArgumentException("Data de nascimento não pode ser futura.");
			}

			return Period.between(nascimento, hoje).getYears();

		}
		return -1;

	}

	public void alterarRendaMensal(Double quantity) {
		if (super.getSituacao() == SituacaoCliente.ATIVO) {
			this.rendaMensal = quantity;
		} else {
			throw new IllegalArgumentException("Essa pessoa segue inativa.");
		}
	}

	public String formatarCpf() {
		String withoutHifen = this.cpf.replace("-", "").replace(".", "");
		return withoutHifen;
	}

	public boolean validadorCpf() {
		if (formatarCpf().length() == 11) {
			return true;
		} else {
			return false;
		}

	}

	public void alterarNomeSocial(String name) {
		if (super.getSituacao() == SituacaoCliente.ATIVO) {
			this.nomeSocial = name;
		} else {
			throw new IllegalArgumentException("Essa pessoa segue inativa.");
		}

	}

	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + ", nomeDeRegistro=" + nomeDeRegistro + ", nomeSocial=" + nomeSocial
				+ ", dataDeNascimento=" + dataDeNascimento + ", sexo=" + sexo + ", rendaMensal=" + rendaMensal + "]";
	}

}
