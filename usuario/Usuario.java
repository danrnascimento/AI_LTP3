package usuario;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.io.*;

import cadastro.Cadastro;
import dados.Cliente;
import erros.SisVendasException;
import utilitarios.LtpUtil;
import utilitarios.Console;

public class Usuario {

	public static void main(String[] args) {
	
		
		
	} 
	
	/** 
	 * Metodo para incluir novo cliente
	 * @author Daniel Nascimento
	 * @throws SisVendasException
	 */
	public static void incluirCliente() throws SisVendasException{
		
		boolean valido;
		String cpf;
		String nome;
		String telefone;
		String email;
		
		//entrar com o CPF e verificar se está correto
		do{
			System.out.println("Digite o seu CPF: ");
			cpf = Console.readLine();	
		}while(!LtpUtil.validarCPF(cpf));
		
		try {
			
			Cadastro.procurarClienteCpf(cpf);
			System.out.println("CPF CADASTRADO!");
			
		} catch (Exception e) {
			
			do{
				System.out.println("Digite o nome do Cliente: ");
				nome = Console.readLine();
			}while((LtpUtil.contarPalavras(nome) < 2));
			
			do{
				System.out.println("Digite o telefone do Cliente: ");
				telefone = Console.readLine();
			}while(telefone == null);
			
			do{
				System.out.println("Digite o email do cliente: ");
				email = Console.readLine();
			}while(!LtpUtil.validarEmail(email));
			
			Cliente cliente= new Cliente(cpf, nome,email,telefone);
			Cadastro.incluirCliente(cliente);
			
		}

		
	}
	
	/**
	 * Metodo para alterar dados do Cliente, procura por cpf
	 * @author Daniel Nascimento
	 * @param cpf
	 * @throws SisVendasException
	 */
	public static void alterarCliente(String cpf) throws SisVendasException{
		
		String nome;
		String email;
		String telefone;
		
		if(Cadastro.procurarClienteCpf(cpf) == null){
			System.out.println("Cliente nao encontrado!");
		}else{
			
			Cliente cliente = Cadastro.procurarClienteCpf(cpf);

			cliente.toString();
			
			System.out.println("Deseja Alterar ? (Sim/nao)");
			String resp = Console.readLine();
			
			if (resp.equalsIgnoreCase("nao")){
				
				System.out.println("Obrigado");
				System.exit(0);
				
			}else{
				
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
			
		}
		
	}
}