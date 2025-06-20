package Enum;

public enum SituacaoContaBancaria {

	ATIVO("Ativo"), BLOQUEADA("Bloqueada"),ENCERRADA("Encerrada");
	
	private final String descricao;
	private SituacaoContaBancaria(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public static SituacaoContaBancaria fromDescricao(String descricao) {
	    if (descricao == null) {
	        throw new IllegalArgumentException("Descrição da situação não pode ser nula.");
	    }
	    switch (descricao.toLowerCase()) {
	        case "ativo":
	        case "ativa":   // aceita "ativa" também
	            return ATIVO;
	        case "bloqueada":
	            return BLOQUEADA;
	            
	        case "encerrada":
	        	return ENCERRADA;
	        default:
	            throw new IllegalArgumentException("Situação inválida: " + descricao);
	    }
	}
}
