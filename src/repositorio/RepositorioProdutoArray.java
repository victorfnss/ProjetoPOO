package repositorio;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Produto;

public class RepositorioProdutoArray implements IRepositorioProduto {

	private List<Produto> listaProduto;
	
	private static RepositorioProdutoArray instancia;
	
	public static RepositorioProdutoArray getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioProdutoArray();
		}
		return instancia;
	}
	
	private RepositorioProdutoArray() {
		listaProduto = new ArrayList<>();
	}
	
	@Override
	public void cadastrarProduto(Produto p) {
		listaProduto.add(p);
	}

	@Override
	public void removerProduto(Produto p) {
		listaProduto.remove(p);		
	}
	
	@Override
	public boolean existeProduto(Produto p) {
		for (Produto produto : listaProduto) {
			if (produto.getNome().equals(p.getNome())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void incrementarProduto(Produto p) {
		for (Produto produto : listaProduto) {
			if (existeProduto(p)) {
				produto.setQuantidade(produto.getQuantidade() + p.getQuantidade());
			}
		}
	}
	
	@Override
	public void decrementarProduto(Item i) {
		for (Produto p : listaProduto) {
			if (p.equals(i.getProduto())){
				p.setQuantidade(p.getQuantidade() - i.getQuantidade());
			}
		}
	}
	
	@Override
	public Produto consultarProduto(String nome) {
		Produto consulta = null;
		
		for(Produto p : listaProduto) {
			if (p.getNome().equals(nome)) {
				consulta = p;
			}
		}
		return consulta;
	}

	@Override
	public List<Produto> listarProdutos() {
	
		return listaProduto;
	}
	
	@Override
	public List<Produto> listarProdutos(String categoria) {
		List<Produto> lista = null;
		int aux = 0;
		
		for (Produto p : listaProduto) {
			if (p.getCategoria().equals(categoria)){
				aux++;
			}
		}
		if (aux != 0) {
			lista = new ArrayList<>();
			for (Produto p : listaProduto) {
				if (p.getCategoria().equals(categoria)) {
					lista.add(p);
				}
			}
		}
		return lista;
	}

	

}
