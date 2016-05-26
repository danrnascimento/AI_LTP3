package dados;


import java.io.Serializable;
import java.io.ObjectInputStream.GetField;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

/**Classe para Produtos.
 * @author Daniel Nascimento
 * @since 09/05/2016
 * @version 1.0 
 */

public class Produto implements Serializable {

	private Integer codigo;
	private String nome;
	private Double precoUnitario;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	/**Atributo para autoincrementar o codigo do produto */	
	private static int seq;
	
	private int dia = new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH);
	private int mes = new GregorianCalendar().get(GregorianCalendar.MONTH);
	private int ano = new GregorianCalendar().get(GregorianCalendar.YEAR);
	
	/**Metodo construtor do Objeto Produto
	*	@author Daniel Nascimento
	*	@param nome String - nome do produto
	*	@param precoUnitario double - preco do produto
	*/
	public Produto(String nome, double precoUnitario){
		codigo = ++seq;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.dataInclusao = new GregorianCalendar(ano,mes,dia);
	}
	
	public int getCodigo() {
		return codigo;
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

	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}
	
	public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao){
		this.dataUltAlteracao = dataUltAlteracao;
	}

	public static void setSeq(int seq) {
		Produto.seq = seq;
	}
	
	public static int getSeq(){
		return Produto.seq;
	}
	
	/**Metodo para passar dados para String
	 * @author Daniel Nascimento
	 * @return String - Todos os atributos passados para String 
	*/
	@Override
	public String toString() {
		return "\ncodigo = " + codigo + 
				"\nnome = " + nome + 
				"\nprecoUnitario = " + precoUnitario + 
				"\ndataInclusao = " + LtpUtil.formatarData(dataInclusao, "dd/MM/yyyy") + 
				"\ndataUltAlteracao = " + LtpUtil.formatarData(dataUltAlteracao, "dd/MM/yyyy");
	}

}
