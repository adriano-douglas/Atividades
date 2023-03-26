package Lanchonete;

import java.util.ArrayList;

public abstract class Pessoa {
	
	private String codigo;
	private String nome;
	private String cpf;
	private String endereco;
	private ArrayList<String> telefones;
	
	public Pessoa(String codigo, String nome, String cpf, String endereco, ArrayList<String> telefones) {
		super();
		this.setCodigo(codigo);
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefones = telefones;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<String> telefones) {
		this.telefones = telefones;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
