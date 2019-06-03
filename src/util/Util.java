package util;

import java.text.ParseException;
import java.util.Date;

import controlador.Fachada;
import excecoes.CnpjException;
import excecoes.CpfException;
import excecoes.ExisteException;
import excecoes.NenhumException;
import excecoes.QuantidadeException;
import model.Cliente;
import model.Fornecedor;
import model.Item;
import model.Produto;
import repositorio.Carrinho;

public class Util {

	private static Fachada fachada = Fachada.getInstancia();

	

	public static void inicializar() {

		try {
			Cliente c = new Cliente(1, "Maria", "Rua Jean Emile Favre", "(81)12345-6789", "123", new Date(), "maria",
					"1234");
			fachada.cadastrarCliente(c);
			Cliente c1 = new Cliente(2, "João", "Rua Jean Emile Favre", "(81)12345-6789", "456", new Date(), "joao",
					"1234");
			fachada.cadastrarCliente(c1);
			Cliente c2 = new Cliente(3, "Victor", "Av. Boa Viagem", "(81)12345-6789", "789", new Date(), "victor",
					"1234");
			fachada.cadastrarCliente(c2);
			Cliente c3 = new Cliente(4, "Felipe", "Av. Boa Viagem", "(81)12345-6789", "012", new Date(), "felipe",
					"1234");
			fachada.cadastrarCliente(c3);
			Cliente c4 = new Cliente(5, "Jessica", "Av. Boa Viagem", "(81)12345-6789", "345", new Date(), "jessica",
					"1234");
			fachada.cadastrarCliente(c4);

			Fornecedor f = new Fornecedor(1, "Centro Universitário UniFBV", "Rua Jean Emile Favre", "(81)12345-6789",
					"12345", "UniFBV", new Date());
			fachada.cadastrarFornecedor(f);

			Produto p = new Produto(1, "biscoito", "biscoito treloso, sabor chocolate", f, 100, "alimentos");
			fachada.cadastrarProduto(p);
			Produto p1 = new Produto(2, "notebook", "notebook lenovo", f, 250, "eletrônicos");
			fachada.cadastrarProduto(p1);
			Produto p2 = new Produto(3, "IPad", "IPad Pro 2ª geração", f, 300, "eletrônicos");
			fachada.cadastrarProduto(p2);
			Produto p3 = new Produto(4, "IPhone", "IPhone X 64GB", f, 307, "celulares");
			fachada.cadastrarProduto(p3);
			Produto p4 = new Produto(5, "Sofá", "Sofá lindo e macio", f, 100, "Móveis");
			fachada.cadastrarProduto(p4);
			Produto p5 = new Produto(6, "Cama", "Cama box, maravilhosa!", f, 80, "Móveis");
			fachada.cadastrarProduto(p5);
			Produto p6 = new Produto(7, "Mesa", "Mesa de vidro, muito chique", f, 70, "Móveis");
			fachada.cadastrarProduto(p6);
			Produto p7 = new Produto(8, "Smartphone", "Galaxy S10", f, 90, "celulares");
			fachada.cadastrarProduto(p7);
			Produto p8 = new Produto(9, "computador", "Notebook ACER", f, 7, "eletrônicos");
			fachada.cadastrarProduto(p8);
			Produto p9 = new Produto(10, "Xiaomi", "Xiaomi Redmi Note 7", f, 1000, "celulares");
			fachada.cadastrarProduto(p9);
			
			fachada.addCarrinho(Carrinho.getInstancia());
			
			Item i = new Item(fachada.tamanho(), 4, p);
			fachada.addItem(i);
			Item i1 = new Item(fachada.tamanho(), 54, p1);
			Item i2 = new Item(fachada.tamanho(), 76, p2);
			fachada.addItem(i2);
			Item i3 = new Item(fachada.tamanho(), 80, p3);
			fachada.addItem(i3);
			Item i4 = new Item(fachada.tamanho(), 90, p4);
			fachada.addItem(i4);
			Item i5 = new Item(fachada.tamanho(), 50, p5);
			Item i6 = new Item(fachada.tamanho(), 20, p6);

			
			
			
			
			fachada.setCliente(c);
			fachada.setDataPedido(new Date());
			// carrinho.setDataPedido(new Date());
			// carrinho.setCliente(c);
			// fachada.addCarrinho(carrinho);
			for (Item item : fachada.listarItens()) {
				fachada.decrementarProduto(item);
			}
			fachada.esvaziarCarrinho();

		} catch (CpfException e) {
			System.out.println(e.getMessage());
		} catch (CnpjException e) {
			System.out.println(e.getMessage());
		} catch (ExisteException e) {
			System.out.println(e.getMessage());
		} catch (NenhumException e) {
			System.out.println(e.getMessage());
		} catch (QuantidadeException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
}
