package dados;

import java.util.GregorianCalendar;

public class Produto {

	private int codigo;
	private String nome;
	private double precoUnitario;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	//AUTO INCREMENTAR CODIGO
	private static int ultimoCod = 0;
	
	//CONSTRUTOR
	public Produto(String nome, double precoUnitario){
		ultimoCod++;
		this.codigo = ultimoCod;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
	}
	
	//GETTERS AND SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}

	public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}

	public static int getUltimoCod() {
		return ultimoCod;
	}

	public static void setUltimoCod(int ultimoCod) {
		Produto.ultimoCod = ultimoCod;
	}

	@Override
	public String toString() {
		return "codigo = " + codigo + 
				"\nnome = " + nome + 
				"\nprecoUnitario = " + precoUnitario + 
				"\ndataInclusao = " + dataInclusao + 
				"\ndataUltAlteracao = " + dataUltAlteracao;
	}

}
