package controlador;

import java.util.List;

import excecoes.ExisteException;
import excecoes.NenhumException;
import model.entities.Produto;

public interface IControladorProduto {
	
	public void cadastrarProduto(Produto p) throws ExisteException;
	public void removerProduto(String categoria, String nome);
	public boolean existeProduto(String nome);
	public void incrementar(Produto p);
	public Produto consultarProduto(String nome) throws NenhumException;
	public List<Produto> listarProdutos();
	public List<Produto> listarProdutos(String categoria) throws NenhumException;
}
