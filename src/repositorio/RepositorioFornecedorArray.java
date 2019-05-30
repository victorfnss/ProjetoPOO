package repositorio;

import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;

public class RepositorioFornecedorArray implements IRepositorioFornecedor{

	private List<Fornecedor> listaFornecedor;
	
	private static RepositorioFornecedorArray instancia;
	
	public static RepositorioFornecedorArray getInstancia() {
		if(instancia == null) {
			instancia = new RepositorioFornecedorArray();
		}
		return instancia;
	}
	
	private RepositorioFornecedorArray() {
		listaFornecedor = new ArrayList<>();
	}
	
	@Override
	public void cadastrarFornecedor(Fornecedor f) {
		listaFornecedor.add(f);
	}
	
	@Override
	public boolean existeFornecedor(String cnpj) {
		for (Fornecedor f : listaFornecedor) {
			if (f.getCnpj().equals(cnpj)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Fornecedor consultaFornecedor(String nomeFantasia) {
		Fornecedor consulta = null;
		
		for (Fornecedor f : listaFornecedor) {
			if (f.getNomeFantasia().equals(nomeFantasia)) {
				consulta = f;
			}
		}
		return consulta;
	}

	@Override
	public void removerFornecedor(String cnpj) {
		for (Fornecedor f : listaFornecedor) {
			if (f.getCnpj().equals(cnpj)) {
				listaFornecedor.remove(f);
			}
		}
	}

	@Override
	public List<Fornecedor> listarFornecedor() {
		return listaFornecedor;
	}

	
}
