package usuario;


import java.util.ArrayList;

import cadastro.Cadastro;
import dados.Cliente;
import dados.Produto;
import erros.SisVendasException;
import utilitarios.LtpUtil;
import utilitarios.Console;

public class Usuario {

	public static void main(String[] args) {
	
		
		
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
		
		//entrar com o CPF e verificar se está correto
		
		do{
			System.out.println("Insira o cpf do cliente: ");
			cpf  = Console.readLine();
				
			if(LtpUtil.validarCPF(cpf) == false || cpf.isEmpty()){
				System.out.println("CPF Inválido!");
			}
		}while(!LtpUtil.validarCPF(cpf) || cpf.isEmpty());
		
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
			
			cliente.toString();
						
			System.out.println("Deseja Alterar ? (Sim/nao)");
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
			
			cliente.toString();
			
			System.out.println("Deseja Excluir ? (Sim/nao)");
			String resp = Console.readLine();
			
			if (resp.equalsIgnoreCase("sim")){
				Cadastro.removerCliente(cliente);
			}else{
				System.out.println("Obrigado");
				System.exit(0);
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
			
			Cadastro.procurarClienteCpf(cpf).toString();
		
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
	
	//-------------------------------- PRODUTO -----------------------------------------
	//
	/**
	 * Metodo para incluir novo produto
	 * @throws SisVendasException
	 */
	public static void incluirProduto(){
		
		String nome;
		Double precoUnitario;
		
		//entrar com o CPF e verificar se está correto
			
		do{
			System.out.println("Digite o nome do Cliente: ");
			nome = Console.readLine();
			if(nome == null || nome.isEmpty()){
				System.out.println("Nome inválido!");
			}
		}while(nome == null || nome.isEmpty());
			
		do{
			System.out.println("Digite o preco do produto");
			precoUnitario = Console.readDouble(null);
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
			codigo = Console.readInt(null);
			if (codigo < 0){
				System.out.println("!! Produto não encontrado !!");
			}
			
		}while(codigo < 0);
		
		try {
			produto = Cadastro.procurarProdutoCod(codigo);
			
			produto.toString();
			
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
					precoUnitario = Console.readDouble(null);
					if (precoUnitario <= 0 || precoUnitario == null){
						System.out.println("Preco do produto é inválido ou nulo");
					}
				}while(precoUnitario <= 0 || precoUnitario == null);
				
				produto.setPrecoUnitario(precoUnitario);
				
			}else{
				System.out.println("Obrigado!");
				System.exit(0);
			}
			
		} catch (SisVendasException e) {
			
			e.getMessage();
			
		}
		
	}
	
}