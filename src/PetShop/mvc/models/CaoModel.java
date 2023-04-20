package PetShop.mvc.models;

public class CaoModel extends Animal {

	private String porte;
	private Double peso;
	
	public CaoModel() {
		super();
	}

	public CaoModel(Integer ID, String nome, Integer idade, String raca, String cor, String sexo, ProprietarioModel proprietario,
			String porte, Double peso) {
		super(ID, nome, idade, raca, cor, sexo, proprietario);
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
