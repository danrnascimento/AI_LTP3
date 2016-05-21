package dados;


import erros.*;

/**
 * Classe para Estatistica de Vendas
 * @author Daniel Nascimento
 * @since 09/05/2016
 * @version 1.0
 */
public class EstatisticaVenda {

	private String nome;
	private int qtdVendas;
	private Double totalVendas;
	
	/**
	 * Construtor
	 * @author Daniel Nascimento
	 */
	public EstatisticaVenda(){
		this.nome = nome;
		this.qtdVendas = qtdVendas;
		this.totalVendas = totalVendas;
	}
	
	//GETTERS E SETTERS
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public int getQtdVendas(){
		return this.qtdVendas;
	}
	
	public void setQtdVendas(int qtdVendas){
		this.qtdVendas = qtdVendas;
	}
	
	public Double getTotalVendas(){
		return totalVendas;
	}
	
	public void setTotalVendas(Double totalVendas){
		this.totalVendas = totalVendas;
	}
	
	/**Metodo para passar dados para String
	 * @author Daniel Nascimento
	 * @return String - Todos os atributos passados para String 
	*/
	@Override
	public String toString() {
		return	"--------------" + 
				"\nNome do Cliente = " + nome + 
				"\nQuantidade de compras = " + qtdVendas +
				"\nValor Total = " + totalVendas;
	}
	
}
