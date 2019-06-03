package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import controlador.Fachada;
import excecoes.ExisteException;
import excecoes.NenhumException;
import excecoes.QuantidadeException;
import model.Cliente;
import model.Item;
import model.Produto;
import repositorio.Carrinho;

public class UICompras {

	private static Fachada fachada = Fachada.getInstancia();

	private static Scanner s = new Scanner(System.in);

	private static Carrinho carrinho = Carrinho.getInstancia();

	public static void receberCliente(Cliente c) {
		carrinho.setCliente(c);
	}

	public static void exibirMenu() {

		try {
			//Random random = new Random(fachada.listarProdutos().size());
			List<Produto> randoma = new ArrayList<Produto>();
			
			Random indice = new Random();
			
			for (Produto p : fachada.listarProdutos()) {
				randoma.add(p);
			}
			
			//Produto[] produtos = new Produto[5];
			List<Produto> aleatorio = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
			
				int random = indice.nextInt(randoma.size());
				aleatorio.add(randoma.get(random));
				randoma.remove(random);
			}
			for (int i = 0; i < 5; i++) {
			
				System.out.println("#" + (i+1) + " " + aleatorio.get(i).getNome());
			}

			System.out.println("9 - Pesquisar produto");
			System.out.println("0 - Ver carrinho");
			int op = s.nextInt();

			switch (op) {
			case 1:
				exibirProduto(aleatorio.get(0));
				//exibirProduto(produtos[0]);
				break;
			case 2:
				exibirProduto(aleatorio.get(1));
				//exibirProduto(produtos[1]);
				break;
			case 3:
				exibirProduto(aleatorio.get(2));
				//exibirProduto(produtos[2]);
				break;
			case 4:
				exibirProduto(aleatorio.get(3));
				//exibirProduto(produtos[3]);
				break;
			case 5:
				exibirProduto(aleatorio.get(4));
				//exibirProduto(produtos[4]);
				break;
			case 0:
				exibirCarrinho();
				break;
			case 9:
				pesquisarProduto();
			default:
				break;
			}
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void exibirProduto(Produto p) {

		try {
			System.out.println(p);
			System.out.println("0 - Adicionar ao carrinho");
			System.out.println("-1 - Voltar");
			System.out.println();
			System.out.println("Quem comprou " + p.getNome() + " também comprou:");

			int aux = 0;
			Produto[] relacionados = new Produto[3];

			// for (Carrinho c : fachada.listarCarrinhos()) {
				for (int j = 0; j < fachada.listarCarrinhos().size(); j++) {
					for (Item i : fachada.listarCarrinhos().get(j).listarItens()) {
						if (i.getProduto().equals(p)) {
							relacionados[aux] = p;
							aux++;
							if (aux == 2) {
								break;
					}
					
						}
					}
				}
			// }

			for (int i = 0; i < relacionados.length; i++) {
				System.out.println(relacionados[i]);
			}

			int op = s.nextInt();

			switch (op) {
			case 0:
				System.out.print("Quantidade :");
				int qtd = s.nextInt();

				Item i = new Item((fachada.tamanho()), qtd, p);

				if (fachada.existeItem(i)) {
					fachada.incrementarItem(i, qtd);
				} else {
					fachada.addItem(i);
				}

				exibirCarrinho();
				break;
			case -1:
				exibirMenu();
				break;
			}
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
		} catch (ExisteException e) {
			System.out.println(e.getMessage());
		} catch (QuantidadeException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void exibirCarrinho() {

		try {
			for (Item i : fachada.listarItens()) {
				System.out.println(i);
			}

			System.out.println("Selecione o código do item para alterar a quantidade ou");
			System.out.println("0 - Continuar compra");
			System.out.println("-1 - Finalizar compra");
			int op = s.nextInt();
			if (op == 0) {
				exibirMenu();
			} else if (op == -1) {
				finalizarCompra();
			} else if (op == fachada.mostrarItem(op).getCodigo()) {
				System.out.println(fachada.mostrarItem(op));
				System.out.print("Quantidade: ");
				int qtd = s.nextInt();
				if (qtd == 0) {
					fachada.removeItem(fachada.mostrarItem(op));
				} else {
					fachada.alterarQuantidade(fachada.mostrarItem(op), qtd);
				}
			}

		} catch (NenhumException e) {
			System.out.println(e.getMessage());
			exibirMenu();
		} catch (QuantidadeException e) {
			System.out.println(e.getMessage());
			exibirMenu();
		}
	}

	public static void pesquisarProduto() {

		try {
			System.out.print("Digite o nome do produto: ");
			s.nextLine();
			String nome = s.nextLine();

			exibirProduto((fachada.consultarProduto(nome)));
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
			exibirMenu();
		}
	}

	public static void finalizarCompra() {

		try {
			System.out.print("Digite a senha para confirmar a compra :");
			String senha = s.next();

			if (carrinho.getCliente().getSenha().equals(senha)) {

				carrinho.setDataPedido(new Date());
				fachada.addCarrinho(carrinho);

				for (Item i : fachada.listarItens()) {

					fachada.decrementarProduto(i);
				}

				fachada.esvaziarCarrinho();
			} else {
				System.out.println("Senha incorreta");
				finalizarCompra();
			}
		} catch (QuantidadeException e) {
			System.out.println(e.getMessage());
			exibirCarrinho();
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
			exibirCarrinho();
		}

	}

}
