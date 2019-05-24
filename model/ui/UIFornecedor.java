package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controlador.Fachada;
import excecoes.CnpjException;
import excecoes.NenhumException;
import model.entities.Fornecedor;

public class UIFornecedor {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static Fachada fachada = Fachada.getInstancia();
	
	static Scanner s = new Scanner (System.in);
	
	public static void exibirMenu() {
		
		System.out.println("Escolha uma das opções");
		System.out.println("1 - Cadastrar fornecedor");
		System.out.println("2 - Remover fornecedor");
		System.out.println("3 - Consultar fornecedor");
		
		int op = s.nextInt();
		
		switch (op) {
		case 1:
			cadastrarFornecedor();
			break;
		case 2:
			removerFornecedor();
			break;
		case 3:
			consultarFornecedor();
			break;
		default:
			System.out.println("Opção inválida");
			break;
			
		}
	}
	public static void cadastrarFornecedor() {
		try{
			System.out.print("Código: ");
			int codigo = s.nextInt();
			System.out.print("Nome: ");
			s.nextLine();
			String nome = s.nextLine();
			System.out.print("Nome fantasia: ");
			String nomeFantasia = s.nextLine();
			System.out.print("Endereço: ");
			String endereco = s.nextLine();
			System.out.print("Telefone (com DDD): ");
			String telefone = s.next();
			System.out.print("Cnpj: ");
			String cnpj = s.next();
			System.out.print("Data de abertura (dd/mm/yyyy): ");
			Date dataDeAbertura = sdf.parse(s.next());
			
			fachada.cadastrarFornecedor(new Fornecedor(codigo, nome, endereco, telefone, cnpj, nomeFantasia, dataDeAbertura));
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch (CnpjException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void removerFornecedor() {
		try {
			System.out.print("Cnpj do fornecedor a ser removido: ");
			String cnpj = s.next();
			
			fachada.removerFornecedor(cnpj);
		}
		catch (NenhumException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void consultarFornecedor() {
		try{
			System.out.print("Digite o nome fantasia para pesquisar: ");
			s.nextLine();
			String nomeFantasia = s.nextLine();
			
			System.out.println(fachada.consultarFornecedor(nomeFantasia));
		}
		catch (NenhumException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
