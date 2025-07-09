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

    // Setters simples para uso interno, sem validação
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

    public String getCompleEndereco() {
        return compleEndereco;
    }

    public void setCompleEndereco(String compleEndereco) {
        this.compleEndereco = compleEndereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getClienteDesde() {
        return clienteDesde;
    }

    public void setClienteDesde(Date clienteDesde) {
        this.clienteDesde = clienteDesde;
    }

    public SituacaoCliente getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCliente situacao) {
        this.situacao = situacao;
    }

    // Métodos para alteração que validam se o usuário está ativo
    public void alterarCep(Enderecamento novoCep) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.cep = novoCep;
        } else {
            throw new IllegalArgumentException("Usuário não ativo.");
        }
    }

    public void alterarNumeroEndereco(int novoNumero) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.numeroEndereco = novoNumero;
        } else {
            throw new IllegalArgumentException("Usuário não ativo.");
        }
    }

    public void alterarCompleEndereco(String novoComple) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.compleEndereco = novoComple;
        } else {
            throw new IllegalArgumentException("Usuário não ativo.");
        }
    }

    public void alterarTelefone(String novoTelefone) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.telefone = novoTelefone;
        } else {
            throw new IllegalArgumentException("Usuário não ativo.");
        }
    }

    public void alterarClienteDesde(Date novaData) {
        if (this.situacao == SituacaoCliente.ATIVO) {
            this.clienteDesde = novaData;
        } else {
            throw new IllegalArgumentException("Usuário não ativo.");
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
        return "Pessoa [id=" + id + "\n, cep=" + cep + "\n, numeroEndereco=" + numeroEndereco + "\n, compleEndereco="
                + compleEndereco + "\n, telefone=" + telefone + "\n, clienteDesde=" + clienteDesde + "\n, situacao="
                + situacao + "]";
    }

}
