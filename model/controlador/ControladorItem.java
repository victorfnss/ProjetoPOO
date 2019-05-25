package controlador;

import java.util.List;

import excecoes.ExisteException;
import excecoes.NenhumException;
import excecoes.QuantidadeException;
import model.entities.Item;
import repositorio.Carrinho;
import repositorio.IRepositorioItem;

public class ControladorItem implements IControladorItem {

	private IRepositorioItem carrinho;
	private static ControladorItem instancia;
	
	protected static ControladorItem getInstancia() {
		if (instancia == null) {
			instancia = new ControladorItem();
		}
		return instancia;
	}
	
	private ControladorItem() {
		carrinho = Carrinho.getInstancia();
	}
	
	@Override
	public void addItem(Item item) {
		carrinho.addItem(item);
	}

	@Override
	public void removeItem(Item item) {
		carrinho.removeItem(item);
	}

	@Override
	public Item mostrarItem(int position)throws NenhumException {
		if (position > carrinho.listarItens().size()) {
			throw new NenhumException("Digite uma posição válida");
		}
		return null;
	}

	@Override
	public boolean existeItem(Item i) throws ExisteException {
		if (carrinho.existeItem(i)) {
			throw new ExisteException("Item já adicionado ao carrinho, quantidade alterada");
		}
		return false;
	}

	@Override
	public List<Item> listarItens() throws NenhumException {
		if (carrinho.listarItens().isEmpty()) {
		throw new NenhumException("Carrinho vazio!");
	}
		return carrinho.listarItens();

	}

	@Override
	public void alterarQuantidade(Item i, int qtd) throws QuantidadeException {
		if (qtd < 0) {
			throw new QuantidadeException("Digite uma quantidade válida");
		}
		carrinho.alterarQuantidade(i, qtd);
	}

	@Override
	public void incrementarItem(Item i, int qtd) throws QuantidadeException {
		if (qtd <= 0) {
			throw new QuantidadeException("Digite uma quantidade válida");
		}
		carrinho.incrementarItem(i, qtd);
	}
	@Override
	public void esvaziarCarrinho() {
		carrinho.esvaziarCarrinho();
	}
}