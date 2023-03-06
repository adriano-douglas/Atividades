package Aula04HerancaAdriano;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
	
	public static void mostrarDadosAnimal(Animal animal) {
		System.out.println("Nome: " + animal.getNome());
		System.out.println("Idade: " + animal.getIdade() + " anos");
		System.out.println("Raça: " + animal.getRaca());
		System.out.println("Cor: " + animal.getCor());
		System.out.println("Sexo: " + animal.getSexo());
	}
	
	public static void mostrarDadosCaoGato(CaoGato caoGato) {
		mostrarDadosAnimal(caoGato);
		System.out.println("Porte: " + caoGato.getPorte());
		System.out.println("Peso: " + caoGato.getPeso() + " kg");
		System.out.println();
	}
	
	public static void mostrarDadosPassaro(Passaro passaro) {
		mostrarDadosAnimal(passaro);
		System.out.println("Nº da anilha: " + passaro.getNumeroAnilha());
		System.out.println();
	}
	
	public static void mostrarDadosProprietario(Proprietario proprietario) {
		System.out.println("Nome: " + proprietario.getNome());
		System.out.println("CPF: " + proprietario.getCpf());
		System.out.println("Endereço: " + proprietario.getEndereco());
		System.out.println();
	}
	
	public static void imprimirAnimaisDono(List<Animal> animais, List<Proprietario> proprietarios, List<AnimalProprietario> animaisProprietarios) {
		for(Proprietario p : proprietarios) {
			System.out.println("--------- Proprietário(a) " + p.getNome() + " ---------");
			System.out.println("\nAnimais:\n");
			List<Animal> aux = new ArrayList<Animal>();
			for(AnimalProprietario ap : animaisProprietarios) {
				if(p.getCpf().equals(ap.getCpfProprietario())) {
					for(Animal a : animais) {
						if(ap.getNomeAnimal().equals(a.getNome())) {
							aux.add(a);
							break;
						}
					}
				}
			}
			Collections.sort(aux, (Animal a1, Animal a2) -> a1.getIdade().compareTo(a2.getIdade()));
			for(Animal a : aux) {
				if(a.getClass().getSimpleName().equals("Passaro")) {
					mostrarDadosPassaro((Passaro) a);
				}else {
					mostrarDadosCaoGato((CaoGato) a);
				}
			}
			System.out.println();
		}
	}
	
	public static void imprimirDonoAnimais(List<Animal> animais, List<Proprietario> proprietarios, List<AnimalProprietario> animaisProprietarios) {
		Collections.sort(animais, (Animal a1, Animal a2) -> a1.getIdade().compareTo(a2.getIdade()));
		for(Animal a : animais) {
			System.out.println("--------- Animal " + a.getNome() + " - " + a.getIdade() + " anos ----------");
			System.out.println("\nProprietário(a):\n");
			for(AnimalProprietario ap : animaisProprietarios) {
				if(a.getNome().equals(ap.getNomeAnimal())) {
					for(Proprietario p : proprietarios) {
						if(ap.getCpfProprietario().equals(p.getCpf())) {
							mostrarDadosProprietario(p);
							break;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		List<Animal> animais = new ArrayList<Animal>();
		List<Proprietario> proprietarios = new ArrayList<Proprietario>();
		List<AnimalProprietario> animaisProprietarios = new ArrayList<AnimalProprietario>();

		animais.add(new Cao("Bob", 2, "Vira-lata", "Caramelo", "M", "Médio", 10.0));
		animais.add(new Cao("Theo", 3, "Fila brasileiro", "Tigrado", "M", "Grande", 30.0));
		animais.add(new Gato("Mika", 10, "Persa", "Amarelo", "F", "Grande", 10.0));
		animais.add(new Gato("Conan", 7, "Siamês", "Bege", "M", "Médio", 7.0));
		animais.add(new Passaro("Lulu", 1, "Calopsita", "Azul", "M", 123));
		animais.add(new Passaro("Lila", 2, "Canário Belga", "Vermelho", "F", 456));
		
		proprietarios.add(new Proprietario("Adriano", "123.456.789-00", "Rua A, 98"));
		proprietarios.add(new Proprietario("Lucas", "456.789.012-33", "Rua B, 76"));
		proprietarios.add(new Proprietario("Ana", "789.012.345.66", "Rua C, 54"));
		
		animaisProprietarios.add(new AnimalProprietario("Bob", "123.456.789-00"));
		animaisProprietarios.add(new AnimalProprietario("Theo", "789.012.345.66"));
		animaisProprietarios.add(new AnimalProprietario("Mika", "456.789.012-33"));
		animaisProprietarios.add(new AnimalProprietario("Conan", "123.456.789-00"));
		animaisProprietarios.add(new AnimalProprietario("Lulu", "456.789.012-33"));
		animaisProprietarios.add(new AnimalProprietario("Lila", "789.012.345.66"));
		
		imprimirAnimaisDono(animais, proprietarios, animaisProprietarios);
		imprimirDonoAnimais(animais, proprietarios, animaisProprietarios);
		
	}

}
