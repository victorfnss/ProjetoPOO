package repositorio;

import java.util.List;

import model.Cliente;

public interface IRepositorioCliente {
	
	public Cliente login(String login, String senha);
	public void cadastrarCliente(Cliente c);
	public boolean existeCliente(String cpf);
	public Cliente consultaCliente(String cpf);
	public void removerCliente(String login);
	public List<Cliente> listarCliente();
	public List<Cliente> listarCliente(String endereco);
	
}
