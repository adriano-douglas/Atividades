package Grafica;

public class Produto {
	
	private String ID;
	private String tipo;
	private Double preco;
	
	public Produto(String ID, String tipo, Double preco) {
		super();
		this.ID = ID;
		this.tipo = tipo;
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
