package model;

public abstract class Funcionario {
	
	private static String login = "diego";
	private static String senha = "1234";
	
	public static String getLogin() {
		return login;
	}
	public static void setLogin(String login) {
		Funcionario.login = login;
	}
	public static String getSenha() {
		return senha;
	}
	public static void setSenha(String senha) {
		Funcionario.senha = senha;
	}
	
	public static void login(String login, String senha) throws excecoes.LoginException {
		if ((!login.equals(Funcionario.login)) || (!senha.equals(Funcionario.senha))) {
			throw new excecoes.LoginException("login ou senha inválidos");
		}
	}
	

}
