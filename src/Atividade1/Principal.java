package Atividade1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Aluno aluno1 = new Aluno("Adriano", 123, formato.parse("17/03/2001"), "adriano@");
		Aluno aluno2 = new Aluno("Maria", 345, formato.parse("04/07/2000"), "maria@");
		Aluno aluno3 = new Aluno("Pedro", 678, formato.parse("10/03/1995"), "pedro@");
		Aluno aluno4 = new Aluno("Ana", 101, formato.parse("29/05/2006"), "ana@");
		
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		
		lista.add(aluno1);
		lista.add(aluno2);
		lista.add(aluno3);
		lista.add(aluno4);
		
		Aluno alunoMaisVelho = new Aluno();
		alunoMaisVelho = lista.get(0);
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getDataNascimento().compareTo(alunoMaisVelho.getDataNascimento()) < 0) {
				alunoMaisVelho = lista.get(i);
			}
		}
		
		System.out.println("Todos os alunos:\n");
		for(Aluno aluno: lista) {
			aluno.imprimirDados();
		}
		System.out.println("------------------------------------\n");
		
		System.out.println("Aluno mais velho:\n");
		alunoMaisVelho.imprimirDados();
		
		System.out.println("Idade: " + alunoMaisVelho.idade(alunoMaisVelho));

	}

}
