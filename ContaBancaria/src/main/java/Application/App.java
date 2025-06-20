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

		// ENDERECAMENTOCONTROLLER
		/*
		 * 
		 * 
		 * INSERT INTO ENDERECAMENTO!!!!!!!!!!!!!!!!!!!
		 * 
		 * String cep = sc.next(); String estado = sc.next(); String muni = sc.next();
		 * String bairro = sc.next(); String logradouro = sc.next();
		 * 
		 * Enderecamento end = new Enderecamento(cep, estado, muni, bairro, logradouro);
		 * ec.insert(end);
		 */

		// SELECT NO ENDERECAMENTO
		/*
		 * int id = sc.nextInt();
		 * 
		 * if(ec.findEnderecamento(id)== null) {
		 * System.out.println("nao foi encontrado registros"); }else {
		 * System.out.println(ec.findEnderecamento(id)); }
		 */
		// find ALL NO ENDERECAMENTO
		// System.out.println(ec.findAll());

		// update NO ENDERECAMENTO

		/*
		 * String cep = sc.next(); String estado = sc.next(); String muni = sc.next();
		 * String bairro = sc.next(); String logradouro = sc.next(); int id =
		 * sc.nextInt(); Enderecamento end = new Enderecamento(cep, estado, muni,
		 * bairro, logradouro,id); ec.update(end);
		 */

		// DELETE IN ENDERECAMENTO
		// int id = sc.nextInt();
		// ec.delete(id);

		/////////////////////////////////////////////////////////////////////////////////

		// PESSOACONTROLLER
		// INSERT PESSOA_FISICA
		/*
		 * int idEnd = sc.nextInt();
		 * 
		 * Enderecamento cep = ec.findEnderecamento(idEnd); int numeroEnd =
		 * sc.nextInt(); String comp = sc.next(); String telefone = sc.next(); LocalDate
		 * cliente_desde =
		 * LocalDate.parse("2019-02-20",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 * SituacaoCliente situacao = SituacaoCliente.ATIVO; String cpf = sc.next();
		 * String nome_registro =sc.next(); String nome_social = null; LocalDate
		 * data_nascimento = LocalDate.parse("2005-03-19",
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd")); Sexo sexo = Sexo.MASCULINO;
		 * double renda_mensal= sc.nextDouble();
		 * 
		 * PessoaFisica pf = new PessoaFisica(cep, numeroEnd,comp, telefone,
		 * Date.valueOf(cliente_desde), situacao,
		 * cpf,nome_registro,nome_social,Date.valueOf(data_nascimento),sexo,renda_mensal
		 * ); pessoa.insertPessoaFisica(pf);
		 */

		// SELECT EM PESSOA FISICA
		/*
		 * int id = sc.nextInt(); System.out.println(pessoa.findPessoaFisica(id));
		 */
		// INSERT IN PESSOA_JURIDICA
		/*
		 * int idEnd = sc.nextInt(); Enderecamento cep = ec.findEnderecamento(idEnd);
		 * int numeroEnd = sc.nextInt(); String comp = sc.next(); String telefone =
		 * sc.next(); LocalDate cliente_desde =
		 * LocalDate.parse("2019-02-20",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 * SituacaoCliente situacao = SituacaoCliente.ATIVO; String cnpj = sc.next();
		 * String razao_social = sc.next(); String nome_fantasia = sc.next(); LocalDate
		 * abertura = LocalDate.parse("2013-03-20",
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd")); int idPessoaFisicaDono =
		 * sc.nextInt(); Pessoa find = pessoa.findPessoaFisica(idPessoaFisicaDono);
		 * double capital = sc.nextDouble();
		 * 
		 * PessoaJuridica pj = new PessoaJuridica(cep, numeroEnd, comp, telefone,
		 * Date.valueOf(cliente_desde), situacao, cnpj, razao_social, nome_fantasia,
		 * Date.valueOf(abertura), find, capital); pessoa.insertPessoaJuridica(pj);
		 */

		// SELECT NO PESSOA_JURIDICA
		/*
		 * int id = sc.nextInt(); System.out.println(pessoa.findPessoaJuridica(id));
		 */

		// UPDATE NO PESSOA_JURIDICA;

		/*
		 * int idEnd = sc.nextInt(); Enderecamento cep = ec.findEnderecamento(idEnd);
		 * int numeroEnd = sc.nextInt(); String comp = sc.next(); String telefone =
		 * sc.next(); LocalDate cliente_desde =
		 * LocalDate.parse("2019-02-20",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 * SituacaoCliente situacao = SituacaoCliente.ATIVO; String cnpj = sc.next();
		 * String razao_social = sc.next(); String nome_fantasia = sc.next(); LocalDate
		 * abertura = LocalDate.parse("2013-03-20",
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd")); int idPessoaFisicaDono =
		 * sc.nextInt(); Pessoa find = pessoa.findPessoaFisica(idPessoaFisicaDono);
		 * double capital = sc.nextDouble(); int idNoWhere = sc.nextInt();
		 * 
		 * PessoaJuridica pj = new PessoaJuridica(cep, numeroEnd, comp, telefone,
		 * Date.valueOf(cliente_desde), situacao, cnpj, razao_social, nome_fantasia,
		 * Date.valueOf(abertura), find, capital,idNoWhere);
		 * pessoa.updatePessoaJuridica(pj);
		 */

		// DELETE NO PESSOA
		// int id =sc.nextInt();
		// pessoa.deletePessoa(id);

		// SELECT * FROM PESSOA_JURIDICA
		// System.out.println(pessoa.findAllPessoa());

		// BANCOCONTROLLER

		// INSERT NO BANCO
		/*
		 * int codigo = sc.nextInt(); String nome = sc.next(); int mascara =
		 * sc.nextInt();
		 * 
		 * Banco bancoo = new Banco(codigo, nome, mascara); banco.insert(bancoo);
		 */

		// UPDATE NO BANCO
		/*
		 * int id = sc.nextInt();
		 * 
		 * System.out.println(banco.findBanco(id)); System.out.println(banco.findAll());
		 * 
		 * int codigo = sc.nextInt(); String nome = sc.next(); int mascara =
		 * sc.nextInt(); int idWhere = sc.nextInt();
		 * 
		 * Banco bancoo = new Banco(codigo, nome, mascara,idWhere);
		 * banco.update(bancoo);
		 */

		// AGENCIACONTROLLER
		// INSERT NA AGENCIA
		/*
		 * int bancoId = sc.nextInt(); Banco find = banco.findBanco(bancoId); int idEnd
		 * = sc.nextInt(); Enderecamento findEnd = ec.findEnderecamento(idEnd); int
		 * numeroEndereco = sc.nextInt(); String complementoEndereco = sc.next(); String
		 * telefono = sc.next(); SituacaoEmpresa situacao = SituacaoEmpresa.ativo;
		 * Agencia agencia = new Agencia(find, findEnd, numeroEndereco,
		 * complementoEndereco, telefono, situacao); ac.insert(agencia);
		 */

		// SELECT NA AGENCIA
		/*
		 * int id = sc.nextInt(); System.out.println(ac.findAgencia(id));
		 */

		// UPDATE NA AGENCIA
		/*
		 * int bancoId = sc.nextInt(); Banco find = banco.findBanco(bancoId); int idEnd
		 * = sc.nextInt(); Enderecamento findEnd = ec.findEnderecamento(idEnd); int
		 * numeroEndereco = sc.nextInt(); String complementoEndereco = sc.next(); String
		 * telefono = sc.next(); SituacaoEmpresa situacao = SituacaoEmpresa.ativo; int
		 * idNoWhere = sc.nextInt(); Agencia agencia = new Agencia(find, findEnd,
		 * numeroEndereco, complementoEndereco, telefono, situacao,idNoWhere);
		 * ac.update(agencia);
		 */
		// CONTA BANCARIA Controller

		// INSERT CONTA_CORRENTE
		/*
		 * int idAgencia = sc.nextInt(); Agencia agencia = ac.findAgencia(idAgencia);
		 * int idPessoa_fisica = sc.nextInt(); Pessoa find =
		 * pessoa.findPessoaFisica(idPessoa_fisica); Pessoa segundoTitular = null;
		 * LocalDate data_abertura = LocalDate.parse("2020-09-10",
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd")); double saldo = sc.nextDouble();
		 * String senha = sc.next(); String bandeira = sc.next(); int numero =
		 * sc.nextInt(); LocalDate expiracao =
		 * LocalDate.parse("2024-10-10",DateTimeFormatter.ofPattern("yyyy-MM-dd")); int
		 * cvv = sc.nextInt(); SituacaoContaBancaria situacao =
		 * SituacaoContaBancaria.ATIVO; ContaCorrente conta = new ContaCorrente(agencia,
		 * find, segundoTitular, Date.valueOf(data_abertura), saldo, senha, bandeira,
		 * numero, Date.valueOf(expiracao), cvv, situacao);
		 * cbc.insertContaCorrente(conta);
		 */
		// findall
		// System.out.println(cbc.findAllContaBancaria());
		// insert conta_poupanca
		
		
		
		
	}

}
