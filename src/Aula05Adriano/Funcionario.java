package Aula05Adriano;

import java.util.Date;
import java.util.List;

							// Herança da classe ClienteFuncionario

public class Funcionario extends ClienteFuncionario{
	
	private Date dataAdmissao;
	private String cargo;
	
	// Sobrecarga nos construtores
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String email, String endereco, List<String> telefones, String cpf,
			Date dataNascimento, Date dataAdmissao, String cargo) {
		super(nome, email, endereco, telefones, cpf, dataNascimento);
		this.dataAdmissao = dataAdmissao;
		this.cargo = cargo;
	}
	
	// Encapsulamento nos GETs e SETs

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
