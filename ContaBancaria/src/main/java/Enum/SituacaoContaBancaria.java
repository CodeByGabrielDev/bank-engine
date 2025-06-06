package Enum;

public enum SituacaoContaBancaria {

	ATIVO("Ativo"), BLOQUEADA("Bloqueada"),ENCERRADA("Encerrada");
	
/*
 * private final String descricao;

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
 */
	private final String descricao;
	private SituacaoContaBancaria(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public static SituacaoContaBancaria fromDescricao(String descricao) {
		for(SituacaoContaBancaria s :SituacaoContaBancaria.values()) {
			if(s.getDescricao().equalsIgnoreCase(descricao)) {
				return s;
			}
			
		}
		throw new IllegalArgumentException("Situacao invalida" +descricao);
	}
}
