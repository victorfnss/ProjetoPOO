package controlador;

import java.util.List;

import excecoes.CnpjException;
import excecoes.NenhumException;
import model.entities.Fornecedor;

public interface IControladorFornecedor {

	public void cadastrarFornecedor(Fornecedor f) throws CnpjException;
	public boolean existeFornecedor(String cnpj) throws CnpjException;
	public Fornecedor consultarFornecedor (String nomeFantasia) throws NenhumException;
	public void removerFornecedor(String cpf) throws NenhumException;
	public List<Fornecedor> listarFornecedor() throws NenhumException;
	
}
