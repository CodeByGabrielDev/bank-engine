package Entities;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import Enum.SituacaoCliente;

public abstract class Pessoa {

    private static int ultimoId;
    protected int id;
    private Enderecamento cep;
    private int numeroEndereco;
    private String compleEndereco;
    private String telefone;
    private Date clienteDesde;
    private SituacaoCliente situacao;

    public Pessoa() {
        this.id = novoId();
        this.situacao = SituacaoCliente.ATIVO;
    }

    public Pessoa(int id, Enderecamento cep, int numeroEndereco, String compleEndereco, String telefone,
                  Date clienteDesde, SituacaoCliente situacao) {
        this.id = id;
        this.cep = cep;
        this.numeroEndereco = numeroEndereco;
        this.compleEndereco = compleEndereco;
        this.telefone = telefone;
        this.clienteDesde = clienteDesde;
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enderecamento getCep() {
        return cep;
    }

    public void setCep(Enderecamento cep) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.cep = cep;
            return;
        }
        throw new IllegalArgumentException("Usuario nao ativo.");
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.numeroEndereco = numeroEndereco;
            return;
        }
        throw new IllegalArgumentException("Usuario nao ativo.");
    }

    public String getCompleEndereco() {
        return compleEndereco;
    }

    public void setCompleEndereco(String compleEndereco) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.compleEndereco = compleEndereco;
            return;
        }
        throw new IllegalArgumentException("Usuario nao ativo.");
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.telefone = telefone;
            return;
        }
        throw new IllegalArgumentException("Usuario nao ativo.");
    }

    public Date getClienteDesde() {
        return clienteDesde;
    }

    public void setClienteDesde(Date clienteDesde) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.clienteDesde = clienteDesde;
            return;
        }
        throw new IllegalArgumentException("Usuario nao ativo.");
    }

    public SituacaoCliente getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCliente situacao) {
        this.situacao = situacao;
    }

    public void alterarEndereco(Enderecamento novoCep) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.cep = novoCep;
        } else {
            throw new IllegalArgumentException("Usuario nao ativo.");
        }
    }

    public static void formatadorDeData(Date data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Método presente, mas não utilizado no momento
    }

    public int novoId() {
        return ++ultimoId;
    }

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", cep=" + cep + ", numeroEndereco=" + numeroEndereco + ", compleEndereco="
				+ compleEndereco + ", telefone=" + telefone + ", clienteDesde=" + clienteDesde + ", situacao="
				+ situacao + "]";
	}
    
}
