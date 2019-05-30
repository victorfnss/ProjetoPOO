package controlador;

import java.util.List;

import excecoes.NenhumException;
import repositorio.Carrinho;
import repositorio.IRepositorioCarrinho;
import repositorio.RepositorioCarrinhoArray;

public class ControladorCarrinho implements IControladorCarrinho {

	private IRepositorioCarrinho repositorioCarrinho;
	private static ControladorCarrinho instancia;
	
	protected static ControladorCarrinho getInstancia() {
		if (instancia == null) {
			instancia = new ControladorCarrinho();
		}
		return instancia;
	}
	
	
	
	private ControladorCarrinho() {
		repositorioCarrinho = RepositorioCarrinhoArray.getInstancia();
	}
	
	@Override
	public List<Carrinho> listarCarrinhos() throws NenhumException {
		if (repositorioCarrinho.listarCarrinhos().isEmpty()) {
			throw new NenhumException("Lista vazia");
		}
		return repositorioCarrinho.listarCarrinhos();
	}

	@Override
	public void addCarrinho(Carrinho car) {
		repositorioCarrinho.addCarrinho(car);
	}

}
