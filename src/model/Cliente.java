package model;

import java.util.Date;

public class Cliente extends Pessoa {

	private Integer codigo;
	private String cpf;
	private Date dataDeNascimento;
	private String login;
	private String senha;
	
	public Cliente(Integer codigo, String nome, String endereco, String telefone, String cpf, Date dataDeNascimento,
			String login, String senha) {
		super(codigo, nome, endereco, telefone);
		this.codigo = codigo;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.login = login;
		this.senha = senha;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if (cpf.length() < 11) {
			this.cpf = null;
		} else {
			this.cpf = cpf;
		}
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
