package controlador;

import java.util.List;

import excecoes.ExisteException;
import excecoes.NenhumException;
import excecoes.QuantidadeException;
import model.entities.Item;
import model.entities.Produto;

public interface IControladorProduto {
	
	public void cadastrarProduto(Produto p) throws ExisteException;
	public void removerProduto(String categoria, String nome);
	public boolean existeProduto(Produto p);
	public void incrementarProduto(Produto p);
	public void decrementarProduto(Item i) throws QuantidadeException;
	public Produto consultarProduto(String nome) throws NenhumException;
	public List<Produto> listarProdutos();
	public List<Produto> listarProdutos(String categoria) throws NenhumException;
}
