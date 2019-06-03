package ui;

import java.util.Scanner;

import controlador.Fachada;
import excecoes.LoginException;
import excecoes.NenhumException;
import model.Funcionario;
import repositorio.Carrinho;

public class UIFuncionario {
	
	private static Scanner s = new Scanner (System.in);
	
	private static Fachada fachada = Fachada.getInstancia();
	
	public static void login() {
		try {
			System.out.print("login: ");
			String login = s.next();
			System.out.print("senha: ");
			String senha = s.next();
			
			Funcionario.login(login, senha);
			
			menuFuncionario();
			
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void menuFuncionario() {
		System.out.println("Escolha a seção desejada");
		System.out.println("1 - Produtos");
		System.out.println("2 - Clientes");
		System.out.println("3 - Listar carrinhos de compras");
		System.out.println("4 - Fornecedores");
		
		int op = s.nextInt();
		
		switch(op) {
		case 1:
			UIProduto.exibirMenu();
			break;
		case 2:
			UIControleCliente.exibirMenu();
			break;
		case 3:
			try {
				
				for (Carrinho car: fachada.listarCarrinhos()) {
					System.out.println("Carrinho #"+ (fachada.listarCarrinhos().indexOf(car)+1) +"\n" + car);
				}
			} 
			catch (NenhumException e) {
				System.out.println(e.getMessage());
				menuFuncionario();
			}
			System.out.println();
			menuFuncionario();
		case 4:
			UIFornecedor.exibirMenu();
			break;
		default:
			System.out.println("Opção inválida");
			return;
		}
	}

}
