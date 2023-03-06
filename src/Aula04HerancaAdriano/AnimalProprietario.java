package Aula04HerancaAdriano;

public class AnimalProprietario {
	
	private String nomeAnimal;
	private String cpfProprietario;

	public AnimalProprietario() {
		super();
	}

	public AnimalProprietario(String nomeAnimal, String cpfProprietario) {
		super();
		this.nomeAnimal = nomeAnimal;
		this.cpfProprietario = cpfProprietario;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getCpfProprietario() {
		return cpfProprietario;
	}

	public void setCpfProprietario(String cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}

}
