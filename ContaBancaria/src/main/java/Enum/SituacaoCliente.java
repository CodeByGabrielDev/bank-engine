package Enum;

public enum SituacaoCliente {

    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String descricao;

    SituacaoCliente(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static SituacaoCliente fromDescricao(String descricao) {
        for (SituacaoCliente s : SituacaoCliente.values()) {
            if (s.getDescricao().equalsIgnoreCase(descricao)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Situação inválida: " + descricao);
    }
}
