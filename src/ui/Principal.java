package ui;

import java.util.Scanner;

import util.Util;

public class Principal {

	public static void main(String[] args) {
		
		Util.inicializar();
		
		Scanner s = new Scanner(System.in);
	
		int op;
		
		do {
		
			System.out.println("Escolha uma das opções abaixo");
			System.out.println("1 - Sou cliente");
			System.out.println("2 - Sou funcionário");
			
			op = s.nextInt();
			
			switch(op) {
			case 1:
				UICliente.exibirMenuCliente();
				break;
			case 2:
				UIFuncionario.exibirMenu();
				break;
			default:
				System.out.println("Opção inválida");
					
			}
		} while (op == 1 || op == 2);
		
		s.close();
		
	}
}
