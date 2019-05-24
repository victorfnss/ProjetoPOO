package repositorio;

import java.util.List;

import model.entities.Produto;

public interface IRepositorioProduto {

	public void cadastrarProduto(Produto p);
	public void removerProduto(Produto p);
	public boolean existeProduto(String nome);
	public void incrementar(Produto p);
	public Produto consultarProduto(String nome);
	public List<Produto> listarProdutos();
	public List<Produto> listarProdutos(String categoria);
}
