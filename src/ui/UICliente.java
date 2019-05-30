package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controlador.Fachada;
import excecoes.CpfException;
import excecoes.LoginException;
import excecoes.NenhumException;
import model.Cliente;

public class UICliente {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private static Fachada fachada = Fachada.getInstancia();
	
	static Scanner s = new Scanner (System.in);
	
	public static void exibirMenuCliente() {
		System.out.println("1 - Já sou cadastrado");
		System.out.println("2 - Cliente novo (Fazer cadastro)");
		
		int op = s.nextInt();
		
		if (op == 1) {
			login();
		}
		if (op == 2) {
			cadastrarCliente();
		}
	}
	
	public static void login() {
		
		try {
			
			System.out.print("login: ");
			String login = s.next();
			System.out.print("senha: ");
			String senha = s.next();
			
			Cliente c = fachada.login(login, senha);
		
			 if (c != null) {
				 UICompras.receberCliente(c);
				 UICompras.exibirMenu();	 
			 }
		 }
		catch (LoginException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void cadastrarCliente() {
		try {
			
			System.out.print("Nome: ");
			s.nextLine();
			String nome = s.nextLine();
			System.out.print("Endereço: ");
			String endereco = s.nextLine();
			System.out.print("Telefone (com DDD): ");
			String telefone = s.next();
			System.out.print("Cpf: ");
			String cpf = s.next();
			System.out.print("Data de nascimento (dd/mm/yyyy): ");
			Date dataDeNascimento = sdf.parse(s.next());	
			
			System.out.println();
			System.out.print("login: ");
			String login = s.next();
			System.out.print("senha: ");
			String senha = s.next();
			
			Cliente c = new Cliente((fachada.listarCliente().size()+1), nome, endereco, telefone, cpf, dataDeNascimento, login, senha);
			fachada.cadastrarCliente(c);
			
			UICompras.exibirMenu();
		}
		
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (CpfException e) {
			System.out.println(e.getMessage());
		} 
		catch (NenhumException e) {
		System.out.println(e.getMessage());
		}
	}
	
	
}
