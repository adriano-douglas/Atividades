package Trabalho_Etapa3_POO_AdrianoRosa.models;

public class Funcionario extends Pessoa {
	
	private Double salario;
	private String cargo;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(Integer id, String nome, String cpf, String endereço, Double salario, String cargo) {
		super(id, nome, cpf, endereço);
		this.salario = salario;
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
