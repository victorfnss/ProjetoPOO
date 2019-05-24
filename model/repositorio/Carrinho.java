package repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entities.Cliente;
import model.entities.Item;

public class Carrinho implements ICarrinho {
	private Cliente cliente;
	private Date dataPedido;
	private List<Item> listaItem;
	private static Carrinho instancia;
	
	public static Carrinho getInstancia() {
		if (instancia == null) {
			instancia = new Carrinho();
		}
		return instancia;
	}
	private Carrinho() {
		listaItem = new ArrayList<>();
	}
	
	public Carrinho(Cliente cliente, Date dataPedido) {
		this.cliente = cliente;
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	
	public List<Item> getListaItem() {
		return listaItem;
	}
	public void setListaItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}
	@Override
	public void addItem (Item item) {
		listaItem.add(item);
	}
	
	@Override
	public void removeItem (Item item, int qtd) {
		if (qtd == 0) {
		listaItem.remove(item);
		}
		else {
			item.setQuantidade(item.getQuantidade() - qtd);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(cliente +"\n");
		for (Item i : listaItem) {
			sb.append(i + "\n");
		}
		sb.append(dataPedido);
		return sb.toString();
	}
	
}
