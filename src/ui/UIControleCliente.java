package ui;

import java.util.Scanner;

import controlador.Fachada;
import excecoes.CpfException;
import excecoes.NenhumException;
import model.Cliente;

public class UIControleCliente {
	
	private static Fachada fachada = Fachada.getInstancia();
	
	static Scanner s = new Scanner (System.in);

	public static void exibirMenu() {
		System.out.println("1 - Remover cliente");
		System.out.println("2 - Consultar cliente");
		System.out.println("3 - Listar clientes");
		System.out.println("4 - Voltar");
		
		int op = s.nextInt();
		
		switch (op) {
		case 1:
			removerCliente();
			break;
		case 2:
			consultarCliente();
			break;
		case 3:
			listarCliente();
			break;
		case 4:
			UIFuncionario.menuFuncionario();
			break;
			default:
				System.out.println("Opção inválida");
				System.out.println();
				exibirMenu();
		}
	}
	public static void removerCliente() {
		try {
			System.out.print("Login do usuário a ser removido: ");
			String login = s.next();
			fachada.removerCliente(login);
			System.out.println();
			exibirMenu();
		}
		catch (CpfException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();
		}
	}
	
	public static void consultarCliente() {
		try {
			System.out.print("Cpf do cliente a ser consultado: ");
			String cpf = s.next();
			System.out.println(fachada.consultaCliente(cpf));
			System.out.println();
			exibirMenu();
		} 
		catch (CpfException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();
		}
	}

	public static void listarCliente() {
		try {
			System.out.println("1 - listar todos os clientes");
			System.out.println("2 - listar clientes por endereço");
			int op = s.nextInt();
			
			if (op == 1) {
				for (Cliente c :fachada.listarCliente()) {
					System.out.println(c);
				}
				System.out.println();
				exibirMenu();
			}
			if (op ==2) {
				System.out.print("Endereço: ");
				s.nextLine();
				String endereco = s.nextLine();
				for (Cliente c : fachada.listarCliente(endereco)) {
					System.out.println(c);
				}
				System.out.println();
				exibirMenu();
			}
		}
		catch (NenhumException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
