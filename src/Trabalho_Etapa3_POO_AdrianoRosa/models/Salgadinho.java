package Trabalho_Etapa3_POO_AdrianoRosa.models;

import java.time.LocalDate;

public class Salgadinho extends Prato {
	
	private String recheio;
	private String massa;
	private String tipo;
	
	public Salgadinho() {
		super();
	}

	public Salgadinho(Integer id, String nome, Double precoVenda, LocalDate dataValidade, Double peso, String recheio,
			String massa, String tipo) {
		super(id, nome, precoVenda, dataValidade, peso);
		this.recheio = recheio;
		this.massa = massa;
		this.tipo = tipo;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public String getMassa() {
		return massa;
	}

	public void setMassa(String massa) {
		this.massa = massa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

