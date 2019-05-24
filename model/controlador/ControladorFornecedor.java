package controlador;

import java.util.List;

import excecoes.CnpjException;
import excecoes.NenhumException;
import model.entities.Fornecedor;
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
	public void cadastrarFornecedor(Fornecedor f) throws CnpjException {
		if (repositorioFornecedor.existeFornecedor(f.getCnpj())) {
			throw new CnpjException("Cnpj já cadastrado");
		}
		repositorioFornecedor.cadastrarFornecedor(f);
	}
	
	@Override
	public boolean existeFornecedor(String cnpj) {
		if (repositorioFornecedor.existeFornecedor(cnpj)) {
			return true;
		}
		return false;
	}

	@Override
	public Fornecedor consultarFornecedor(String nomeFantasia) throws NenhumException {
		if (!repositorioFornecedor.existeFornecedor(nomeFantasia)) {
			throw new NenhumException("Usuário não encontrado!");
		}
		return repositorioFornecedor.consultaFornecedor(nomeFantasia);
	}
	

	@Override
	public void removerFornecedor(String cnpj) throws NenhumException {
		if (!repositorioFornecedor.existeFornecedor(cnpj)) {
			throw new NenhumException("Usuário não encontrado!");
		}
		repositorioFornecedor.removerFornecedor(cnpj);
	}

	@Override
	public List<Fornecedor> listarFornecedor() throws CnpjException {
		if (repositorioFornecedor.listarFornecedor() == null) {
			throw new CnpjException("Cnpj não encontrado, cadastrar novo fornecedor");
		}
		
		return repositorioFornecedor.listarFornecedor();
	}
}