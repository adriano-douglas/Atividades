package Grafica;

public class Empregado extends Pessoa {
	
	private Double salario;
	private String ocupacao;
	private Setor setor;
	
	public Empregado(String iD, String cpf, String nome, String sexo, String email, Double salario, String ocupacao, Setor setor) {
		super(iD, cpf, nome, sexo, email);
		this.salario = salario;
		this.ocupacao = ocupacao;
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

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	
}
