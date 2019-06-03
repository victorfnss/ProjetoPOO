package controlador;

import java.util.Date;
import java.util.List;

import excecoes.ExisteException;
import excecoes.NenhumException;
import excecoes.QuantidadeException;
import model.Cliente;
import model.Item;

public interface IControladorItem {
	public void addItem(Item item) throws ExisteException, QuantidadeException;
	public void removeItem(Item item);
	public Item mostrarItem(int position) throws NenhumException;
	public boolean existeItem(Item i) throws ExisteException;
	public List<Item> listarItens() throws NenhumException;
	public void alterarQuantidade(Item i, int qtd) throws QuantidadeException;
	public void incrementarItem(Item i, int qtd) throws QuantidadeException;
	public int tamanho();
	void setCliente(Cliente cliente);
	void setDataPedido(Date dataPedido);
	public void esvaziarCarrinho();

}
