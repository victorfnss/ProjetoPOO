package model.entities;

public class Produto {

	private Integer codigo;
	private String nome;
	private String descricao;
	private Fornecedor fornecedor;
	private Integer quantidade;
	private String categoria;
	
	public Produto(Integer codigo, String nome, String descricao, Fornecedor fornecedor, Integer quantidade, String categoria) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.fornecedor = fornecedor;
		this.quantidade = quantidade;
		this.categoria = categoria;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return 	nome
				+"\n"
				+"Quantidade em estoque: "
				+quantidade
				+"\nCategoria: "
				+categoria
				+"\nFornecedor: "
				+fornecedor.getNome();
				
	}
	
	
}
