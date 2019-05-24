package controlador;

import java.util.List;

import repositorio.Carrinho;

public interface IControladorCarrinho {

	public List<Carrinho> listarCarrinhos();
	public void addCarrinho(Carrinho car);
	
}
