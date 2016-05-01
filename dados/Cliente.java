package dados;

import java.util.GregorianCalendar;

public class Cliente {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	//CONSTRUTOR
	
	public Cliente(String cpf, String nome){
		this.cpf = cpf;
		this.setNome(nome);
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

	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}

	public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}


	//METODOS:
	
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", dataInclusao=" + dataInclusao + ", dataUltAlteracao=" + dataUltAlteracao + "]";
	}
	
}
