package Aula03HerancaAdriano;

import java.util.ArrayList;
import java.util.Date;

public class Professor extends Pessoa{
	
	private Double salario;
	private ArrayList<String> disciplinas;
	
	public Professor() {
		super();
	}
	public Professor(String nome, String cpf, Date dataNascimento, Double salario, ArrayList<String> disciplinas) {
		super(nome, cpf, dataNascimento);
		this.salario = salario;
		this.disciplinas = disciplinas;
	}
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public ArrayList<String> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(ArrayList<String> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
