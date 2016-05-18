package dados;

/**Classe para objetos do tipo Cliente, onde serão contidos, valores e métodos para o mesmo.

 * @author Daniel Nascimento


 */

import java.util.GregorianCalendar;

public class Cliente {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	private int dia = new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH);
	private int mes = new GregorianCalendar().get(GregorianCalendar.MONTH);
	private int ano = new GregorianCalendar().get(GregorianCalendar.YEAR);
	
	//CONSTRUTOR
	
	public Cliente(String cpf, String nome, String email, String telefone){
		this.dataInclusao = new GregorianCalendar(ano,mes,dia);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	//GETTER AND SETTERS
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

	/*public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}*/


	//METODOS:
	
	@Override
	public String toString() {
		return "cpf = " + cpf + 
				"\nnome = " + nome + 
				"\ntelefone = " + telefone + 
				"\nemail = " + email + 
				"\ndataInclusao = " + dataInclusao+ 
				"\ndataUltAlteracao = " + dataUltAlteracao;
	}
	
}
