package repositorio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Cliente;
import model.Item;

public class Carrinho implements IRepositorioItem {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
	
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
	
	

	public Cliente getCliente() {
		return cliente;
	}
	@Override
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	
	@Override
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setListaItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}
	@Override
	public void addItem (Item item) {
		listaItem.add(item);
	}
	
	@Override
	public void removeItem (Item item) {	
		listaItem.remove(item);
	}
	
	@Override
	public Item mostrarItem(int position) {
		for (Item i : listaItem) {
			if (i.getCodigo() == position) {
				return i;
			}
		}
		return null;
	}
	
	@Override
	public boolean existeItem(Item i) {
		for (Item item : listaItem) {
			if (item.getProduto().equals(i.getProduto())) {
				return true;
			}
		}
		return false;
	}
	@Override
	public List<Item> listarItens() {
		return listaItem;
	}
	@Override
	public void alterarQuantidade(Item item, int qtd) {
		item.setQuantidade(qtd);
	}
	@Override
	public void incrementarItem(Item i, int qtd) {
		for (Item item : listaItem) {
			if (item.getProduto().equals(i.getProduto())) {
				item.setQuantidade(item.getQuantidade() + i.getQuantidade());
			}
		}
		
	}
	
	public int tamanho() {
		
		return listaItem.size() + 1;
	}
	@Override
	public void esvaziarCarrinho() {
		instancia = new Carrinho();	
		listaItem.clear();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(cliente +"\n");
		for (Item i : listaItem) {
			sb.append(i + "\n");
		}
		sb.append(sdf.format(dataPedido));
		return sb.toString();
	}
	
	
	
}
