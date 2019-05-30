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
			;

			if (f == null) {
				try {
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

				} catch (ParseException e) {
					System.out.println("Formato de data inválido");
				} catch (CnpjException e) {
					System.out.println(e.getMessage());
				} catch (ExisteException e) {
					System.out.println(e.getMessage());
				}

			} else {
				try {
					fachada.cadastrarFornecedor(f);
					fachada.cadastrarProduto(new Produto(codigo, nome, descricao, f, quantidade, categoria));
				} catch (ExisteException e) {
					System.out.println(e.getMessage());
				}
				catch (CnpjException ex) {
					System.out.println(ex.getMessage());		
			}

		} 
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void removerProduto() {
		System.out.println("Digite os dados do produto a ser removido");
		System.out.print("Categoria: ");
		s.nextLine();
		String categoria = s.nextLine();
		System.out.print("Nome: ");
		String nome = s.nextLine();

		fachada.removerProduto(categoria, nome);
	}

	public static void consultarProduto() {
		System.out.print("Nome: ");
		s.nextLine();
		String nome = s.nextLine();

		try {
			fachada.consultarProduto(nome);
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void listarProdutos() {
		System.out.println("1 - listar todos os produtos");
		System.out.println("2 - listar produtos por categoria");

		int op = s.nextInt();

		if (op == 1) {
			for (Produto p : fachada.listarProdutos()) {
				System.out.println(p);
			}
		} else if (op == 2) {
			System.out.print("Categoria: ");
			s.nextLine();
			String categoria = s.nextLine();

			try {
				for (Produto p : fachada.listarProdutos(categoria)) {
					System.out.println(p);
				}
			} catch (NenhumException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Opção inválida");
		}
	}
}
