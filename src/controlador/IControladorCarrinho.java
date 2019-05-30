package controlador;

import java.util.List;

import excecoes.NenhumException;
import repositorio.Carrinho;

public interface IControladorCarrinho {

	public List<Carrinho> listarCarrinhos() throws NenhumException;
	public void addCarrinho(Carrinho car);
	
}
