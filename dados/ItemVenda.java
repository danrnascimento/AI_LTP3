package dados;

import java.io.*;
import utilitarios.LtpUtil;

/**Classe para Item Venda.
 * @author Daniel Nascimento
 * @version 1.0
 * @since 09/05/2016
 */
public class ItemVenda implements Serializable{
	
	private Produto produto;
	private double precoUnitario;
	private int quantVenda;
	private double valorVenda;
	private Double valorFinal;
	
	/**
	 * Metodo Construtor
	 * @author Daniel Nascimento
	 * @param produto Produto
	 * @param precoUnitario double
	 * @param quantVenda int
	 * @param valorVenda double
	 */
	public ItemVenda(Produto produto, double precoUnitario, int quantVenda, double valorVenda) {
		super();
		this.produto = produto;
		this.precoUnitario = precoUnitario;
		this.quantVenda = quantVenda;
		this.valorVenda = valorVenda;
	}

	//GETTERS E SETTERS
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getQuantVenda() {
		return quantVenda;
	}

	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	/**Metodo para passar dados para String
	 * @author Daniel Nascimento
	 * @return String - Todos os atributos passados para String 
	*/
	@Override
	public String toString() {
		return "\n --------------" +
				"\nProduto = " + produto.getNome() + 
				"\nPreco Unitario = " + precoUnitario +
				"\nValor total dos Produtos = " + valorVenda;
	}
	
	
}
