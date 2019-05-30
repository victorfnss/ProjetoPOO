package model;

import java.util.Date;

public class Cliente extends Pessoa {

	private String cpf;
	private Date dataDeNascimento;
	private String login;
	private String senha;
	
	public Cliente(Integer codigo, String nome, String endereco, String telefone, String cpf, Date dataDeNascimento,
			String login, String senha) {
		super(codigo, nome, endereco, telefone);
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.login = login;
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
			this.cpf = cpf;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Cliente #"
				+super.getCodigo()
				+" "
				+super.getNome();
	}
}
