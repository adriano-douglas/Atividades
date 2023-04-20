package PetShop.mvc.models;

public abstract class Animal {
	
	private Integer ID;
	private String nome;
	private Integer idade;
	private String raca;
	private String cor;
	private String sexo;
	private ProprietarioModel proprietario;
	
	public Animal() {
		super();
	}

	public Animal(Integer ID, String nome, Integer idade, String raca, String cor, String sexo, ProprietarioModel proprietario) {
		super();
		this.ID = ID;
		this.nome = nome;
		this.idade = idade;
		this.raca = raca;
		this.cor = cor;
		this.sexo = sexo;
		this.proprietario = proprietario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public ProprietarioModel getProprietario() {
		return proprietario;
	}

	public void setProprietario(ProprietarioModel proprietario) {
		this.proprietario = proprietario;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

}
