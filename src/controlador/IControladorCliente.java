package controlador;

import java.util.List;

import excecoes.CpfException;
import excecoes.LoginException;
import excecoes.NenhumException;
import model.Cliente;

public interface IControladorCliente {

	public Cliente login(String login, String senha) throws LoginException;
	public void cadastrarCliente(Cliente c) throws CpfException;
	public boolean existeCliente(String cpf);
	public Cliente consultaCliente(String cpf) throws CpfException;
	public void removerCliente(String cpf) throws CpfException;
	public List<Cliente> listarCliente() throws NenhumException;
	public List<Cliente> listarCliente(String endereco) throws NenhumException;
	
	
}
