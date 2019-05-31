package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controlador.Fachada;
import excecoes.CnpjException;
import excecoes.NenhumException;
import model.Fornecedor;

public class UIFornecedor {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static Fachada fachada = Fachada.getInstancia();

	static Scanner s = new Scanner(System.in);

	public static void exibirMenu() {

		System.out.println("Escolha uma das opções");
		System.out.println("1 - Cadastrar fornecedor");
		System.out.println("2 - Remover fornecedor");
		System.out.println("3 - Consultar fornecedor");
		System.out.println("4 - Listar fornecedores");

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
		case 4:
			listarFornecedores();
			break;
		default:
			System.out.println("Opção inválida");
			return;

		}
	}

	public static void cadastrarFornecedor() {
		try {
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

			fachada.cadastrarFornecedor(
					new Fornecedor(codigo, nome, endereco, telefone, cnpj, nomeFantasia, dataDeAbertura));
			System.out.println("Fornecedor cadastrado com sucesso!");
			System.out.println();
			exibirMenu();
		} catch (ParseException e) {
			System.out.println("Formato de data inválido");
			System.out.println();
			exibirMenu();
		} catch (CnpjException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();
		}
	}

	public static void removerFornecedor() {
		try {
			System.out.print("Cnpj do fornecedor a ser removido: ");
			String cnpj = s.next();

			fachada.removerFornecedor(cnpj);
			System.out.println();
			exibirMenu();
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();

		}
	}

	public static void consultarFornecedor() {
		try {
			System.out.print("Digite o CNPJ para pesquisar: ");
			String cnpj = s.next();

			System.out.println(fachada.consultarFornecedor(cnpj));
			System.out.println();
			exibirMenu();
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();
		}

	}

	public static void listarFornecedores() {
		try {
			for (Fornecedor f : fachada.listarFornecedor()) {
				System.out.println(f);
			}
			System.out.println();
			exibirMenu();
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();
		}
	}

}
