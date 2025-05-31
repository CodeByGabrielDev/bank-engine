	package Application;
	
	import java.sql.Date;
	import java.sql.SQLException;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.Scanner;
	
	import Controllers.AgenciaController;
	import Controllers.BancoController;
	import Controllers.EnderecamentoController;
	import Controllers.PessoaController;
	import Entities.Agencia;
	import Entities.Banco;
	import Entities.Enderecamento;
	import Entities.Pessoa;
	import Entities.PessoaFisica;
	import Enum.Sexo;
	import Enum.SituacaoCliente;
	import Enum.SituacaoEmpresa;
	
	public class App {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			
			/*System.out.println("Digite o ID da agencia: ");
			int idag = sc.nextInt();
			
			AgenciaController agcontr = new AgenciaController();
			Agencia ag;
			
			ag = agcontr.findAgencia(idag);
			
			
			
			System.out.println("Informe o  ID da pessoa");
			int idpessoa = sc.nextInt();
			PessoaController pc = new PessoaController();
			Pessoa p;
			p = pc.findPessoa(idpessoa);
			System.out.println(p);
			
			 private static int ultimoId;
	    private int id;
	    private Enderecamento cep;
	    private int numeroEndereco;
	    private String compleEndereco;
	    private String telefone;
	    private Date clienteDesde;
	    private SituacaoCliente situacao;
	    private String cpf;
		private String nomeDeRegistro;
		private String nomeSocial;
		private Date dataDeNascimento;
		private Sexo sexo;
		private double rendaMensal;
		
			private int id;
		private String cep;
		private String estado;
		private String municipio;
		private String bairro;
		private String logradouro;*/
			
	/*
			
			EnderecamentoController ec = new EnderecamentoController();
			int idEnd = sc.nextInt();
			ec.findEnderecamento(idEnd);
			Enderecamento endereco = ec.findEnderecamento(idEnd); // ou outro id válido

			// Dados lidos do Scanner...
			int numero_endereco = sc.nextInt();
			String complemento = sc.next();
			String telefone = sc.next();
			String cliente_desde = sc.next(); // formato "yyyy-MM-dd"
			LocalDate dataDesde = LocalDate.parse(cliente_desde, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

			SituacaoCliente situacao = SituacaoCliente.ATIVO;
			String cpf = sc.next();
			String nome_registro = sc.next();
			String nome_social = null;
			Sexo sexo = Sexo.MASCULINO;
			LocalDate dataNascimento = LocalDate.parse("2005-03-19", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			double renda_mensal = sc.nextDouble();
			
			// Criação correta do objeto com cep setado
			PessoaFisica pessoa_fisica = new PessoaFisica(
			    endereco,
			    sexo,
			    numero_endereco,
			    complemento,
			    telefone,
			    Date.valueOf(dataDesde),
			    situacao,
			    cpf,
			    nome_registro,
			    nome_social,
			    Date.valueOf(dataNascimento),
			    renda_mensal
			);
			
			// Inserção
			PessoaController pc = new PessoaController();
			pc.insert(pessoa_fisica);
	
			*/
			
			/*
			 * Enderecamento cep, Sexo sexo, int numeroEndereco, String compleEndereco, String telefone,
			Date clienteDesde, SituacaoCliente situacao, String cpf, String nomeDeRegistro, String nomeSocial,
			Date dataDeNascimento, double rendaMensal
			 */
			PessoaController pc = new PessoaController();
			EnderecamentoController ec = new EnderecamentoController();
			int idEnd = sc.nextInt();
			ec.findEnderecamento(idEnd);
			Enderecamento endereco = ec.findEnderecamento(idEnd); // ou outro id válido

			// Dados lidos do Scanner...
			int numero_endereco = sc.nextInt();
			String complemento = sc.next();
			String telefone = sc.next();
			String cliente_desde = sc.next(); // formato "yyyy-MM-dd"
			LocalDate dataDesde = LocalDate.parse(cliente_desde, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

			SituacaoCliente situacao = SituacaoCliente.ATIVO;
			String cpf = sc.next();
			String nome_registro = sc.next();
			String nome_social = sc.next();
			Sexo sexo = Sexo.MASCULINO;
			LocalDate dataNascimento = LocalDate.parse("2005-03-19", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			double renda_mensal = sc.nextDouble();
			int id = sc.nextInt();
			PessoaFisica pessoa_fisica = new PessoaFisica(
				    endereco,
				    sexo,
				    numero_endereco,
				    complemento,
				    telefone,
				    Date.valueOf(dataDesde),
				    situacao,
				    cpf,
				    nome_registro,
				    nome_social,
				    Date.valueOf(dataNascimento),
				    renda_mensal,id
				);
			
			pc.updatePessoaFisica(pessoa_fisica);
	
		}
	
		public static String formatadorDeTamanho(String texto) {
			String textoFormatado = texto.toLowerCase();
			return textoFormatado;
		}
	
	}
