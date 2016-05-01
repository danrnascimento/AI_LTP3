package cadastro;

import dados.*;

import java.util.*;

public class Cadastro {
	
	public static Map<String, dados.Cliente> clientes = new HashMap<String, dados.Cliente>();
	public static Map<String, String> produtos = new HashMap<String, String>();
	public static Map<String, String> vendas = new HashMap<String, String>();
	
	public static void incluirCliente(Cliente cliente){
		clientes.put(cliente.getCpf(), cliente);
	}
	
	public static void removerCliente(Cliente cliente){
		clientes.remove(cliente.getCpf());
	}
	
	public static Cliente procurarCliente(String cpf){
		if (clientes.containsKey(cpf)){
			return clientes.get(cpf);
		}else{
			return null;
		}
	}
	
}
