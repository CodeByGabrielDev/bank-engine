package Application;

import java.sql.SQLException;
import java.util.Scanner;

import Controllers.EnderecamentoController;
import Entities.Enderecamento;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		

		EnderecamentoController ec = new EnderecamentoController();

		System.out.println("Deseja fazer oque ?");
		System.out.println("1 - insert");
		System.out.println("2 - update");
		System.out.println("3 - delete");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			/*
			 * private static int ultimoId;
			private int id;
			private String cep;
			private String estado;
			private String municipio;
			private String bairro;
			private String logradouro;
			 */
			System.out.println("informe os dados ()");
			System.out.println("informe o cep");
			String cep = sc.next();
			sc.nextLine();
			System.out.println("Informe o estado");
			String estado = sc.next().trim();
			sc.nextLine();
			System.out.println("Informe o municipio");
			String municipio = sc.next().trim();
			sc.nextLine();
			System.out.println("Informe o bairro");
			String bairro = sc.next().trim();
			sc.nextLine();
			System.out.println("Informe o logradouro");
			String logradouro = sc.next().trim();
			sc.nextLine();
			Enderecamento end = new Enderecamento(cep,estado,municipio,bairro,logradouro);
			ec.insert(end);
			
			break;

		case 2:
			System.out.println("me informe qual campo deseja alterar");
			String campo = sc.next().trim();
			sc.nextLine();
			System.out.println("Me informe o valor que deseja atribuir?");
			String valor = sc.next().trim();
			sc.nextLine();
			System.out.println("Qual sera o filtro(CEP,estado,municipio,logradouro)?");
			String whereCampo = sc.next().trim();
			sc.nextLine();
			System.out.println("Especifique qual filtro");
			String whereValor = sc.next().trim();
			sc.nextLine();

			campo = formatadorDeTamanho(campo);
			valor = formatadorDeTamanho(valor).replace("-", "");
			whereCampo = formatadorDeTamanho(whereCampo);
			whereValor = formatadorDeTamanho(whereValor).replace("-", "");
			ec.update(campo, valor, whereCampo, whereValor);
			break;
			
			
		case 3:
		
		    System.out.println("Informe qual será o filtro que utilizará (ex: cep, bairro, estado):");
		    String where = sc.next().trim();
		    System.out.println("Informe o valor correspondente ao filtro:");
		    String valueWhere = sc.next().trim();

		    where = formatadorDeTamanho(where);
		    valueWhere = formatadorDeTamanho(valueWhere);

		    ec.delete(where, valueWhere);  
		    System.out.println("Endereçamento removido com sucesso!");
		    break;

			
			
		}

	}

	public static String formatadorDeTamanho(String texto) {
		String textoFormatado = texto.toLowerCase();
		return textoFormatado;
	}

}
