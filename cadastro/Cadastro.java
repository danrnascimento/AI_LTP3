package cadastro;

/**Classe para objetos do tipo Cadastro, onde serão contidos, valores e métodos para o mesmo.

 * @author Daniel Nascimento

 */

import dados.*;
import erros.SisVendasException;
import java.util.*;

public class Cadastro {
	
	public static Map<String, dados.Cliente> clientes = new HashMap<String, dados.Cliente>();
	public static Map<Integer, dados.Produto> produtos = new HashMap<Integer, dados.Produto>();
	public static Map<Integer, dados.Venda> vendas = new HashMap<Integer, dados.Venda>();

	
	//-----------------------CLIENTES------------------------//
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
			throw new SisVendasException("Não existe cliente para o CPF");
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
					
					return auxiliar1.getNome().compareTo(auxiliar2.getNome());
				}
				
			});
			
			return listaAux;
		}
		
	}

	//-----------------------PRODUTOS------------------------//
	
	/**
	 * incluir produto a lista de produtos
	 * @author Daniel Nascimento
	 * @param produto Produto - produto a ser incluido
	 */
	public static void incluirProduto(Produto produto){
		produtos.put(produto.getCodigo(), produto);
	}
	
	/**
	 * remover produto da lista de produtos
	 * @author Daniel Nascimeno
	 * @param produto Produto - produto a ser removido
	 */
	public static void removerProduto(Produto produto){
		produtos.remove(produto.getCodigo());
	}
	
	/**
	 * procurar produto na lista de produtos pelo codigo
	 * @author Daniel Nascimento
	 * @param cod Int - codigo a ser pesquisado
	 * @throws SisVendasException
	 */
	public static Produto procurarProdutoCod(int cod) throws SisVendasException{
		if (produtos.containsKey(cod)){
			return produtos.get(cod);
		}else{
			throw new SisVendasException("Não Existe produto para o Codigo");
		}
	}
	
	/**
	 * procurar pelo nome do produto e exibir em ordem alfabetica
	 * @author Daniel Nascimento
	 * @param nome String - nome do produto a ser procurado
	 * @throws SisVendaException
	 */	
	public static ArrayList<Produto> procurarProdutoNome(String nome) throws SisVendasException{
		
		ArrayList<Produto> listaAux = new ArrayList<Produto>();
		
		for(Produto auxiliar : produtos.values()){
			if(auxiliar.getNome().contains(nome)){
				listaAux.add(auxiliar);
			}
		}
		
		if(listaAux.isEmpty()){
			throw new SisVendasException("Não encontrdo");
		}else{
			Collections.sort(listaAux, new Comparator<Produto>() {
				
				@Override
				public int compare(Produto auxiliar1, Produto auxiliar2) {
					return auxiliar1.getNome().compareTo(auxiliar2.getNome());
				}
				
			});
			
			return listaAux;
		}
		
	}
	
	//-----------------------VENDAS------------------------//
	
	/**
	 * incluir venda na lista de vendas
	 * @author Daniel Nascimento
	 * @param venda Venda - venda a ser includia
	 */
	public static void incluirVenda(Venda venda){
		vendas.put(venda.getNumVenda(), venda);
	}
		
	/**
	 * remover venda da lista de vendas
	 * @author Daniel Nascimento
	 * @param venda Venda - venda a ser excluida
	 */
	public static void removerVenda(Venda venda){
		vendas.remove(venda.getNumVenda());
	}
	
	/**
	 * procurar venda na lista de vendas pelo codigo 
	 * @author Daniel Nascimento
	 * @param codigo int - codigo a ser procurado
	 * @return Venda - venda com o codigo procurado
	 * @throws SisVendaException
	 */
	public static Venda procurarVenda(int codigo) throws SisVendasException{
		if (vendas.containsKey(codigo)){
			return vendas.get(codigo);
		}else{
			throw new SisVendasException("Não Existe Venda para o Codigo");
		}
	}
	
	/**
	 * procurar venda por cliente
	 * @author Daniel Nascimento
	 * @param <T>
	 * @param cliente Cliente - cliente a ser procurado
	 * @return Lista ordenada das vendas que o cliente fez
	 * @throws SisVendasException
	 */
	public static ArrayList<Venda> procurarVendaCliente(Cliente cliente) throws SisVendasException{
		
		ArrayList<Venda> ListaAux = new ArrayList<Venda>(); 
 		
		for(Venda auxiliar : vendas.values()){
			if(auxiliar.getCliente() == cliente){
				ListaAux.add(auxiliar);
			}
		}
		
		if(ListaAux.isEmpty()){
			throw new SisVendasException("Não encontrado");
		}else{
			Collections.sort(ListaAux, new Comparator<Venda>() {
				
				@Override
				public int compare(Venda aux1, Venda aux2) {
					int compararNomes = aux1.getCliente().getNome().compareTo(aux2.getCliente().getNome());
					
					if(compararNomes == 0){
						return aux2.getDataVenda().compareTo(aux1.getDataVenda());
					}
					
					return compararNomes;
				}
				
			});
			
			return ListaAux;
		}
		
	}
	
	/**
	 * criar lista organizando por periodo ( pelo menos foi essa a intencao ) noobOn
	 * @author Daniel Nasciment
	 * @param dataInicio GregorianCalendar - data de inicio do periodo
	 * @param dataFinal GregorianCalendar - data final do periodo
	 * @return Lista desse periodo
	 * @throws SisVendaException
	 */
	public static ArrayList<Venda> procurarVendaPeriodo(GregorianCalendar dataInicio,GregorianCalendar dataFinal){
		
		ArrayList<Venda> listAux = new ArrayList<Venda>();
		
		for(Venda auxiliar : vendas.values()){
			if((auxiliar.getDataVenda().compareTo(dataInicio)) >= 0 && (auxiliar.getDataVenda().compareTo(dataFinal) <= 0)){
				listAux.add(auxiliar);
			}
		}
		
		Collections.sort(listAux, new Comparator<Venda>() {

			@Override
			public int compare(Venda aux1, Venda aux2) {
				int compararNomes = aux1.getCliente().getNome().compareTo(aux2.getCliente().getNome());
			
				if(compararNomes == 0){
					return aux2.getDataVenda().compareTo(aux1.getDataVenda());
				}
				
				return compararNomes;
			}
			
		});
			
		return listAux;
	}
	
	//-----------------------ESTATISTICAS------------------------//	
	
	/**
	 * Metodo para criar uma lista com a estatisticas do periodo de venda
	 * @author Daniel Nascimento
	 * @param GregorianCalendar dataInicio - Data de Inicio das estatisticas
	 * @param GregorianCalendar dataFinal - Data Final das estatisticas
	 * @return listaAux - Lista com a estatistica
	 */
	public static ArrayList<EstatisticaVenda> estatisticasVenda(GregorianCalendar dataInicio, GregorianCalendar dataFinal){
		
		int numVendas = 0;
		double valorTotal = 0;
		
		ArrayList<EstatisticaVenda> listaAux = new ArrayList<EstatisticaVenda>();
		
		EstatisticaVenda estatisticasVenda = new EstatisticaVenda();
		ArrayList<Venda> auxiliarPeriodo = procurarVendaPeriodo(dataInicio, dataFinal);
		
		for(Venda venda : auxiliarPeriodo){
			for(Produto produto : produtos.values()){
				for(ItemVenda item : venda.getVendaItem()){
					if(item.getProduto().getCodigo() == produto.getCodigo()){
						numVendas += item.getQuantVenda();
						valorTotal += item.getValorVenda();
						estatisticasVenda.setNome(produto.getNome());
						estatisticasVenda.setQtdVendas(numVendas);
						estatisticasVenda.setTotalVendas(valorTotal);
						listaAux.add(estatisticasVenda);
						numVendas = 0;
						valorTotal = 0;
					}
				}
			}
		}
		return listaAux;
	}
}
	

