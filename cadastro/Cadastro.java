package cadastro;

/**Classe para objetos do tipo Cadastro, onde serão contidos, valores e métodos para o mesmo.

 * @author Daniel Nascimento

 */

import dados.*;
import erros.SisVendasException;

import java.util.*;

public class Cadastro {
	
	public static Map<String, dados.Cliente> clientes = new HashMap<String, dados.Cliente>();
	public static Map<String, String> produtos = new HashMap<String, String>();
	public static Map<String, String> vendas = new HashMap<String, String>();

	/**
	 * incluir cliente na lista
	 * @author Daniel Nascimento
	 * @param cliente Cliente - Objeto a ser incluso
	 */
	
	public static void incluirCliente(Cliente cliente){
		clientes.put(cliente.getCpf(), cliente);
	}
	
	/**
	 * remover cliente da lista de clientes
	 * @author Daniel Nascimento
	 * @param cliente Cliente - objeto a ser incluso
	 */

	public static void removerCliente(Cliente cliente){
		clientes.remove(cliente.getCpf());
	}
	
	/**
	 * procurar cliente pelo cpf
	 * @author Daniel Nascimento
	 * @param cpf String - Cpf a ser procurado 
	 * @throws SisVendasException
	 */
	
	public static Cliente procurarClienteCpf(String cpf) throws SisVendasException{
		
		if (clientes.containsKey(cpf)){
			return clientes.get(cpf);
		}else{
			throw new SisVendasException("Não encontrado");
		}
		
	}
	
	/**
	 * procurar pelo nome e organizar em ordem alfabetica
	 * @author Daniel Nascimento
	 * @param nome String - nome a ser procurado
	 * @throws SisVendasExceptions 
	 */
	
	public static ArrayList<Cliente> procurarClienteNome(String nome) throws SisVendasException{
		
		ArrayList<Cliente> listaAux = new ArrayList<Cliente>();
		
		for(Cliente auxiliar: clientes.values()){
			if(auxiliar.getNome().contains(nome)){
				listaAux.add(auxiliar);
			}	
		}
		
		if(listaAux.isEmpty()){
			throw new SisVendasException("Não existe cliente com este nome");
		}else{
			Collections.sort(listaAux, new Comparator<Cliente>() {
				
				@Override
				public int compare(Cliente auxiliar1, Cliente auxiliar2) {
					// TODO Auto-generated method stub
					return auxiliar1.getNome().compareTo(auxiliar2.getNome());
				}
				
			});
			
			return listaAux;
		}
		
	}
	
	
	
	
	
}
