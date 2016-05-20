package dados;

/**Classe para objetos do tipo Produto, onde serão contidos, valores e métodos para o mesmo.

 * @author Daniel Nascimento

 */

import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Produto {

	private int codigo;
	private String nome;
	private Double precoUnitario;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	/**Atributo para autoincrementar o codigo do produto */	
	private static int ultimoCod = 0;
	
	/**Metodo construtor do Objeto Produto
	
	*	@author Daniel Nascimento
	
	*	@param nome String - nome do produto
	*	@param precoUnitario double - preco do produto
	
	*/
	
	public Produto(String nome, double precoUnitario){
		this.codigo = ++ultimoCod;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.dataInclusao = dataInclusao;
		this.dataUltAlteracao = dataUltAlteracao;
	}
	
	public int getCodigo() {
		return ultimoCod;
	}
	
	/*
	public void setCodigo(int codigo) {
		Produto.ultimoCod = codigo;
	}
 	*/
	
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

	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}

	public static void setUltimoCod(int ultimoCod) {
		Produto.ultimoCod = ultimoCod;
	}
	
	
	/**Metodo para passar dados para String
	 
	 * @author Daniel Nascimento
	 
	 * @return String - Todos os atributos passados para String 
	 
	*/
	@Override
	public String toString() {
		return "codigo = " + codigo + 
				"\nnome = " + nome + 
				"\nprecoUnitario = " + precoUnitario + 
				"\ndataInclusao = " + LtpUtil.formatarData(dataInclusao, "dd/MM/yyyy") + 
				"\ndataUltAlteracao = " + LtpUtil.formatarData(dataUltAlteracao, "dd/MM/yyyy");
	}

}
