package dados;


import erros.*;

public class EstatisticaVenda {

	private String nome;
	private int qtdVendas;
	private Double totalVendas;
	
	public EstatisticaVenda(){
		this.nome = nome;
		this.qtdVendas = qtdVendas;
		this.totalVendas = totalVendas;
	}
	
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
	
	@Override
	public String toString() {
		return	"\nnome = " + nome + 
				"\nqtdVendas = " + qtdVendas +
				"\nvalorTotal = " + totalVendas;
	}
	
}
