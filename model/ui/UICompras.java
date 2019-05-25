package ui;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import controlador.Fachada;
import excecoes.ExisteException;
import excecoes.NenhumException;
import excecoes.QuantidadeException;
import model.entities.Cliente;
import model.entities.Item;
import model.entities.Produto;
import repositorio.Carrinho;

public class UICompras {
	
	private static Fachada fachada = Fachada.getInstancia();
	
	private static Scanner s = new Scanner(System.in);
	
	private static Carrinho carrinho = Carrinho.getInstancia();
	
	public static void receberCliente(Cliente c) {
		carrinho.setCliente(c);
	}
	
	public static void exibirMenu() {
		
		Random random = new Random(fachada.listarProdutos().size());
		Produto[] produtos = new Produto[5];
		for (int i = 0; i < 5; i++) {
			produtos[i] = fachada.listarProdutos().get(random.nextInt());
			System.out.println((i+1) + " - " + produtos[i] );	
		}
		
		System.out.println("9 - Pesquisar produto");
		System.out.println("0 - Ver carrinho");
		int op = s.nextInt();
		
		switch (op) {
		case 1:
			exibirProduto(produtos[0]);
			break;
		case 2:
			exibirProduto(produtos[1]);
			break;
		case 3:
			exibirProduto(produtos[2]);
			break;
		case 4:
			exibirProduto(produtos[3]);
			break;
		case 5:
			exibirProduto(produtos[4]);
			break;
		case 0:
			exibirCarrinho();
			break;
		case 9:
			pesquisarProduto();
		default:
			break;
		}
	}
	
	public static void exibirProduto(Produto p) {
		System.out.println(p);
		System.out.println("1 - Adicionar ao carrinho");
		System.out.println("2 - Voltar");
		System.out.println();
		System.out.println("Quem comprou " + p.getNome() + " também comprou:");
		
		int aux = 0;
		Produto[] relacionados = new Produto[3];
		for (Carrinho c : fachada.listarCarrinhos()) {
			for (int i = 0; i < fachada.listarCarrinhos().size(); i++) {
			if (c.listarItens().get(i).getProduto().equals(p)) {
				relacionados[aux] = p;
				aux++;
				if (aux == 2) {
					break;
				}
			}
		}
		int op = s.nextInt();
		switch (op) {
		case 1:
			try {
				System.out.print("Quantidade :");
				int qtd = s.nextInt();
				Item i = new Item((carrinho.listarItens().size()+1), qtd, p);
				
				if (fachada.existeItem(i)) {
					fachada.incrementarItem(i, qtd);	
				}
				else {
					fachada.addItem(i);
				}
			}
			catch (ExisteException e) {
				System.out.println(e.getMessage());
				
			} catch (QuantidadeException e) {
				System.out.println(e.getMessage());
			}
		
			exibirCarrinho();
			break;
		case 2:
			exibirMenu();
			break;
		}
		
	}
	}
	
	public static void exibirCarrinho() {
		
		try {
			for (Item i : fachada.listarItens()) {
				System.out.println(i);
			}
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Selecione o código do item para alterar a quantidade ou");
		System.out.println("0 - Continuar compra");
		System.out.println("-1 - Finalizar compra");
		int op = s.nextInt();
		if (op == 0) {
			exibirMenu();
		}
		else if (op == -1) {
			finalizarCompra();	
		} else
			try {
				if (op == fachada.mostrarItem(op).getCodigo()) {
					exibirProduto(fachada.mostrarItem(op).getProduto());
				}

			} catch (NenhumException e) {
				System.out.println(e.getMessage());
				return;
			}
	}
	
	public static void pesquisarProduto() {
		System.out.print("Digite o nome do produto: ");
		s.nextLine();
		String nome = s.nextLine();
		
		try {
			exibirProduto((fachada.consultarProduto(nome)));
		}
		catch (NenhumException e) {
			System.out.println(e.getMessage());
			exibirMenu();
		}
	}
	public static void finalizarCompra() {
		
		System.out.print("Digite a senha para confirmar a compra :");
		String senha = s.next();
		
		if(carrinho.getCliente().getSenha().equals(senha)) {
			try {
				carrinho.setDataPedido(new Date());
				fachada.addCarrinho(carrinho);
				for (Item i : carrinho.listarItens()) {
					fachada.decrementarProduto(i);
				}
				fachada.esvaziarCarrinho();
			}
			catch (QuantidadeException e) {
				System.out.println(e.getMessage());
				exibirCarrinho();
			}
			
		}	
		else {
			System.out.println("Senha incorreta");
			return;
		}	
	}
}


