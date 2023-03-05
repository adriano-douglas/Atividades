package Aula03HerancaAdriano;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Principal {
	
	static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void mostrarDadosAluno(Aluno aluno) {
		System.out.println("--------------- DADOS DOS ALUNOS ---------------\n");
		System.out.println("Nome: " + aluno.getNome());
		System.out.println("CPF: " + aluno.getCpf());
		System.out.println("Data de Nascimento: " + formato.format(aluno.getDataNascimento()));
		System.out.println("Matrícula: " + aluno.getMatricula());
		System.out.println("Valor das cópias: R$" + aluno.tirarCopias(1000));
	}
	
	public static void mostrarDadosProfessor(Professor professor) {
		System.out.println("\n--------------- DADOS DOS PROFESSORES ---------------\n");
		System.out.println("Nome: " + professor.getNome());
		System.out.println("CPF: " + professor.getCpf());
		System.out.println("Data de Nascimento: " + formato.format(professor.getDataNascimento()));
		System.out.println("Salário: R$" + professor.getSalario());
		System.out.print("Disciplinas: ");
		for(String d : professor.getDisciplinas()) {
			System.out.print(d + "; ");
		}
		System.out.println("\nValor das cópias: R$" + professor.tirarCopias(1000));
	}
	
	public static void mostrarDadosFuncionario(Funcionario funcionario) {
		System.out.println("\n--------------- DADOS DOS FUNCIONÁRIOS ---------------\n");
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("CPF: " + funcionario.getCpf());
		System.out.println("Data de Nascimento: " + formato.format(funcionario.getDataNascimento()));
		System.out.println("Salário: R$" + funcionario.getSalario());
		System.out.println("Data de Admissão: " + formato.format(funcionario.getDataAdmissao()));
		System.out.println("Cargo: " + funcionario.getCargo());
		System.out.println("Valor das cópias: R$" + funcionario.tirarCopias(1000));
	}

	public static void main(String[] args) throws ParseException {
		
		ArrayList<String> disciplinas = new ArrayList<String>();
		disciplinas.add("Português");
		disciplinas.add("Inglês");
		
		Aluno aluno = new Aluno("Adriano", "123.456.789-00", formato.parse("17/03/2001"), "123-4");
		Professor professor = new Professor("Pedro", "098.765.432-11", formato.parse("06/07/1999"), 4000.0, disciplinas);
		Funcionario funcionario = new Funcionario("Lucas", "789.012.345-66", formato.parse("23/10/1998"), 1900.0, formato.parse("17/06/2022"), "Assistente administrativo");
		
		mostrarDadosAluno(aluno);
		mostrarDadosProfessor(professor);
		mostrarDadosFuncionario(funcionario);
		
	}

}
