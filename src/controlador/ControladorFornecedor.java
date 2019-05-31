package controlador;

import java.text.ParseException;
import java.util.List;

import excecoes.CnpjException;
import excecoes.NenhumException;
import model.Fornecedor;
import repositorio.IRepositorioFornecedor;
import repositorio.RepositorioFornecedorArray;

public class ControladorFornecedor implements IControladorFornecedor{

	private IRepositorioFornecedor repositorioFornecedor;
	private static ControladorFornecedor instancia;
	
	protected static ControladorFornecedor getInstancia() {
		if (instancia == null) {
			instancia = new ControladorFornecedor();
		}
		return instancia;
	}
	
	private ControladorFornecedor() {
		repositorioFornecedor = RepositorioFornecedorArray.getInstancia();
	}
	
	
	@Override
	public void cadastrarFornecedor(Fornecedor f) throws CnpjException, ParseException {
		if (repositorioFornecedor.existeFornecedor(f.getCnpj())) {
			throw new CnpjException("Cnpj já cadastrado");
		}
		repositorioFornecedor.cadastrarFornecedor(f);
	}
	
	@Override
	public boolean existeFornecedor(String cnpj) throws CnpjException {
		if (!repositorioFornecedor.existeFornecedor(cnpj)) {
			throw new CnpjException("Cnpj não encontrado, cadastrar novo fornecedor");
		}
		return true;
	}

	@Override
	public Fornecedor consultarFornecedor(String cnpj) throws NenhumException {
		if (!repositorioFornecedor.existeFornecedor(cnpj)) {
			throw new NenhumException("Usuário não encontrado!");
		}
		return repositorioFornecedor.consultaFornecedor(cnpj);
	}
	

	@Override
	public void removerFornecedor(String cnpj) throws NenhumException {
		if (!repositorioFornecedor.existeFornecedor(cnpj)) {
			throw new NenhumException("Usuário não encontrado!");
		}
		repositorioFornecedor.removerFornecedor(cnpj);
	}

	@Override
	public List<Fornecedor> listarFornecedor() throws NenhumException {
		if (repositorioFornecedor.listarFornecedor().isEmpty()) {
			throw new NenhumException("Lista vazia!");
		}
		
		return repositorioFornecedor.listarFornecedor();
	}
}