package Enum;

public enum SituacaoEmpresa {

    ativo("Ativo"),
    inativo("Inativo");

    private final String descricao;

    SituacaoEmpresa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    @Override
    public String toString() {
        return descricao;
    }

   
}
