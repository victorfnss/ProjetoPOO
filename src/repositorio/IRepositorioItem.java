package repositorio;

import java.util.List;

import model.Item;

public interface IRepositorioItem {
	
	public void addItem(Item item);
	public void removeItem(Item item);
	public Item mostrarItem(int position);
	public boolean existeItem(Item i);
	public List<Item> listarItens();
	public void alterarQuantidade(Item item, int qtd);
	public void incrementarItem(Item i, int qtd);
	public void esvaziarCarrinho();
}
