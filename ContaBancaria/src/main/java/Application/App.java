package Application;

import java.sql.SQLException;
import java.util.Scanner;

import Controllers.AgenciaController;
import Controllers.BancoController;
import Controllers.EnderecamentoController;
import Entities.Banco;
import Entities.Enderecamento;
import Enum.SituacaoEmpresa;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		BancoController bc = new BancoController();

		EnderecamentoController ec = new EnderecamentoController();
		AgenciaController ac = new AgenciaController();
		
		
		
		/*
		 * private int id;
		private Banco codigoFebraban;
		private Enderecamento cep; // REFERENCIAR UM ENDERECAMENTO COM BASE NO CEP(CRIAR METODOS PARA REFERENCIAR)
		private int numeroEndereco;
		private String complementoEndereco;
		private String telefone;
		private SituacaoEmpresa situacao;
		 */
		
		
		
		
		
		
		
		

	}

	public static String formatadorDeTamanho(String texto) {
		String textoFormatado = texto.toLowerCase();
		return textoFormatado;
	}

}
