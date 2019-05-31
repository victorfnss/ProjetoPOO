package controlador;

import java.text.ParseException;
import java.util.List;

import excecoes.CnpjException;
import excecoes.NenhumException;
import model.Fornecedor;

public interface IControladorFornecedor {

	public void cadastrarFornecedor(Fornecedor f) throws CnpjException, ParseException;
	public boolean existeFornecedor(String cnpj) throws CnpjException;
	public Fornecedor consultarFornecedor (String cnpj) throws NenhumException;
	public void removerFornecedor(String cpf) throws NenhumException;
	public List<Fornecedor> listarFornecedor() throws NenhumException;
	
}
