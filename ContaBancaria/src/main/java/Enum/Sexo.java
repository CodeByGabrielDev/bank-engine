package Enum;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Sexo fromDescricao(String descricao) {
        for (Sexo sexo : Sexo.values()) {
            if (sexo.descricao.equalsIgnoreCase(descricao.trim())) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Sexo inválido: " + descricao);
    }
}
