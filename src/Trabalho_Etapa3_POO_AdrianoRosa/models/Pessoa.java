package Trabalho_Etapa3_POO_AdrianoRosa.models;

import java.util.ArrayList;

public abstract class Pessoa {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String endereco;
	private ArrayList<String> telefones;
	
	public Pessoa() {
		super();
		this.telefones = new ArrayList<>();
	}

	public Pessoa(Integer id, String nome, String cpf, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefones = new ArrayList<>();
	}

	public Pessoa(Integer id, String nome, String cpf, String endereco, ArrayList<String> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefones = telefones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public void adicionarTelefone(String telefone) {
		this.getTelefones().add(telefone);
	}

	@Override
	public String toString() {
		return id + " - " + nome;
	}

}
