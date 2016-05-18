package dados;


import erros.*;

public class EstatisticaVenda {

	private String nome;
	private int qtdVendas;
	private Double totalVendas;
	
	public EstatisticaVenda(String nome){
		this.nome = nome;
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
	
}
