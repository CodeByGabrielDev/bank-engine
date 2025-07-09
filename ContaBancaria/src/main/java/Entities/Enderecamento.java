package Entities;

public class Enderecamento {
	/*
	 * a) Possui obrigatoriamente os seguintes atributos: i. Identificador único.
	 * ii. Número do CEP. iii. Sigla do estado. iv. Nome do município. v. Nome do
	 * bairro. vi. Nome completo do logradouro. b) Permitir a alteração de seus
	 * dados, exceto do identificador único e do número do CEP.
	 * 
	 */
	private int id;
	private String cep;
	private String estado;
	private String municipio;
	private String bairro;
	private String logradouro;

	public Enderecamento() {
		
	}

	public Enderecamento(String cep, String estado, String municipio, String bairro, String logradouro) {
		this.cep = cep;
		this.estado = estado;
		this.municipio = municipio;
		this.bairro = bairro;
		this.logradouro = logradouro;
	}

	public Enderecamento(String cep, String estado, String municipio, String bairro, String logradouro, int id) {
		this.cep = cep;
		this.id = id;
		this.estado = estado;
		this.municipio = municipio;
		this.bairro = bairro;
		this.logradouro = logradouro;
	}

	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;	
		}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Enderecamento alterarEndereco(Enderecamento endereco) {
		if (this.id == endereco.getId()) {
			this.estado = endereco.getEstado();
			this.municipio = endereco.getMunicipio();
			this.bairro = endereco.getBairro();
			this.logradouro = endereco.getLogradouro();
		} else {
			throw new IllegalArgumentException("Não é possível alterar o identificador ou o CEP.");
		}
		return this;
	}

	public String formatarCep() {
		// Remove qualquer hífen existente
		String cepLimpo = this.cep.replace("-", "");

		// Verifica se tem exatamente 8 dígitos
		if (cepLimpo.length() != 8) {
			throw new IllegalArgumentException("CEP inválido para formatação: deve conter exatamente 8 dígitos.");
		}

		// Formata no padrão 12345-678
		return cepLimpo.substring(0, 5) + "-" + cepLimpo.substring(5);
	}

	public boolean validarCep() {
		String formatacao = this.cep.replace("-", "");

		if (formatacao.length() == 8) {
			return true;
		}
		return false;

	}

	@Override
	public String toString() {
		return "Enderecamento [id=" + id + "\n, cep=" + cep + "\n, estado=" + estado + "\n, municipio=" + municipio
				+ "\n, bairro=" + bairro + "\n, logradouro=" + logradouro + "]";
	}
	

}
