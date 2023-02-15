package Atividade1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Aluno aluno1 = new Aluno("Adriano", 123, formato.parse("01/02/2001"), "adriano@");
		Aluno aluno2 = new Aluno("Maria", 345, formato.parse("25/07/2002"), "maria@");
		Aluno aluno3 = new Aluno("Pedro", 678, formato.parse("22/01/2001"), "pedro@");
		Aluno aluno4 = new Aluno("Ana", 101, formato.parse("21/04/2000"), "ana@");
		
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		
		lista.add(aluno1);
		lista.add(aluno2);
		lista.add(aluno3);
		lista.add(aluno4);
		
		Integer cont = 0;
		Aluno alunoMaisVelho = new Aluno();
		
		for(Aluno a: lista) {
			for(Aluno a2: lista) {
				if(a.getDataNascimento().compareTo(a2.getDataNascimento()) <= 0) {
					cont++;
				}
			}
			if(cont == lista.size()) {
				alunoMaisVelho = a;
				break;
			}
			cont = 0;
		}
		
		System.out.println("Todos os alunos:\n");
		for(Aluno a: lista) {
			a.imprimirDados();
		}
		
		System.out.println("Aluno mais velho:\n");
		alunoMaisVelho.imprimirDados();
		
		System.out.println("Idade: " + alunoMaisVelho.idade(alunoMaisVelho));

	}

}
