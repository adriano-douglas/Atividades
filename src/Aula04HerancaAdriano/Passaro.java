package Aula04HerancaAdriano;

public class Passaro extends Animal {
	
	private Integer numeroAnilha;

	public Passaro() {
		super();
	}

	public Passaro(String nome, Integer idade, String raca, String cor, String sexo, Integer numeroAnilha) {
		super(nome, idade, raca, cor, sexo);
		this.numeroAnilha = numeroAnilha;
	}

	public Integer getNumeroAnilha() {
		return numeroAnilha;
	}

	public void setNumeroAnilha(Integer numeroAnilha) {
		this.numeroAnilha = numeroAnilha;
	}

}
