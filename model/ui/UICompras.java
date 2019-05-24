package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import controlador.Fachada;
import excecoes.NenhumException;
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
			if (c.getListaItem().get(i).getProduto().equals(p)) {
				relacionados[aux] = p;
				aux++;
			}
		}
		int op = s.nextInt();
		switch (op) {
		case 1:
			System.out.print("Quantidade :");
			int qtd = s.nextInt();
			Item i = new Item((carrinho.getListaItem().size()+1),qtd, p);
			carrinho.addItem(i);
			break;
		case 2:
			exibirMenu();
			break;
		}
		
	}
	}
	
	public static void exibirCarrinho() {
		for (Item i : carrinho.getListaItem()) {
			System.out.println(i);
		}
		System.out.println("1 - Continuar compra");
		System.out.println("2 - Finalizar compra");
		int op = s.nextInt();
		if (op == 1) {
			exibirMenu();
		}
		else if (op == 2) {
			finalizarCompra();	
		}
		else {
			System.out.println("Opção inválida!");
			return;
		}
	}
	
	public static void pesquisarProduto() {
		System.out.print("Digite o nome do produto: ");
		s.nextLine();
		String nome = s.nextLine();
		
		try {
			System.out.println(fachada.consultarProduto(nome));
		}
		catch (NenhumException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void finalizarCompra() {
		
		System.out.print("Digite a senha para confirmar a compra :");
		String senha = s.next();
		
		if(carrinho.getCliente().getSenha().equals(senha)) {
			carrinho.setDataPedido(new Date());
			for (Produto p : fachada.listarProdutos()) {
				for (Item i : carrinho.getListaItem()) {
					if (i.getProduto().equals(p)){
						p.setQuantidade(p.getQuantidade() - i.getQuantidade());
					}
				}	
			}
			
			fachada.addCarrinho(carrinho);
			carrinho.getListaItem().clear();	
		}
		else {
			System.out.println("Senha incorreta");
			return;
		}
		
		
	}
		
}


