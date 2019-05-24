package controlador;

import java.util.List;

import excecoes.ExisteException;
import excecoes.NenhumException;
import model.entities.Produto;
import repositorio.IRepositorioProduto;
import repositorio.RepositorioProdutoArray;

public class ControladorProduto implements IControladorProduto {

	private IRepositorioProduto repositorioProduto;
	private static ControladorProduto instancia;
	
	protected static ControladorProduto getInstancia() {
		if (instancia == null) {
			instancia = new ControladorProduto();
		}
		return instancia;
	}
	
	private ControladorProduto() {
		repositorioProduto = RepositorioProdutoArray.getInstancia();
	}
	
	@Override
	public void cadastrarProduto(Produto p) throws ExisteException {
		if (repositorioProduto.existeProduto(p.getNome())) {
			incrementar(p);
			throw new ExisteException("Produto previamente cadastrado, quantidade incrementada");
		} else {
			repositorioProduto.cadastrarProduto(p);
		}
	}
	
	@Override
	public void incrementar(Produto p) {
		repositorioProduto.incrementar(p);
	}

	@Override
	public void removerProduto(String categoria, String nome) {
		for (Produto p : repositorioProduto.listarProdutos(categoria)) {
			if (p.getNome().equals(nome)) {
				repositorioProduto.removerProduto(p);
			}
		}
	}
	
	@Override
	public boolean existeProduto(String nome) {
		if (repositorioProduto.existeProduto(nome)) {
			return true;
		}
		return false;
	}

	@Override
	public Produto consultarProduto(String nome) throws NenhumException {
		if (repositorioProduto.consultarProduto(nome) == null) {
			throw new NenhumException("Produto não encontrado!");
		}
		return repositorioProduto.consultarProduto(nome);
		
	}

	@Override
	public List<Produto> listarProdutos() {
		
		return repositorioProduto.listarProdutos();
	}

	@Override
	public List<Produto> listarProdutos(String categoria) throws NenhumException {
		if (repositorioProduto.listarProdutos(categoria) == null) {
			throw new NenhumException("Categoria não encontrada");
		}
		return repositorioProduto.listarProdutos(categoria);
	}

	

	

}
