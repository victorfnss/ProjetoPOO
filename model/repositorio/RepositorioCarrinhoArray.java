package repositorio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCarrinhoArray implements IRepositorioCarrinho {

	private List<Carrinho> listaCarrinho;
	private static RepositorioCarrinhoArray instancia;
	
	public static RepositorioCarrinhoArray getInstancia() {
		if(instancia == null) {
			instancia = new RepositorioCarrinhoArray();
		}
		return instancia;
	}
	
	private RepositorioCarrinhoArray() {
		listaCarrinho = new ArrayList<>();
	}
	
	
	@Override
	public List<Carrinho> listarCarrinhos() {
		return listaCarrinho;
	}
	public void addCarrinho(Carrinho car) {
		listaCarrinho.add(car);
	}
	

}
