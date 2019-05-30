package repositorio;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class RepositorioClienteArray implements IRepositorioCliente {

	private List<Cliente> listaCliente;
	private static RepositorioClienteArray instancia;
	
	
	
	public static RepositorioClienteArray getInstancia() {
		if(instancia == null) {
			instancia = new RepositorioClienteArray();
		}
		return instancia;
	}
	
	private RepositorioClienteArray() {
		listaCliente = new ArrayList<>();
	}

	@Override
	public Cliente login(String login, String senha) {
		for (Cliente c : listaCliente) {
			if (c.getLogin().equals(login) && c.getSenha().equals(senha)) {
				return c;
			}
		}
		return null;
	}
	
	@Override
	public void cadastrarCliente(Cliente c) {
		listaCliente.add(c);
	}

	@Override
	public boolean existeCliente(String cpf) {
		for (Cliente c : listaCliente) {
			if(c.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Cliente consultaCliente(String cpf) {
		Cliente consulta = null;
		for (Cliente c : listaCliente) {
			if (c.getCpf().equals(cpf)) {
				consulta = c;
			}
		}
		return consulta;
	}

	@Override
	public void removerCliente(String login) {
		for (Cliente c : listaCliente) {
			if (c.getLogin().equals(login)) {
				listaCliente.remove(c);
				
			}
		}
		
	}

	@Override
	public List<Cliente> listarCliente() {
		return listaCliente;
	}

	@Override
	public List<Cliente> listarCliente(String endereco) {
		List<Cliente> lista = null;
		int aux = 0;
		for (Cliente c : listaCliente) {
			if (c.getEndereco().equals(endereco)) {
				aux++;
			}
		}
		if (aux != 0) {
			lista = new ArrayList<>();
			for (Cliente c : listaCliente) {
				if (c.getEndereco().equals(endereco)) {
					lista.add(c);
				}
			}
		}
		return lista;
	}

}
