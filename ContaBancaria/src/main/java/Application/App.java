	package Application;
	
	import java.sql.Date;
	import java.sql.SQLException;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.Scanner;
	
	import Controllers.AgenciaController;
	import Controllers.BancoController;
import Controllers.ContaBancariaController;
import Controllers.EnderecamentoController;
	import Controllers.PessoaController;
	import Entities.Agencia;
	import Entities.Banco;
import Entities.ContaBancaria;
import Entities.ContaCorrente;
import Entities.ContaPoupanca;
import Entities.ContaSalario;
import Entities.Enderecamento;
	import Entities.Pessoa;
	import Entities.PessoaFisica;
import Entities.PessoaJuridica;
import Enum.Sexo;
	import Enum.SituacaoCliente;
import Enum.SituacaoContaBancaria;
import Enum.SituacaoEmpresa;
import Enum.TipoDeConta;
	
	public class App {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			
			ContaBancariaController cbc = new ContaBancariaController();
			AgenciaController ac = new AgenciaController();
			PessoaController pessoa = new PessoaController();
			BancoController banco = new BancoController();
			EnderecamentoController ec = new EnderecamentoController();
			
			
			/*
			 * private int id;
	private Agencia codigoAgencia;
	private Pessoa primeiroTitular;
	private Pessoa segundoTitular;
	private Date dataAbertura;
	private double saldoAtual;
	private String senha;
	private String bandeiraCartao;
	private int numeroCartao;
	private Date expiraCartao;
	private int cvv;
	private SituacaoContaBancaria situacaoConta;
	private PessoaJuridica cnpj;
	private double limite;
	private ContaBancaria portabilidade;
	private TipoDeConta salario;
			 */
		
			Agencia findAgencia = ac.findAgencia(1);
			Pessoa findPrimeiroTitular = pessoa.findPessoaFisica(5);
			Pessoa segundoTitular = null;
			LocalDate data_abertura = LocalDate.parse("2020-04-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			double saldo_atual = sc.nextDouble();
			String senha = sc.next();
			String bandeira = sc.next();
			int numero = sc.nextInt();
			LocalDate data_expiracao = LocalDate.parse("2024-03-19", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			int cvv = sc.nextInt();
			SituacaoContaBancaria situacao = SituacaoContaBancaria.ATIVO;
			PessoaJuridica cnpj = pessoa.findPessoaJuridica(6);
			double limite =sc.nextDouble();
			ContaBancaria portabilidade = cbc.findContaCorrente(6);
			System.out.println("ID portabilidade: " + portabilidade.getId());
			ContaSalario contaSalario = new ContaSalario(findAgencia, findPrimeiroTitular, segundoTitular, Date.valueOf(data_abertura), saldo_atual, senha, bandeira, numero, Date.valueOf(data_expiracao), cvv, situacao, cnpj, limite, portabilidade);
			cbc.insertContaSalario(contaSalario);
			/*
			private Agencia codigoAgencia;
	private Pessoa primeiroTitular;
	private Pessoa segundoTitular;
	private Date dataAbertura;
	private double saldoAtual;
	private String senha;
	private String bandeiraCartao;
	private int numeroCartao;
	private Date expiraCartao;
	private int cvv;
	private SituacaoContaBancaria situacaoConta;
			*/
			
			//INSERT IN PESSOA_JURIDICA
			/*
			 *  private static int ultimoId;
    protected int id;
    private Enderecamento cep;
    private int numeroEndereco;
    private String compleEndereco;
    private String telefone;
    private Date clienteDesde;
    private SituacaoCliente situacao;
    private String cnpj;
	private String razaoSocial;
	private String nomeFantansia;
	private Date abertura;
	private Pessoa dono;
	private double capitalSocial;
			 */
			//INSERT PESSOA JURIDICA
			/*
			Enderecamento cep = ec.findEnderecamento(2);
			int numeroEnd = sc.nextInt();
			String complemento =sc.next();
			String telefone = sc.next();
			LocalDate cliente_desde = LocalDate.parse("2012-11-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			SituacaoCliente situacao = SituacaoCliente.ATIVO;
			String cnpj = sc.next();
			String razao = sc.next();
			String nomeFantasia = sc.next();
			LocalDate abertura = LocalDate.parse("2019-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Pessoa dono = pessoa.findPessoaFisica(5);
			double capitalsocial = sc.nextDouble();
			
			PessoaJuridica pessoaJ = new PessoaJuridica( cep, numeroEnd, complemento, telefone, Date.valueOf(cliente_desde), situacao, cnpj, razao, nomeFantasia, Date.valueOf(abertura), dono, capitalsocial);
			pessoa.insertPessoaJuridica(pessoaJ);
			*/
			/*
			 * private PessoaJuridica cnpj;
	private double limite;
	private ContaBancaria portabilidade;
	private TipoDeConta salario;
			 */
			
			
			
			/*
			 * private int id;
			private int codigoFebraban;
			private String nome;
			private int mascaraDeUso;
			
			private int id;
	private String cep;
	private String estado;
	private String municipio;
	private String bairro;
	private String logradouro;
			 */
			
			/*
			String cep =sc.next();
			String estado = sc.next();
			String municipio = sc.next();
			String bairro = sc.next();
			String logradouro = sc.next();
			
			Enderecamento end = new Enderecamento(cep,estado,municipio,bairro,logradouro);
			ec.insert(end);
			
			private int id;
	private Banco codigoFebraban;
	private Enderecamento cep; // REFERENCIAR UM ENDERECAMENTO COM BASE NO CEP(CRIAR METODOS PARA REFERENCIAR)
	private int numeroEndereco;
	private String complementoEndereco;
	private String telefone;
	private SituacaoEmpresa situacao;
			*/
			/*
			Banco findBanco = banco.findBanco(5);
			Enderecamento findEndereco = ec.findEnderecamento(2);
			
			int numeroEndereco = sc.nextInt();
			String complemento = sc.next();
			String telefone = sc.next();
			SituacaoEmpresa situacao = SituacaoEmpresa.ativo;
			
			Agencia agencia = new Agencia(findBanco,findEndereco,numeroEndereco,complemento,telefone,situacao);
			
			ac.insert(agencia);
			
			*/
			
			/*
			 *  private static int ultimoId;
    			protected int id;
    			private Enderecamento cep;
    			private int numeroEndereco;
    			private String compleEndereco;
    			private String telefone;
    			private Date clienteDesde;
    			private SituacaoCliente situacao;
			 * private String cpf;
			private String nomeDeRegistro;
			private String nomeSocial;
			private Date dataDeNascimento;
			private Sexo sexo;
			private double rendaMensal;
			 */
			
			/*
			Enderecamento cep = ec.findEnderecamento(2);
			int numero = sc.nextInt();
			String complemento = sc.next();
			String telefone = sc.next();
			LocalDate cliente_desce = LocalDate.parse("2005-03-19", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			SituacaoCliente situacao = SituacaoCliente.ATIVO;
			String cpf = sc.next();
			String nome = sc.next();
			String nomeSocial = null;
			LocalDate data_nascimento = LocalDate.parse("2004-03-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Sexo sexo = Sexo.MASCULINO;
			double renda = sc.nextDouble();
			
			PessoaFisica pessoaFisica = new PessoaFisica(cep, sexo, numero, complemento, telefone, Date.valueOf(cliente_desce), situacao, cpf, nome, nomeSocial, Date.valueOf(data_nascimento), renda, numero);
			pessoa.insertPessoaFisica(pessoaFisica);
			
			Columns:
id int(11) AI PK 
id_agencia int(11) 
id_primeiro_titular int(11) 
id_segundo_titular int(11) 
data_abertura date 
saldo_atual decimal(10,2) 
senha varchar(30) 
bandeira_cartao varchar(35) 
numero_cartao bigint(20) 
expira_cartao date 
cvv int(11) 
situacao_conta varchar(30)
			*/
			/*
			Agencia idAgencia = ac.findAgencia(1);
			Pessoa idPrimeiro = pessoa.findPessoa(5);
			Pessoa idSegundo = null;
			LocalDate data_abertura = LocalDate.parse("2019-03-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			double saldo_atual = sc.nextDouble();
			String senha = sc.next();
			String bandeira = sc.next();
			int numeroCartao = sc.nextInt();
			LocalDate expiraCarao = LocalDate.parse("2022-02-19", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			int cvv = sc.nextInt();
			SituacaoContaBancaria situacao = SituacaoContaBancaria.ATIVO;
			
			ContaCorrente conta = new ContaCorrente(idAgencia, idPrimeiro, idSegundo,Date.valueOf(data_abertura), saldo_atual, senha, bandeira, numeroCartao,Date.valueOf(expiraCarao), cvv, situacao)	;	
			cbc.insertContaCorrente(conta);
			*/
			
			
			/*
			
		private Agencia codigoAgencia;
		private Pessoa primeiroTitular;
		private Pessoa segundoTitular;
		private Date dataAbertura;
		private double saldoAtual;
		private String senha;
		private String bandeiraCartao;
		private int numeroCartao;
		private Date expiraCartao;
		private int cvv;
		private SituacaoContaBancaria situacaoConta;
			 */
			/*
			int id = sc.nextInt();
			int idAgencia = sc.nextInt();
			Agencia pickAgencia = ac.findAgencia(idAgencia); 
			int idPessoa = sc.nextInt();
			Pessoa pessoaa =pessoa.findPessoa(idPessoa);
			int idPessoa2 = sc.nextInt();
			Pessoa pessoaa2 =pessoa.findPessoa(idPessoa2);
			LocalDate data_abertura = LocalDate.parse("2013-04-12", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			double saldoAtual = sc.nextDouble();
			String senha = sc.next();
			String bandeiraCartao = sc.next();
			int numeroCartao = sc.nextInt();
			LocalDate data_expira = LocalDate.parse("2019-03-11", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			int cvv = sc.nextInt();
			SituacaoContaBancaria scb = SituacaoContaBancaria.ATIVO;
			
			ContaCorrente cc = new ContaCorrente(id, pickAgencia,pessoaa,pessoaa2,Date.valueOf(data_abertura),saldoAtual,senha,bandeiraCartao,numeroCartao,Date.valueOf(data_expira),cvv,scb);
			cbc.insertContaCorrente(cc);
			
			*/

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
			/*PessoaController pc = new PessoaController();
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
			*/
		}
	
	}
