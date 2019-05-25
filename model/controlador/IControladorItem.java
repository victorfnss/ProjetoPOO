package controlador;

import java.util.List;

import excecoes.ExisteException;
import excecoes.NenhumException;
import excecoes.QuantidadeException;
import model.entities.Item;

public interface IControladorItem {
	public void addItem(Item item);
	public void removeItem(Item item);
	public Item mostrarItem(int position) throws NenhumException;
	public boolean existeItem(Item i) throws ExisteException;
	public List<Item> listarItens() throws NenhumException;
	public void alterarQuantidade(Item i, int qtd) throws QuantidadeException;
	public void incrementarItem(Item i, int qtd) throws QuantidadeException;
	public void esvaziarCarrinho();

}
