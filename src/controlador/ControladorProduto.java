package controlador;

import java.util.List;

import excecoes.ExisteException;
import excecoes.NenhumException;
import excecoes.QuantidadeException;
import model.Item;
import model.Produto;
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
		if (repositorioProduto.existeProduto(p)) {
			incrementarProduto(p);
			throw new ExisteException("Produto previamente cadastrado, quantidade incrementada");
		} else {
			repositorioProduto.cadastrarProduto(p);
		}
	}
	
	

	@Override
	public void removerProduto(String categoria, String nome) throws NenhumException {
		for (Produto p : repositorioProduto.listarProdutos(categoria)) {
			if (!repositorioProduto.existeProduto(p)) {
				throw new NenhumException("Produto não encontrado");
			}
			else {
				repositorioProduto.removerProduto(p);
			}
		}
	}
	
	@Override
	public boolean existeProduto(Produto p) {
		if (repositorioProduto.existeProduto(p)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void incrementarProduto(Produto p) {
		repositorioProduto.incrementarProduto(p);
	}
	
	@Override
	public void decrementarProduto(Item i) throws QuantidadeException{
		for (Produto p : repositorioProduto.listarProdutos()) {
			if (p.equals(i.getProduto())) {
				if (i.getQuantidade() > p.getQuantidade()) {
					throw new QuantidadeException("Quantidade selecionada maior que a disponível");
				}
				else {
					repositorioProduto.decrementarProduto(i);
				}
			}
		}
	}

	@Override
	public Produto consultarProduto(String nome) throws NenhumException {
		if (repositorioProduto.consultarProduto(nome) == null) {
			throw new NenhumException("Produto não encontrado!");
		}
		return repositorioProduto.consultarProduto(nome);
		
	}

	@Override
	public List<Produto> listarProdutos() throws NenhumException {
		if (repositorioProduto.listarProdutos().isEmpty()) {
			throw new NenhumException("Não há produtos cadastrados");
		}
		return repositorioProduto.listarProdutos();
	}

	@Override
	public List<Produto> listarProdutos(String categoria) throws NenhumException {
		if (repositorioProduto.listarProdutos(categoria).isEmpty()) {
			throw new NenhumException("Não há produtos cadastrados");
		}
		return repositorioProduto.listarProdutos(categoria);
	}
	

	

	

	

}
