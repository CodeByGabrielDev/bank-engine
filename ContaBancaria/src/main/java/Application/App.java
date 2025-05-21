package Application;

import Controllers.EnderecamentoController;
import Entities.Enderecamento;

public class App {

	public static void main(String[] args) {

		
		Enderecamento end = new Enderecamento("89041-400","Santa Catarina","Blumenau","Agua verde","rua");
		
		
		EnderecamentoController ec = new EnderecamentoController();
		
		ec.insert(end);
		
		
		
		

	}

}
