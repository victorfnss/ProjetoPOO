package repositorio;

import java.util.List;

public interface IRepositorioCarrinho {

	public List<Carrinho> listarCarrinhos();
	public void addCarrinho(Carrinho car);
	
	
}
