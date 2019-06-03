package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fornecedor extends Pessoa {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String cnpj;
	private String nomeFantasia;
	private Date dataDeAbertura;
	
	public Fornecedor(Integer codigo, String nome, String endereco, String telefone, String cnpj, String nomeFantasia,
			Date dataDeAbertura) {
		super(codigo, nome, endereco, telefone);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.dataDeAbertura = dataDeAbertura;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Date getDataDeAbertura() {
		return dataDeAbertura;
	}

	@Override
	public String toString() {
		return "#"
				+super.getCodigo()
				+" "
				+nomeFantasia
				+", "
				+cnpj
				+"\n"
				+super.getNome()
				+", data de abertura: "
				+sdf.format(dataDeAbertura)
				+"\n"
				+super.getEndereco()
				+", "
				+super.getTelefone();
	}
	
	
	
}