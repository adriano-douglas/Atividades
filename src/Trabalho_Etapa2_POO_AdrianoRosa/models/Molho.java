package Trabalho_Etapa2_POO_AdrianoRosa.models;

public class Molho {
	
	private Integer id;
	private String nome;
	private Double valor;
	
	public Molho() {
		super();
	}

	public Molho(Integer id, String nome, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
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

	@Override
	public String toString() {
		return nome;
	}

}

