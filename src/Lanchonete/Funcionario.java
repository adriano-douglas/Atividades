package Lanchonete;

import java.util.ArrayList;

public class Funcionario extends Pessoa {

	private Double salario;

	public Funcionario(String codigo, String nome, String cpf, String endereco, ArrayList<String> telefones,
			Double salario) {
		super(codigo, nome, cpf, endereco, telefones);
		this.salario = salario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
