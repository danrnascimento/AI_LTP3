package usuario;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncFactoryException;

import cadastro.Cadastro;
import dados.Cliente;
import dados.EstatisticaVenda;
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;
import utilitarios.LtpUtil;
import utilitarios.Console;

/**
 * Classe para interagir com usuário
 * @author Daniel Nascimento
 * @since 09/05/2016
 * @version 1.0
 */
public class Usuario {
	
	static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) throws SisVendasException {
	
		if (new File("Lista.obj").exists()) {
			lerArquivos();
		}
		
		menu();
		gravarArquivo();
		System.out.println("\nFIM");
		System.exit(0);
		
	} 
	
	//-------------------------------- CLIENTES ----------------------------------------
	
	/** 
	 * Metodo para incluir novo cliente
	 * @throws SisVendasException
	 */
	public static void incluirCliente(){

		String cpf;
		String nome;
		String telefone;
		String email;
		boolean error;
		
		//entrar com o CPF e verificar se está correto
		
		do{
			System.out.println("Insira o cpf do cliente: ");
			cpf  = Console.readLine();
				
			if(LtpUtil.validarCPF(cpf) == false || cpf.isEmpty()){
				System.out.println("CPF Inválido!");
			}
			
			try {
				Cliente cliente = Cadastro.procurarClienteCpf(cpf);
				System.out.println("Cliente já cadastrado");
				error = true;
			} catch (SisVendasException e) {
				error = false;
			}
			
		}while(!LtpUtil.validarCPF(cpf) || cpf.isEmpty() || error);
		
		do{
			System.out.println("Digite o nome do Cliente: ");
			nome = Console.readLine();
			if(LtpUtil.contarPalavras(nome) < 2 || nome.isEmpty()){
				System.out.println("Nome Inválido!");
			}
		}while((LtpUtil.contarPalavras(nome) < 2) || nome.isEmpty());
				
		do{
			System.out.println("Digite o telefone do Cliente: ");
			telefone = Console.readLine();
			if(telefone.isEmpty()){
				System.out.println("Telefone Invalido");
			}
		}while(telefone.isEmpty());
		
		do{
			System.out.println("Digite o email do cliente: ");
			email = Console.readLine();
		}while(!LtpUtil.validarEmail(email));
			
		
		Cliente cliente= new Cliente(cpf, nome,email,telefone);
		Cadastro.incluirCliente(cliente);
		
	}
	
	/**
	 * Metodo para alterar dados do Cliente, procura por cpf
	 * @param cpf
	 * @throws SisVendasException
	 */
	public static void alterarCliente(){
		
		String nome;
		String cpf;
		String email;
		String telefone;
		
		do{
			System.out.println("Digite o cpf do Cliente: ");
			cpf = Console.readLine();
			if(cpf.isEmpty() || !(LtpUtil.validarCPF(cpf))){
				System.out.println("CPF Inválido");
			}
		}while(cpf.isEmpty() || !(LtpUtil.validarCPF(cpf)));
		
		try {
			
			Cliente cliente = Cadastro.procurarClienteCpf(cpf);
			
			System.out.println(cliente.toString());
						
			System.out.println("\n\nDeseja Alterar ? (Sim/nao)");
			String resp = Console.readLine();
			
			if (resp.equalsIgnoreCase("sim")){
				
				do{
					System.out.println("Digite o nome do Cliente: ");
					nome = Console.readLine();
				}while((LtpUtil.contarPalavras(nome) < 2));
				
				cliente.setNome(nome);
				
				do{
					System.out.println("Digite o telefone do Cliente: ");
					telefone = Console.readLine();
				}while(telefone == null);
				
				cliente.setTelefone(telefone);
				
				do{
					System.out.println("Digite o email do cliente: ");
					email = Console.readLine();
				}while(!LtpUtil.validarEmail(email));
				
				cliente.setEmail(email);
				GregorianCalendar dataAlteracao = new GregorianCalendar();
				cliente.setDataUltAlteracao(dataAlteracao);
			}
			
		}catch (SisVendasException e) {
			System.out.println(e.getMessage());
		}
			
	}
		
	/**
	 * Metodo para excluir cliente a partir do cpf
	 * @param cpf
	 * @throws SisVendasException
	 */
	public static void excluirCliente(){
		
		String cpf;
		
		do{
			System.out.println("Digite o CPF do Cliente");
			cpf = Console.readLine();
			if(cpf.isEmpty() || !(LtpUtil.validarCPF(cpf))){
				System.out.println("CPF Inválido");
			}
		}while(cpf.isEmpty() || !(LtpUtil.validarCPF(cpf)));
		
		try {
			Cliente cliente = Cadastro.procurarClienteCpf(cpf);
			
			System.out.println(cliente.toString());
			
			System.out.println("\n\nDeseja Excluir ? (Sim/nao)");
			String resp = Console.readLine();
			
			if (resp.equalsIgnoreCase("sim")){
				Cadastro.removerCliente(cliente);
			}
			
		} catch (SisVendasException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Metodo para consultar cliente via CPF
	 * @param cpf
	 * @throws SisVendasException
	 */
	public static void consultarClienteCpf(){
		
		String cpf;
		
		do{
			System.out.println("Digite o CPF do Cliente");
			cpf = Console.readLine();
			if(cpf.isEmpty() || !(LtpUtil.validarCPF(cpf))){
				System.out.println("CPF Inválido");
			}
		}while(cpf.isEmpty() || !(LtpUtil.validarCPF(cpf)));
		
		try {
			
			System.out.println(Cadastro.procurarClienteCpf(cpf).toString());
		
		} catch (SisVendasException e) {
			
			System.out.println(e.getMessage());
		
		}
	}
	
	/**
	 * Metodo para exibir por nome ou parte do Nome
	 * @author Daniel Nascimento
	 */
	private static void  consultarClienteNome() {
		
		String nome;
		
		do{
			System.out.println("Digite o Nome do Cliente ou Parte do Nome: ");
			nome = Console.readLine();
			if(nome.isEmpty()){
				System.out.println("Nome Inválido");
			}
		}while(nome.isEmpty());
		
		try {
			
			ArrayList<Cliente> clientes = Cadastro.procurarClienteNome(nome);
			
			for(Cliente cliente : clientes){
				System.out.println(cliente.toString());
			}
		
		} catch (SisVendasException e) {
			
			System.out.println(e.getMessage());
		
		}
				
	}
	
	//-------------------------------- PRODUTO -----------------------------------------//
	
	/**
	 * Metodo para incluir novo produto
	 * @throws SisVendasException
	 */
	public static void incluirProduto(){
		
		String nome;
		Double precoUnitario;

			
		do{
			System.out.println("Digite o nome do Produto: ");
			nome = Console.readLine();
			if(nome == null || nome.isEmpty()){
				System.out.println("Nome inválido!");
			}
		}while(nome == null || nome.isEmpty());
			
		do{
			System.out.println("Digite o preco do produto");
			try {
				precoUnitario = Double.parseDouble(leia.nextLine());
			} catch (Exception e) {
				precoUnitario = -1.0;
			}
			if(precoUnitario <= 0 || precoUnitario == null){
				System.out.println("Preco Inválido!");
			}
		}while(precoUnitario <= 0 || precoUnitario == null);
		
		Produto produto = new Produto(nome, precoUnitario);
		Cadastro.incluirProduto(produto);

			
	}
	
	/**
	 * Metodo para alterar produto
	 * @param codigo
	 * @throws SisVendasException
	 */
	public static void alterarProduto(){
		
		String nome;
		int codigo;
		Double precoUnitario;
		Produto produto;
		String confirmar;
		
		do {
			
			System.out.println("Digite o codigo do produto: ");
			codigo = Integer.parseInt(leia.nextLine());
			if (codigo < 0){
				System.out.println("Codigo Inválido");
			}
			
		}while(codigo < 0);
		
		try {
			produto = Cadastro.procurarProdutoCod(codigo);
			
			System.out.println(produto.toString());
			
			System.out.println("\n\nDeseja alterar? (Sim/nao)");
			confirmar = Console.readLine();
			
			if(confirmar.equalsIgnoreCase("sim")){
				do {
					System.out.println("Digite o novo nome do produto: ");
					nome = Console.readLine();
					if (nome.isEmpty() || nome == null){
						System.out.println("Nome do produto inválido");
					}
				}while(nome.isEmpty() || nome == null);
				
				produto.setNome(nome);
				
				do{
					System.out.println("Digite o novo preco do produto");
					try {
						precoUnitario = Double.parseDouble(leia.nextLine());
					} catch (Exception e) {
						precoUnitario = -1.0;
					}if (precoUnitario <= 0 || precoUnitario == null){
						System.out.println("Preco do produto é inválido ou nulo");
					}
				}while(precoUnitario <= 0 || precoUnitario == null);
				
				produto.setPrecoUnitario(precoUnitario);
				
				GregorianCalendar dataUltAlteracao = new GregorianCalendar();
				produto.setDataUltAlteracao(dataUltAlteracao);
				
			}
			
		} catch (SisVendasException e) {
			
			e.getMessage();
			
		}
		
	}
	
	/**
	 * Metodo para remover produto
	 * @author Daniel Nascimento
	 */
	public static void excluirProduto(){
		
		int codigo;
		Produto produto;
		String confirmar;
		boolean error = false;
		
		do{
			System.out.println("Digite o codigo do produto que deseja Excluir");
			try {
				codigo = Integer.parseInt(leia.nextLine());
			} catch (Exception e) {
				codigo = -1;
			}
			
			if(codigo < 0){
				System.out.println("Codigo inválido");
			}
		}while(codigo < 0);
		
		try {
			produto = Cadastro.procurarProdutoCod(codigo);
			
			for(Venda vendaAux : Cadastro.vendas.values()){
				for(ItemVenda itemVendaAux2 : vendaAux.getVendaItem()){
					if(itemVendaAux2.getProduto().getCodigo() == codigo){
						error = true;
						System.out.println("Produto cadastrado com venda, impossivel ser removido");
						break;
					}
				}
			}
			
			if(!error){
				
				System.out.println(produto.toString());
				
				System.out.println("\n\nDeseja Excluir? (Sim/nao)");
				confirmar = Console.readLine();
				
				if(confirmar.equalsIgnoreCase("sim")){
					Cadastro.removerProduto(produto);
				}else{
					System.out.println("Não foi possivel exluir");
				}
				
			}
			
		} catch (SisVendasException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Metodo para procurar Produto pelo nome e exibir em ordem alfabetica
	 * @author Daniel Nascimento
	 */
	public static void procurarProduto(){
		
		String nome;
		
		do{
			System.out.println("Digite o nome do Produto que deseja procurar: ");
			nome = Console.readLine();
			if(nome.isEmpty()){
				System.out.println("Nome Inválido");
			}
		}while(nome.isEmpty());
		
		try {
			
			ArrayList<Produto> produtos = Cadastro.procurarProdutoNome(nome);
			
			for(Produto auxiliar : produtos){
				System.out.println(auxiliar.toString());
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	//-------------------------------- VENDAS -----------------------------------------//
	
	/**
	 * Metodo para incluir uma nova venda
	 * @author Daniel Nascimento
	 */
	public static void incluirVenda(){
		
		String cpf;
		Double precoUnitario;
		int quantidade;
		boolean error = false;
		boolean continuar;
		int codProduto;
		Cliente cliente = null;
		Produto produto = null;
		Double valorTotal;
		String adicionarMaisUm;
		Double valorFinal = 0.0;
		
		do{
			System.out.println("Digite o CPF do Cliente");
			cpf = Console.readLine();
			if(cpf.isEmpty() || !LtpUtil.validarCPF(cpf)){
				System.out.println("CPF Inválido");
			}
		}while(cpf.isEmpty() || !LtpUtil.validarCPF(cpf));
		
		try {
			
			cliente = Cadastro.procurarClienteCpf(cpf);
			
		} catch (SisVendasException e) {
			e.getMessage();
		}
		
		ArrayList<ItemVenda> listaItens = new ArrayList<ItemVenda>();
		
		do{
			continuar = false;
			do{
				do{
					System.out.println("Insira o codigo do produto");
					codProduto = Integer.parseInt(leia.nextLine());
					if(codProduto <= 0){
						System.out.println("Codigo inválido");
					}
				}while(codProduto <= 0);
				
				try {
					
					produto = Cadastro.procurarProdutoCod(codProduto);
					
					for(ItemVenda itens : listaItens){
						if(itens.getProduto().equals(produto)){
							System.out.println("Produto já inserido");
							error = true;
							break;
						}
					}
					
				} catch (SisVendasException e) {
					System.out.println(e.getMessage());
				}
			
				precoUnitario = produto.getPrecoUnitario();
				
				do{
					System.out.println("Digite a quantidade de Produtos");
					try {
						quantidade = Integer.parseInt(leia.nextLine());
					} catch (Exception e) {
						quantidade = -1;
					}
					if(quantidade <= 0){
						System.out.println("Quantidade Invalida");
					}
					
				}while(quantidade <= 0);
				
				valorTotal = precoUnitario * quantidade;
				
				ItemVenda itemVenda = new ItemVenda(produto, precoUnitario, quantidade, valorTotal);
				
				listaItens.add(itemVenda);
				
			} while(listaItens.isEmpty() || error);
			
			System.out.println("\n\nDeseja Adicionar mais um produto? (Sim/nao)");
			adicionarMaisUm = Console.readLine();
			valorFinal = valorFinal + valorTotal;
			if(adicionarMaisUm.equalsIgnoreCase("sim")){
				continuar = false;
			}else{
				continuar = true;
			}
			
		}while(!continuar);
		
		Venda venda = new Venda(cliente, listaItens, valorFinal);
		Cadastro.incluirVenda(venda);
		
	}
	
	/**
	 * Metodo para remover uma venda
	 * @author Daniel Nascimento
	 */
	public static void excluirVenda(){
		
		int codVenda;
		String confirmar;
		
		do{
			System.out.println("Digite o numero da Venda: ");
			try {
				codVenda = Integer.parseInt(leia.nextLine());
			} catch (Exception e) {
				codVenda = -1;
			}
			if(codVenda < 0){
				System.out.println("Numero de Venda Invalido!");
			}
		}while(codVenda < 0);
		
		try {
			
			Venda venda = Cadastro.procurarVenda(codVenda);
			System.out.println(venda.toString());
			
			System.out.println("\n\nDeseja Excluir? (Sim/nao)");
			confirmar = Console.readLine();
			
			if(confirmar.equalsIgnoreCase("sim")){
				Cadastro.removerVenda(venda);
			}
			
		} catch (SisVendasException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para procurar produto por Periodo e exibir de forma decrescente
	 * @author Daniel Nascimento
	 */
	public static void procurarVendaPeriodo(){
		
		String dataInicio, dataFinal;
		GregorianCalendar dataCInicio = new GregorianCalendar();
		GregorianCalendar dataCFinal = new GregorianCalendar();
		boolean error = false;
		
		do{
			error = false;
			System.out.println("Digite a data de inicio: ");
			dataInicio = Console.readLine();
			if(dataInicio.isEmpty() || !LtpUtil.validarData(dataInicio, dataCInicio)){
				System.out.println("Data Inválida");
				error = true;
			}else if(dataCInicio.after(new GregorianCalendar())){
				System.out.println("A Data de Inicio não pode ser superior a data atual");
				error = true;
			}
		}while(error);
		
		do{
			error = false;
			System.out.println("Digite a data Final: ");
			dataFinal = Console.readLine();
			if(dataFinal.isEmpty() || !LtpUtil.validarData(dataFinal, dataCFinal)){
				System.out.println("Data Inválida");
				error = true;
			}else if(dataCFinal.after(new GregorianCalendar())){
				System.out.println("A Data Final não pode ser superior a data atual");
				error = true;
			}else if(dataCFinal.before(dataCInicio)){
				System.out.println("A Data Final não pode ser anterior a de Inicio");
			}
		}while(error);
		
		ArrayList<Venda> vendas = Cadastro.procurarVendaPeriodo(dataCInicio, dataCFinal);
		
		for(Venda venda : vendas){
			System.out.println(venda.toString());
		}
		
		
	}
	
	//-------------------------------- ESTATISTICAS -----------------------------------------//
	
	/**
	 * Metodo para exibir do estatisticas do cliente por periodo de vendas
	 * Metodo para exibir estatisticas por periodo de vendas
	 * @author Daniel Nascimento
	 */
	public static void consultarEstatistica(){
		
		String dataInicio, dataFinal;
		GregorianCalendar dataCInicio = new GregorianCalendar();
		GregorianCalendar dataCFinal = new GregorianCalendar();
		boolean error = false;
		
		do{
			error = false;
			System.out.println("Digite a data de inicio: ");
			dataInicio = Console.readLine();
			if(dataInicio.isEmpty() || !LtpUtil.validarData(dataInicio, dataCInicio)){
				System.out.println("Data Inválida");
				error = true;
			}else if(dataCInicio.after(new GregorianCalendar())){
				System.out.println("A Data de Inicio não pode ser superior a data atual");
				error = true;
			}
		}while(error);
		
		do{
			error = false;
			System.out.println("Digite a data Final: ");
			dataFinal = Console.readLine();
			if(dataFinal.isEmpty() || !LtpUtil.validarData(dataFinal, dataCFinal)){
				System.out.println("Data Inválida");
				error = true;
			}else if(dataCFinal.after(new GregorianCalendar())){
				System.out.println("A Data Final não pode ser superior a data atual");
				error = true;
			}else if(dataCFinal.before(dataCInicio)){
				System.out.println("A Data Final não pode ser anterior a de Inicio");
			}
		}while(error);
		
		HashMap<String, EstatisticaVenda> estatistica = Cadastro.estatisticasVenda(dataCInicio, dataCFinal);
		
		for(EstatisticaVenda aux : estatistica.values()){
			System.out.println(aux.toString());
		}
		
	}
	/**
	 * Metodo para exibir estatisticas do produto por periodo de vendas
	 * @author Daniel Nascimento
	 */
	public static void consultarEstatisticaProduto(){
		
		String dataInicio, dataFinal;
		GregorianCalendar dataCInicio = new GregorianCalendar();
		GregorianCalendar dataCFinal = new GregorianCalendar();
		boolean error = false;
		
		do{
			error = false;
			System.out.println("Digite a data de inicio: ");
			dataInicio = Console.readLine();
			if(dataInicio.isEmpty() || !LtpUtil.validarData(dataInicio, dataCInicio)){
				System.out.println("Data Inválida");
				error = true;
			}else if(dataCInicio.after(new GregorianCalendar())){
				System.out.println("A Data de Inicio não pode ser superior a data atual");
				error = true;
			}
		}while(error);
		
		do{
			error = false;
			System.out.println("Digite a data Final: ");
			dataFinal = Console.readLine();
			if(dataFinal.isEmpty() || !LtpUtil.validarData(dataFinal, dataCFinal)){
				System.out.println("Data Inválida");
				error = true;
			}else if(dataCFinal.after(new GregorianCalendar())){
				System.out.println("A Data Final não pode ser superior a data atual");
				error = true;
			}else if(dataCFinal.before(dataCInicio)){
				System.out.println("A Data Final não pode ser anterior a de Inicio");
			}
		}while(error);
		
		HashMap<String, EstatisticaVenda> estatistica = Cadastro.estatisticasVendaProduto(dataCInicio, dataCFinal);
		
		for(EstatisticaVenda aux : estatistica.values()){
			System.out.println(aux.toString());
		}
		
	}

	//-------------------------------- MENU -----------------------------------------//
	
	/**
	 * Metodo para exibir e controlar o menu
	 * @author Daniel Nascimento
	 */
	public static void menu(){
		int opcao = 0;
		do{
			System.out.println("\n========| \tEscolha uma das opções abaixo:\t  |========\n"
					+ "\n\tCLIENTES \n"
					+ "\n\t 1 - INSERIR UM CLIENTE"
					+ "\n\t 2 - ALTERAR UM CLIENTE"
					+ "\n\t 3 - EXCLUIR UM CLIENTE"
					+ "\n\t 4 - CONSULTA DADOS DO CLIENTE PELO CPF"
					+ "\n\t 5 - CONSULTA CLIENTES PELO NOME \n"
					+ "\n\tPRODUTOS \n"
					+ "\n\t 6 - INSERIR UM PRODUTO"
					+ "\n\t 7 - ALTERAR UM PRODUTO"
					+ "\n\t 8 - EXCLUIR UM PRODUTO"
					+ "\n\t 9 - CONSULTA PRODUTOS PELO NOME \n"
					+ "\n\tVENDAS \n"
					+ "\n\t 10 - INSERIR UMA VENDA"
					+ "\n\t 11 - EXCLUIR UMA VENDA"
					+ "\n\t 12 - CONSULTA VENDAS POR PERIODO \n"
					+ "\n\tESTATISTICAS \n"
					+ "\n\t 13 - CONSULTA ESTATISTICA DE CLIENTES POR PERIODO"
					+ "\n\t 14 - CONSULTA ESTATISTICA DE PRODUTOS POR PERIODO"
					+ "\n\n\t 0 - SAIR \n");

			System.out.println("Entre com a opção desejada: ");
			try {
				opcao = Integer.parseInt(leia.nextLine());
			} catch (Exception e) {
				opcao = 99;
			}
			

			switch(opcao){
			case 0: 
				break;
			case 1:		
				incluirCliente();
				break;
			case 2:
				alterarCliente();
				break;
			case 3:
				excluirCliente();
				break;
			case 4:
				consultarClienteCpf();
				break;
			case 5:
				consultarClienteNome();
				break;
			case 6:		
				incluirProduto();
				break;
			case 7:
				alterarProduto();
				break;
			case 8:
				excluirProduto();
				break;
			case 9:
				procurarProduto();
				break;
			case 10:
				incluirVenda();
				break;
			case 11:
				excluirVenda();
				break;
			case 12:
				procurarVendaPeriodo();
				break;
			case 13:
				consultarEstatistica();
				break;
			case 14:
				consultarEstatisticaProduto();
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}

		}while(opcao != 0);

	}
	
	//-------------------------------- ARQUIVOS -----------------------------------------//
	
	/**
	 * Metodo para ler arquivos
	 * @author Daniel Nascimento
	 */
	public static void lerArquivos(){
		
		try {

			ObjectInputStream leitura = new ObjectInputStream(new FileInputStream("Lista.obj"));
			Cadastro.clientes = (Map<String, Cliente>)leitura.readObject();
			Cadastro.produtos = (Map<Integer, Produto>)leitura.readObject();
			Cadastro.vendas = (Map<Integer, Venda>)leitura.readObject();
			
			//Acertar Sequencia do Codigo de produtos
			if(!Cadastro.produtos.isEmpty()){
				int cod = Cadastro.produtos.get(Cadastro.produtos.size()).getCodigo();
				
				while(Cadastro.produtos.containsKey(cod + 1)){
					cod++;
				}
				Produto.setSeq(cod);
			}
			leitura.close();
			
			//Acertar Sequencia do Codigo de Vendas
			if(!Cadastro.vendas.isEmpty()){
				int cod = Cadastro.vendas.get(Cadastro.vendas.size()).getNumVenda();
				
				while(Cadastro.vendas.containsKey(cod + 1)){
					cod++;
				}
				Venda.setSeq(cod);
			}
			leitura.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * Metodo para gravar arquivo
	 * @author Daniel Nascimento
	 */
	public static void gravarArquivo(){
		try {
			
			ObjectOutputStream gravar = new ObjectOutputStream(new FileOutputStream("Lista.obj"));
			gravar.writeObject(Cadastro.clientes);
			gravar.writeObject(Cadastro.produtos);
			gravar.writeObject(Cadastro.vendas);
			gravar.close();
			
		} catch (Exception e) {
			System.out.println("Rolou erro : " + e.getMessage());
		}
	}
	
	//---------------------------------------- HELPERS ----------------------------------------- ---//
	
	/**
	 * Funcao para verificar se Existe CPF cadastrado
	 * @author Daniel Nascimento
	 * @param cpf
	 * @return true ou false
	 * @throws SisVendasException
	 */
	public static boolean verificarClienteCPF(String cpf) throws SisVendasException{
		
		
		try {
			Cliente clienteAux = Cadastro.procurarClienteCpf(cpf);
			return true;
		} catch (SisVendasException e) {
			System.out.println("");
			return false;
		}
		
		
	}
}