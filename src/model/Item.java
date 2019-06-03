package model;

public class Item {

	private Integer codigo;
	private Integer quantidade;
	private Produto produto;
	
	public Item(Integer codigo, Integer quantidade, Produto produto) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Override
	public String toString() {
		return "item "
				+codigo
				+"\n"
				+produto.getNome()
				+", "
				+produto.getDescricao()
				+"\nQuantidade selecionada: "
				+quantidade;
	}
}
