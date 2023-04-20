package PetShop.mvc.models;

public class PassaroModel extends Animal {
	
	private String numeroAnilha;
	
	public PassaroModel() {
		super();
	}

	public PassaroModel(Integer ID, String nome, Integer idade, String raca, String cor, String sexo, ProprietarioModel proprietario,
			String numeroAnilha) {
		super(ID, nome, idade, raca, cor, sexo, proprietario);
		this.numeroAnilha = numeroAnilha;
	}

	public String getNumeroAnilha() {
		return numeroAnilha;
	}

	public void setNumeroAnilha(String numeroAnilha) {
		this.numeroAnilha = numeroAnilha;
	}

}
