package controlador;

import java.text.ParseException;
import java.util.List;

import excecoes.CnpjException;
import excecoes.CpfException;
import excecoes.ExisteException;
import excecoes.LoginException;
import excecoes.NenhumException;
import excecoes.QuantidadeException;
import model.Cliente;
import model.Fornecedor;
import model.Item;
import model.Produto;
import repositorio.Carrinho;

public class Fachada implements IControladorCliente, IControladorFornecedor, 
IControladorCarrinho, IControladorProduto, IControladorItem  {
	
	private IControladorCliente controladorCliente;
	private IControladorFornecedor controladorFornecedor;
	private IControladorCarrinho controladorCarrinho;
	private IControladorProduto controladorProduto;
	private IControladorItem carrinho;
	private static Fachada instancia;
	
	public static Fachada getInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}
	
	private Fachada() {
		controladorCliente = ControladorCliente.getInstancia();
		controladorFornecedor = ControladorFornecedor.getInstancia();
		controladorCarrinho = ControladorCarrinho.getInstancia();
		controladorProduto = ControladorProduto.getInstancia();
		carrinho = ControladorItem.getInstancia();
	}

	@Override
	public Cliente login(String login, String senha) throws LoginException {
		return controladorCliente.login(login, senha);
	}
	
	@Override
	public void cadastrarCliente(Cliente c) throws CpfException {
		controladorCliente.cadastrarCliente(c);		
	}

	@Override
	public boolean existeCliente(String cpf) {
		if(controladorCliente.existeCliente(cpf)) {
			return true;
		}
		return false;
	}

	@Override
	public Cliente consultaCliente(String cpf) throws CpfException {
		return controladorCliente.consultaCliente(cpf);
	}
	
	@Override
	public void removerCliente(String login) throws CpfException {
		controladorCliente.removerCliente(login);		
	}

	@Override
	public List<Cliente> listarCliente() throws NenhumException {
		return controladorCliente.listarCliente();
	}

	@Override
	public List<Cliente> listarCliente(String endereco) throws NenhumException {
		return controladorCliente.listarCliente(endereco);
	}

	@Override
	public void cadastrarFornecedor(Fornecedor f) throws CnpjException, ParseException, ParseException {
		controladorFornecedor.cadastrarFornecedor(f);		
	}

	@Override
	public boolean existeFornecedor(String cnpj) throws CnpjException {
		if(controladorFornecedor.existeFornecedor(cnpj)) {
			return true;
		}
		return false;
	}
	
	@Override
	public Fornecedor consultarFornecedor(String cnpj) throws NenhumException {
		return controladorFornecedor.consultarFornecedor(cnpj);
	}

	@Override
	public void removerFornecedor(String cnpj) throws NenhumException {
		controladorFornecedor.removerFornecedor(cnpj);
	}
	
	@Override
	public List<Fornecedor> listarFornecedor() throws NenhumException {
		return controladorFornecedor.listarFornecedor();
	}

	@Override
	public List<Carrinho> listarCarrinhos() throws NenhumException {
		return controladorCarrinho.listarCarrinhos();
	}

	@Override
	public void addCarrinho(Carrinho car) {
		controladorCarrinho.addCarrinho(car);
		
	}

	@Override
	public void cadastrarProduto(Produto p) throws ExisteException {
		controladorProduto.cadastrarProduto(p);
	}

	@Override
	public void removerProduto(String categoria, String nome) throws NenhumException {
		controladorProduto.removerProduto(categoria, nome);
		
	}

	@Override
	public boolean existeProduto(String nome) {
		if (controladorProduto.existeProduto(nome)) {
			return true;
		}
		return false;
	}

	@Override
	public void incrementarProduto(Produto p) {
		controladorProduto.incrementarProduto(p);
	}
	
	@Override
	public void decrementarProduto(Item i) throws QuantidadeException {
		controladorProduto.decrementarProduto(i);
	}

	@Override
	public Produto consultarProduto(String nome) throws NenhumException {
		return controladorProduto.consultarProduto(nome);
	}

	@Override
	public List<Produto> listarProdutos() throws NenhumException {
		return controladorProduto.listarProdutos();
	}

	@Override
	public List<Produto> listarProdutos(String categoria) throws NenhumException {
		return controladorProduto.listarProdutos(categoria);
	}

	@Override
	public void addItem(Item item) {
		carrinho.addItem(item);
		
	}

	@Override
	public void removeItem(Item item) {
		carrinho.removeItem(item);
		
	}

	@Override
	public Item mostrarItem(int position) throws NenhumException {
		carrinho.mostrarItem(position);
		return null;
	}

	@Override
	public boolean existeItem(Item i) throws ExisteException {
		return carrinho.existeItem(i);
	}

	@Override
	public List<Item> listarItens() throws NenhumException {
		return carrinho.listarItens();
	}

	@Override
	public void alterarQuantidade(Item i, int qtd) throws QuantidadeException {
		carrinho.alterarQuantidade(i, qtd);
		
	}

	@Override
	public void incrementarItem(Item i, int qtd) throws QuantidadeException {
		carrinho.incrementarItem(i, qtd);
		
	}
	@Override
	public void esvaziarCarrinho() {
		carrinho.esvaziarCarrinho();
	}

}
