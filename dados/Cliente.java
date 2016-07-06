package dados;

/**
 * Classe para Cliente
 * @author Daniel Nascimento
 * @since 09/05/2016
 * @version 1.0
 */

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Cliente implements Serializable{
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	private int dia = new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH);
	private int mes = new GregorianCalendar().get(GregorianCalendar.MONTH);
	private int ano = new GregorianCalendar().get(GregorianCalendar.YEAR);
	
	/**
	 * Construtor
	 * @author Daniel Nascimento
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	public Cliente(String cpf, String nome, String email, String telefone){
		this.dataInclusao = new GregorianCalendar(ano,mes,dia);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	/**
	 * Construtor
	 * @param cpf
	 */
	public Cliente(String cpf){
		this.cpf = cpf;
	}
	
	//GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}

	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}

	public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}

	/**Metodo para passar dados para String
	 * @author Daniel Nascimento
	 * @return String - Todos os atributos passados para String 
	*/
	@Override
	public String toString() {
		return "\nCpf = " + cpf + 
				"\nNome = " + nome + 
				"\nTelefone = " + telefone + 
				"\nEmail = " + email + 
				"\nDataInclusao = " + LtpUtil.formatarData(dataInclusao, "dd/MM/yyyy")+ 
				"\nDataUltAlteracao = " + LtpUtil.formatarData(dataUltAlteracao, "dd/MM/yyyy");
	}
	
}
