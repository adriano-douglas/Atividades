package Grafica;

public class EmpregadoTerceirizado extends Pessoa {
	
	private Double salario;
	private String ocupacao;
	
	public EmpregadoTerceirizado(String iD, String cpf, String nome, String sexo, String email, Double salario,
			String ocupacao) {
		super(iD, cpf, nome, sexo, email);
		this.salario = salario;
		this.ocupacao = ocupacao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

}
