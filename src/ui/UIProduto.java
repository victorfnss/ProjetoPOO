package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controlador.Fachada;
import excecoes.CnpjException;
import excecoes.ExisteException;
import excecoes.NenhumException;
import model.Fornecedor;
import model.Produto;

public class UIProduto {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static Fachada fachada = Fachada.getInstancia();

	static Scanner s = new Scanner(System.in);

	public static void exibirMenu() {

		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Remover produto");
		System.out.println("3 - Consultar produto");
		System.out.println("4 - Listar produtos");

		int op = s.nextInt();

		switch (op) {
		case 1:
			cadastrarProduto();
			break;
		case 2:
			removerProduto();
			break;
		case 3:
			consultarProduto();
			break;
		case 4:
			listarProdutos();
			break;
		}
	}

	public static void cadastrarProduto() {
		try {

			System.out.print("Código: ");
			int codigo = s.nextInt();
			System.out.print("Nome: ");
			s.nextLine();
			String nome = s.nextLine();
			System.out.print("Descrição: ");
			String descricao = s.nextLine();
			System.out.print("Categoria: ");
			String categoria = s.nextLine();
			System.out.print("Quantidade : ");
			int quantidade = s.nextInt();

			System.out.print("Fornecedor (cnpj): ");
			String cnpj = s.next();

			Fornecedor f = fachada.listarFornecedor().stream().filter(x -> x.getCnpj().equals(cnpj)).findFirst()
					.orElse(null);

			if (f != null) {

				fachada.cadastrarFornecedor(f);
				fachada.cadastrarProduto(new Produto(codigo, nome, descricao, f, quantidade, categoria));

			} else {

				System.out.print("Código: ");
				int codigof = s.nextInt();
				System.out.print("Nome: ");
				s.nextLine();
				String nomef = s.nextLine();
				System.out.print("Nome fantasia: ");
				String nomeFantasia = s.nextLine();
				System.out.print("Endereço: ");
				String enderecof = s.nextLine();
				System.out.print("Telefone (com DDD): ");
				String telefonef = s.next();
				System.out.print("Data de abertura (dd/mm/yyyy): ");
				Date dataDeAbertura = sdf.parse(s.next());

				f = new Fornecedor(codigof, nomef, enderecof, telefonef, cnpj, nomeFantasia, dataDeAbertura);

				fachada.cadastrarFornecedor(f);
				fachada.cadastrarProduto(new Produto(codigo, nome, descricao, f, quantidade, categoria));
				
				System.out.println();
				exibirMenu();
			}
		} catch (ExisteException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();
		} catch (CnpjException ex) {
			System.out.println(ex.getMessage());
			System.out.println();
			exibirMenu();
		} catch (ParseException e) {
			System.out.println("Formato de data inválido");
			System.out.println();
			exibirMenu();
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();
		}
	}

	public static void removerProduto() {

		try {
			System.out.println("Digite os dados do produto a ser removido");
			System.out.print("Categoria: ");
			s.nextLine();
			String categoria = s.nextLine();
			System.out.print("Nome: ");
			String nome = s.nextLine();

			fachada.removerProduto(categoria, nome);
			System.out.println();
			exibirMenu();
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();
		}
	}

	public static void consultarProduto() {

		try {
			System.out.print("Nome: ");
			s.nextLine();
			String nome = s.nextLine();

			System.out.println(fachada.consultarProduto(nome));
			
			System.out.println();
			exibirMenu();

		} catch (NenhumException e) {
			System.out.println(e.getMessage());
			System.out.println();
			exibirMenu();
		}
	}

	public static void listarProdutos() {

		System.out.println("1 - listar todos os produtos");
		System.out.println("2 - listar produtos por categoria");

		int op = s.nextInt();

		if (op == 1) {
			try {
				for (Produto p : fachada.listarProdutos()) {
					System.out.println("Produto #" + p.getCodigo() + ": " + p);
					
				}
				System.out.println();
				exibirMenu();
			}
			catch (NenhumException e) {
				System.out.println(e.getMessage());
				System.out.println();
				exibirMenu();
			}
			
		}
		else if (op == 2) {
			try {
				System.out.print("Categoria: ");
				s.nextLine();
				String categoria = s.nextLine();

				for (Produto p : fachada.listarProdutos(categoria)) {
					System.out.println("Produto #" + p.getCodigo() + ": " + p);
					
				}
				System.out.println();
				exibirMenu();
			} catch (NenhumException e) {
				System.out.println(e.getMessage());
				System.out.println();
				exibirMenu();
			}
		} else {
			System.out.println("Opção inválida");
			System.out.println();
			exibirMenu();
		}
	}
}
