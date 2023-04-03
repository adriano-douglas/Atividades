package Grafica;

import java.util.ArrayList;

public abstract class Pessoa {
	
	private String ID;
	private String cpf;
	private String nome;
	private String sexo;
	private String email;
	private ArrayList<String> telefones;
	
	public Pessoa(String iD, String cpf, String nome, String sexo, String email) {
		super();
		this.ID = iD;
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.telefones = new ArrayList<>();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<String> getTelefones() {
		return telefones;
	}
	
	public void adicionarTelefone(String telefone) {
		this.getTelefones().add(telefone);
	}
	
}
