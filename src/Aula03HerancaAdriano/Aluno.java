package Aula03HerancaAdriano;

import java.util.Date;

public class Aluno extends Pessoa {
	
	private String matricula;
	
	public Aluno() {
		super();
	}

	public Aluno(String nome, String cpf, Date dataNascimento, String matricula) {
		super(nome, cpf, dataNascimento);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public double tirarCopias(Integer numeroCopias) {
		return numeroCopias * 0.05;
	}
	
}
