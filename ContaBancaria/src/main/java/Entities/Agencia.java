package Entities;

import Enum.SituacaoEmpresa;

public class Agencia {

    private long id;
    private Banco codigoFebraban;
    private Enderecamento cep;
    private int numeroEndereco;
    private String complementoEndereco;
    private String telefone;
    private SituacaoEmpresa situacao;

    // Construtor vazio
    public Agencia() {
        this.situacao = SituacaoEmpresa.ativo; // padrão ativo
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Banco getCodigoFebraban() {
        return codigoFebraban;
    }

    public void setCodigoFebraban(Banco codigoFebraban) {
        this.codigoFebraban = codigoFebraban;
    }

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

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public SituacaoEmpresa getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEmpresa situacao) {
        this.situacao = situacao;
    }

    // Métodos auxiliares
    public void desativar() {
        if (this.situacao == SituacaoEmpresa.ativo) {
            this.situacao = SituacaoEmpresa.inativo;
        }
    }

    public void ativar() {
        if (this.situacao == SituacaoEmpresa.inativo) {
            this.situacao = SituacaoEmpresa.ativo;
        }
    }

    public void alterarTelefone(String telefoneNovo) {
        if (this.situacao == SituacaoEmpresa.ativo) {
            this.telefone = telefoneNovo;
        }
    }

    @Override
    public String toString() {
        return "Agencia [id=" + id + 
               ", codigoFebraban=" + codigoFebraban + 
               ", cep=" + cep + 
               ", numeroEndereco=" + numeroEndereco + 
               ", complementoEndereco=" + complementoEndereco + 
               ", telefone=" + telefone + 
               ", situacao=" + situacao + "]";
    }
}
