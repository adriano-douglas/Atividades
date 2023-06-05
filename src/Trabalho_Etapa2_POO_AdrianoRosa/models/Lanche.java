package Trabalho_Etapa2_POO_AdrianoRosa.models;

import java.time.LocalDate;

public class Lanche extends Prato {
	
	private String pao;
	private String recheio;
	private String molho;
	
	public Lanche() {
		super();
	}

	public Lanche(Integer id, String nome, Double precoVenda, LocalDate dataValidade, Double peso, String pao,
			String recheio, String molho) {
		super(id, nome, precoVenda, dataValidade, peso);
		this.pao = pao;
		this.recheio = recheio;
		this.molho = molho;
	}

	public String getPao() {
		return pao;
	}

	public void setPao(String pao) {
		this.pao = pao;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public String getMolho() {
		return molho;
	}

	public void setMolho(String molho) {
		this.molho = molho;
	}

}

