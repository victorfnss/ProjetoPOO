package repositorio;

import java.util.List;

import model.Fornecedor;

public interface IRepositorioFornecedor {
	
	public void cadastrarFornecedor(Fornecedor f);
	public boolean existeFornecedor(String cnpj);
	public Fornecedor consultaFornecedor(String cnpj);
	public void removerFornecedor(String nomeFantasia);
	public List<Fornecedor> listarFornecedor();
	
}
