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
	
}