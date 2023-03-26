package Lanchonete;

public class Molho {
	
	private String ID;
	private String nome;
	private Double valor;
	
	public Molho(String ID, String nome, Double valor) {
		super();
		this.setID(ID);
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
