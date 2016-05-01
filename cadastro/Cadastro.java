package cadastro;

/**Classe para objetos do tipo Cadastro, onde serão contidos, valores e métodos para o mesmo.

 * @author Daniel Nascimento

 */

import dados.*;

import java.util.*;

public class Cadastro {
	
	public static Map<String, dados.Cliente> clientes = new HashMap<String, dados.Cliente>();
	public static Map<String, String> produtos = new HashMap<String, String>();
	public static Map<String, String> vendas = new HashMap<String, String>();
	
	/**Metodo para incluir novo Cliente a Lista de Clientes
	 * 
	 * @author Daniel Nascimento
	 * 
	 * @param Cliente - objeto cliente a ser incluido.
	 * 
	 */
	public static void incluirCliente(Cliente cliente){
		clientes.put(cliente.getCpf(), cliente);
	}
	
	/**Metodo para remover cliente da Lista de cliente
	 * 
	 * @author Daniel Nascimento
	 * 
	 * @param Cliente - objeto cliente a ser removido
	 */
	
	public static void removerCliente(Cliente cliente){
		clientes.remove(cliente.getCpf());
	}
	
	/**Metodo para procurar cliente na lista pelo cpf
	 *
	 * @author Daniel Nascimento
	 * 
	 * @param cpf String - cpf do cliente.
	 * 
	 * @return Cliente - Objeto Cliente
	 * 
	 */
	
	public static Cliente procurarCliente(String cpf){
		if (clientes.containsKey(cpf)){
			return clientes.get(cpf);
		}else{
			return null;
		}
	}
	
}
