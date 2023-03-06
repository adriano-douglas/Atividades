package Aula04HerancaAdriano;

public abstract class CaoGato extends Animal {
	
	private String porte;
	private Double peso;

	public CaoGato() {
		super();
	}

	public CaoGato(String nome, Integer idade, String raca, String cor, String sexo, String porte, Double peso) {
		super(nome, idade, raca, cor, sexo);
		this.porte = porte;
		this.peso = peso;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
}
