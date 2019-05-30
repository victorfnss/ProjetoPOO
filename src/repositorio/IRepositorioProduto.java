package repositorio;

import java.util.List;

import model.Item;
import model.Produto;

public interface IRepositorioProduto {

	public void cadastrarProduto(Produto p);
	public void removerProduto(Produto p);
	public boolean existeProduto(Produto p);
	public void incrementarProduto(Produto p);
	public void decrementarProduto(Item i);
	public Produto consultarProduto(String nome);
	public List<Produto> listarProdutos();
	public List<Produto> listarProdutos(String categoria);
}
