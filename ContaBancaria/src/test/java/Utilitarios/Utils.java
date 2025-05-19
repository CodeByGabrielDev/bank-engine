package Utilitarios;

public class Utils {

	public static boolean validarCep(String cep) {
		// CEP possui 8 digitos, com a possibilidade do HIFEN
		int contador = cep.length();
		if (contador > 8) {
			return false;
		} else {
			return true;
		}

	}
	
	
	public static String validadorCpf(String cpf) {
		String convert = cpf.replace(".", "").replace("-", "");
		return convert;
	}
	
	
	public static boolean formatarCpf(String cpf) {
		String withoutHifen = cpf.replace("-", "").replace(".", "");
		if(withoutHifen.length() == 11) {
			return true;
		}else {
			return false;
		}
	}
	

}
