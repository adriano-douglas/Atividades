package Aula05Adriano;

import java.util.Date;
import java.util.List;

								// Herança da classe Pessoa

public abstract class ClienteFuncionario extends Pessoa{

	private String cpf;
	private Date dataNascimento;
	
	// Sobrecarga nos construtores
	
	public ClienteFuncionario() {
		super();
	}
	
	public ClienteFuncionario(String nome, String email, String endereco, List<String> telefones, String cpf,
			Date dataNascimento) {
		super(nome, email, endereco, telefones);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	// Encapsulamento nos GETs e SETs

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public double calcularDesconto() {
		return (1 - 0.2);
	}

}
