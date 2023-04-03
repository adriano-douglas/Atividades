package Grafica;

public class Gerente extends Pessoa {
	
	private Double salario;
	private Setor setor;
	
	public Gerente(String iD, String cpf, String nome, String sexo, String email, Double salario, Setor setor) {
		super(iD, cpf, nome, sexo, email);
		this.salario = salario;
		this.setor = setor;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}
