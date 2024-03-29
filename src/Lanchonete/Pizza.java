package Lanchonete;

import java.util.Date;

public class Pizza extends Prato {
	
	private String molho;
	private String recheio;
	private String borda;

	public Pizza(String ID, String nome, Double precoVenda, Date dataValidade, Double peso, String molho,
			String recheio, String borda) {
		super(ID, nome, precoVenda, dataValidade, peso);
		this.molho = molho;
		this.recheio = recheio;
		this.borda = borda;
	}

	public String getMolho() {
		return molho;
	}

	public void setMolho(String molho) {
		this.molho = molho;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public String getBorda() {
		return borda;
	}

	public void setBorda(String borda) {
		this.borda = borda;
	}
	
}
