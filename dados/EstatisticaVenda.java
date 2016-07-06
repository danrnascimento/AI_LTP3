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
	private String nomeProd;
	private int qtdVendas;
	private int qtdVendaProd;
	private Double totalVendas;
	private Double totalVendasProd;
	
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

	public Double getTotalVendasProd() {
		return totalVendasProd;
	}

	public void setTotalVendasProd(Double totalVendasProd) {
		this.totalVendasProd = totalVendasProd;
	}

	public int getQtdVendaProd() {
		return qtdVendaProd;
	}

	public void setQtdVendaProd(int qtdVendaProd) {
		this.qtdVendaProd = qtdVendaProd;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	
	@Override
	public String toString() {
		return	"--------------" + 
				"\nNome = " + nome + 
				"\nQuantidade = " + qtdVendas +
				"\nValor Total = " + totalVendas;
	}
/*
	@Override
	public String toString() {
		return	"--------------" + 
				"\nNome do Cliente = " + nome + 
				"\nQuantidade de compras = " + qtdVendas +
				"\nValor Total = " + totalVendas;
	}
*/
}
