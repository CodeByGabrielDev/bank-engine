package Enum;

public enum SituacaoEmpresa {
    ativo,
    inativo;

	public static SituacaoEmpresa fromDescricao(String descricao) {
	    if (descricao == null) {
	        throw new IllegalArgumentException("Descrição da situação não pode ser nula.");
	    }
	    switch (descricao.toLowerCase()) {
	        case "ativo":
	        case "ativa":   // aceita "ativa" também
	            return ativo;
	        case "inativo":
	        case "inativa": // aceita "inativa"
	            return inativo;
	        default:
	            throw new IllegalArgumentException("Situação inválida: " + descricao);
	    }
	}

}
