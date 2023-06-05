package Trabalho_Etapa2_POO_AdrianoRosa.models;

public class Borda {
	
	private Integer id;
	private String nome;
	private Double valor;
	private Recheio recheio;
	
	public Borda() {
		super();
	}
	
	public Borda(Integer id, String nome, Double valor, Recheio recheio) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.recheio = recheio;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
