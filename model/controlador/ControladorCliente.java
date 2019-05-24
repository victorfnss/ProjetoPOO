package controlador;

import java.util.List;

import excecoes.CpfException;
import excecoes.LoginException;
import excecoes.NenhumException;
import model.entities.Cliente;
import repositorio.IRepositorioCliente;
import repositorio.RepositorioClienteArray;

public class ControladorCliente implements IControladorCliente {

	private IRepositorioCliente repositorioCliente;
	private static ControladorCliente instancia;
	
	protected static ControladorCliente getInstancia() {
		if (instancia == null) {
			instancia = new ControladorCliente();
		}
		return instancia;
	}
	
	private ControladorCliente() {
		repositorioCliente = RepositorioClienteArray.getInstancia();
	}
	
	@Override
	public Cliente login(String login, String senha) throws LoginException{
		if (repositorioCliente.login(login, senha) == null) {
			throw new LoginException("Usuário ou senha inválidos!");
		}
		return repositorioCliente.login(login, senha);
		
	}
	
	@Override
	public void cadastrarCliente(Cliente c) throws CpfException {
		if (repositorioCliente.existeCliente(c.getCpf())) {
			throw new CpfException("Cpf já cadastrado!");
		} else {
			repositorioCliente.cadastrarCliente(c);
		}
	}


	@Override
	public boolean existeCliente(String cpf) {
		if (repositorioCliente.existeCliente(cpf)) {
			return true;
		}
		return false;
	}
	
	@Override
	public Cliente consultaCliente(String cpf) throws CpfException {
		if (!repositorioCliente.existeCliente(cpf)) {
			throw new CpfException("Usuário não encontrado!");
		}
		return repositorioCliente.consultaCliente(cpf);
	}

	@Override
	public void removerCliente(String login) throws NenhumException {
		for (Cliente c : repositorioCliente.listarCliente()) {
			if (c.getLogin().equals(login)) {
				repositorioCliente.removerCliente(login);
			}
		}
		throw new NenhumException("Usuário não encontrado");
	}

	@Override
	public List<Cliente> listarCliente() throws NenhumException {
		if (repositorioCliente.listarCliente() == null) {
			throw new NenhumException("Nenhum usuário encontrado");
		}
		return repositorioCliente.listarCliente();
		
	}

	@Override
	public List<Cliente> listarCliente(String endereco) throws NenhumException {
		if (repositorioCliente.listarCliente(endereco) == null) {
			throw new NenhumException("Nenhum usuário encontrado");
		}
		return repositorioCliente.listarCliente(endereco);
	}

}
