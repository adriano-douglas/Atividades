package Lanchonete;

public class Borda {
	
	private String nome;
	private Double valor;
	private Recheio recheio;
	
	public Borda(String nome, Recheio recheio) {
		super();
		this.nome = nome;
		this.valor = 5.0 + recheio.getValor();
		this.recheio = recheio;
	}

	public Borda(String nome) {
		super();
		this.nome = nome;
		this.valor = 5.0;
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

	public Recheio getRecheio() {
		return recheio;
	}

	public void setRecheio(Recheio recheio) {
		this.recheio = recheio;
	}

}
