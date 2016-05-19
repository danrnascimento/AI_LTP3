package usuario;


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
	public static void incluirCliente() throws SisVendasException{

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
				
			}else{
				
				System.out.println("Obrigado");
				System.exit(0);
			
			}
			
		}
		
	}

	/**
	 * Metodo para excluir cliente a partir do cpf
	 * @param cpf
	 * @throws SisVendasException
	 */
	
	public static void excluirCliente(String cpf) throws SisVendasException{
		
		Cliente clienteAuxiliar = Cadastro.procurarClienteCpf(cpf);
		
		if ( clienteAuxiliar == null || Cadastro.procurarVendaCliente(clienteAuxiliar) != null){
			System.out.println("Cliente não encontrado ou Possui venda cadastrada");
		}else{
			
			clienteAuxiliar.toString();
			
			System.out.println("Deseja Excluir ? (Sim/nao)");
			String resp = Console.readLine();
			
			if (resp.equalsIgnoreCase("sim")){
				
				Cadastro.removerCliente(clienteAuxiliar);
				
			}else{
				
				System.out.println("Obrigado");
				System.exit(0);
			}
			
			
		}
	}
	
	/**
	 * Metodo para consultar cliente via CPF
	 * @param cpf
	 * @throws SisVendasException
	 */
	public static void consultarClienteCpf(String cpf) throws SisVendasException{
		
		try {
			
			Cadastro.procurarClienteCpf(cpf).toString();
		
		} catch (SisVendasException e) {
			
			System.out.println(e.getMessage());
		
		}
	}
	
	
	//-----------------------------FIM CLIENTES ----------------------------------------
	
	//-------------------------------- PRODUTO -----------------------------------------
	
	/**
	 * Metodo para incluir novo produto
	 * @throws SisVendasException
	 */
	public static void incluirProduto() throws SisVendasException{
		
		String nome = null;
		double precoUnitario;
		
		//entrar com o CPF e verificar se está correto
			
		do{
			System.out.println("Digite o nome do Cliente: ");
			nome = Console.readLine();
		}while((nome != null));
			
		do{
			System.out.println("Digite o Preco do Cliente: ");
			precoUnitario = Console.readDouble(null);
		}while(precoUnitario <= 0);
			
			
		Produto produto = new Produto(nome, precoUnitario);
		Cadastro.incluirProduto(produto);
			
	}
	
}