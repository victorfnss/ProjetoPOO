package repositorio;

import model.entities.Item;

public interface ICarrinho {
	
	public void addItem(Item item);
	public void removeItem(Item item, int qtd);

}
