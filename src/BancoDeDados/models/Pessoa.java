package BancoDeDados.models;

import java.util.Date;

public class Pessoa {

	private String cpf;
	private String nome;
	private String endereço;
	private Date dataNascimento;

	public Pessoa(String cpf, String nome, String endereço, Date dataNascimento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereço = endereço;
		this.dataNascimento = dataNascimento;
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

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
